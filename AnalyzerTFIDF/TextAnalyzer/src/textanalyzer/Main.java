/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textanalyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class Main {

    public void oldRun() {
        TextAnalyzer ta = new TextAnalyzer();
        ta.mostCommonWords();

        ArrayList<Text> texts = new ArrayList<>();

        // Read EuroParl texts
        BufferedReader br;
        Random rand = new Random();

        System.out.println("Reading Europarl");
        for (int i = 0; i < 20; i++) {
            try {
                int j = rand.nextInt(204);
                br = new BufferedReader(new FileReader("EuroParlDaEn" + j + ".txt"));
                String name = "EuroParlDaEn" + j + ".txt";
                texts.add(new Text(name, new Keywords(ta.countWords2(br))));
//                System.out.println("Europarl Keywords size: " + texts.get(i).keywords.size());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

//      Read Physics texts
        System.out.println("Reading Physics");
        for (int i = 1; i <= 7; i++) {
            try {
                br = new BufferedReader(new FileReader("Physics" + i + ".txt"));
                String name = "Physics" + i + ".txt";
                texts.add(new Text(name, new Keywords(ta.countWords2(br))));
//                System.out.println("Physics Keywords size: " + texts.get(i).keywords.size());

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        CorpusCompare comparer = new CorpusCompare();

        System.out.println("Comparing");
        // Compare texts - generates the different corpora
        for (Text t : texts) {
            comparer.compareTexts(t);
        }
//        System.out.println("Corpora size: " + comparer.corpora.size());

        // IDÉ - SAMMENLIGN CORPUS
//        for (Corpus c : comparer.corpora) {
//            comparer.compareCorpus(c);
//        }
        comparer.getInfo();
        System.out.println("---------------");

//        comparer.getInfoTemp();
//        System.out.println(comparer.corpora.get(0).toString());
//        
//        System.out.println("Printing Results \n");
//        // Print corpora
//        System.out.println(comparer.toString());
    }

    public void newRun() throws IOException {
        TextAnalyzer ta = new TextAnalyzer();
        ta.mostCommonWords();

        ArrayList<String> words = new ArrayList<>();

        // Generate Political Training data
        BufferedReader br;
        BufferedWriter bw;

        System.out.println("Reading Europarl");
        for (int i = 0; i < 50; i++) {
            System.out.println("Reading EuroParl" + i);

            try {

                br = new BufferedReader(new FileReader("EuroParlDaEn" + i + ".txt"));

                String line = "";

                while ((line = br.readLine()) != null) {

                    String[] s = line.toLowerCase().split("[\\p{Punct}\\s]+|\\d");
                    for (String w : s) {
                        if (w.length() >= 2) {
                            if (!ta.commonWords.contains(w)) {
                                if (!words.contains(w)) {
                                    words.add(w);
                                }
                            }
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Write words to training file
        bw = new BufferedWriter(new FileWriter(new File("training.politics.en.txt")));
        for (String w : words) {
            bw.write(w + "\n");
        }

        // Generate Physics training data
        words = new ArrayList<>();
        System.out.println("Reading Physics");
        for (int i = 1; i <= 7; i++) {
            try {
                System.out.println("Reading Physics" + i);
                br = new BufferedReader(new FileReader("Physics" + i + ".txt"));
                String line = "";

                while ((line = br.readLine()) != null) {

                    String[] s = line.toLowerCase().split("[\\p{Punct}\\s]+|\\d");
                    for (String w : s) {
                        if (w.length() >= 2) {
                            if (!ta.commonWords.contains(w)) {
                                if (!words.contains(w)) {
                                    words.add(w);
                                }
                            }
                        }
                    }
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        bw = new BufferedWriter(new FileWriter(new File("training.physics.en.txt")));
        for (String w : words) {
            bw.write(w + "\n");
        }

    }

    public void newRun2() throws IOException {
        TextAnalyzer ta = new TextAnalyzer();
        ta.mostCommonWords();

        ArrayList<String> words = new ArrayList<>();

        // Generate Political Training data
        BufferedReader br;
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("training.politics.en.txt")));

        System.out.println("Reading Europarl");
        for (int i = 0; i < 10; i++) {
            System.out.println("Reading EuroParl" + i);

            try {

                br = new BufferedReader(new FileReader("EuroParlDaEn" + i + ".txt"));

                String line = "";

                while ((line = br.readLine()) != null) {

                    String[] s = line.toLowerCase().split("[\\p{Punct}\\s]+|\\d");
                    for (String w : s) {
                        bw.write(w + " ");
                    }
                }
                bw.write("\n");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Generate Physics training data
        words = new ArrayList<>();
        bw = new BufferedWriter(new FileWriter(new File("training.physics.en.txt")));

        System.out.println("Reading Physics");
        for (int i = 1; i <= 7; i++) {
            try {
                System.out.println("Reading Physics" + i);
                br = new BufferedReader(new FileReader("Physics" + i + ".txt"));
                String line = "";

                while ((line = br.readLine()) != null) {

                    String[] s = line.toLowerCase().split("[\\p{Punct}\\s]+|\\d");
                    for (String w : s) {
                        bw.write(w + " ");
                    }
                }
                bw.write("\n");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void newRun3() throws IOException {
        TextAnalyzer ta = new TextAnalyzer();
        ta.mostCommonWords();

        // Generate Political Training data
        BufferedReader br;
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("training.legal.en.txt")));

        System.out.println("Reading LegalEss");
        for (int i = 0; i < 9; i++) {

            try {

                br = new BufferedReader(new FileReader("LegalEss" + i + ".txt"));

                String line = "";

                while ((line = br.readLine()) != null) {

                    String[] s = line.toLowerCase().split("[\\p{Punct}\\s]+|\\d");
                    for (String w : s) {
                        bw.write(w + " ");
                    }
                }
                bw.write("\n");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        bw.close();
    }

    public void runFirstWords(String fileName, int times) {
        try {

            TextAnalyzer ta = new TextAnalyzer();
            ta.mostCommonWords();

            // Extract first word in each sentence
            BufferedReader br;
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("TestFirstWords" + fileName + ".txt")));

            System.out.println("Reading " + fileName);
            for (int i = 0; i < times; i++) {

                br = new BufferedReader(new FileReader(fileName + i + ".txt"));

                String line = "";
                StringBuilder sb = new StringBuilder(line);

                while ((line = br.readLine()) != null) {
                    sb.append(line);
//                    bw.write(s[0]);
//                    for (String w : s) {
//                        bw.write(w + " ");
//                    }
                }
                String text = sb.toString();
                String[] sentences = text.split("\\. ");
                String[] words = null;

                for (String s : sentences) {
                    words = s.split("\\s");
                    if (!words[0].matches(".*\\d+.*")) {
                        // Print/Write the first word of the sentence
                        bw.write(words[0] + "\n");
//                        System.out.println(words[0] + "\n");
                    }
                }

                bw.write("\n");
            }
            bw.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void runFirstWordsHash(String fileName, int times) {
        try {

            TextAnalyzer ta = new TextAnalyzer();
            ta.mostCommonWords();

            // Extract first word in each sentence
            BufferedReader br;
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("TestFirstWords" + fileName + ".txt")));
            HashMap<String, Integer> wordMap = new HashMap<>();

            System.out.println("Reading " + fileName);
            for (int i = 0; i < times; i++) {

                br = new BufferedReader(new FileReader(fileName + i + ".txt"));

                String line = "";
                StringBuilder sb = new StringBuilder(line);

                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                String text = sb.toString();
                String[] sentences = text.split("\\. ");
                String[] words = null;
                String word = "";

                for (String s : sentences) {
                    words = s.split("\\s");
                    word = words[0].toLowerCase();
                    if (!word.matches(".*\\d+.*")) {
                        // Print/Write the first word of the sentence
                        if (wordMap.containsKey(word.toLowerCase())) {
                            wordMap.put(word.toLowerCase(), wordMap.get(word) + 1);
                        } else {
                            wordMap.put(word, 1);
                        }
                    }
                }
            }

            bw.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bayesRun(BayesClassifier bc) {
        TextAnalyzer ta = new TextAnalyzer();
        ta.mostCommonWords();

        ArrayList<Text> texts = new ArrayList<>();

        // Read EuroParl texts
        BufferedReader br;
        Random rand = new Random();

        System.out.println("Reading Europarl");
        for (int i = 0; i < 10; i++) {
            try {
                int j = rand.nextInt(204);
                br = new BufferedReader(new FileReader("EuroParlDaEn" + j + ".txt"));
                String name = "EuroParlDaEn" + j + ".txt";
                texts.add(new Text(name, new Keywords(ta.countWords2(br))));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        // Read Physics texts
        System.out.println("Reading Physics");
        for (int i = 1; i < 8; i++) {
            try {
                br = new BufferedReader(new FileReader("Physics" + i + ".txt"));
                String name = "Physics" + i + ".txt";
                texts.add(new Text(name, new Keywords(ta.countWords2(br))));

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        // Read Physics texts
        System.out.println("Reading LegalEss");
        for (int i = 0; i < 9; i++) {
            try {
                br = new BufferedReader(new FileReader("LegalEss" + i + ".txt"));
                String name = "LegalEss" + i + ".txt";
                texts.add(new Text(name, new Keywords(ta.countWords2(br))));

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        CorpusCompare comparer = new CorpusCompare(bc);

        Collections.shuffle(texts);

        System.out.println("Comparing: " + texts.size() + "Documents");
        long start = System.currentTimeMillis();
        // Compare texts - generates the different corpora
        for (Text t : texts) {
            comparer.compareTextsBayes(t);
        }
        long end = System.currentTimeMillis();

        comparer.getInfoBayes();
        System.out.println("---------------");

        System.out.println("Comparing Time: " + (end - start));

    }

    public void bayesRunResult(BayesClassifier bc, int times) {
        TextAnalyzer ta = new TextAnalyzer();
        ta.mostCommonWords();
        DecimalFormat df = new DecimalFormat("#.##");

        ArrayList<Text> texts = new ArrayList<>();

        CorpusCompare comparer;
        BufferedReader br;
        Random rand = new Random();

        for (int k = 0; k < times; k++) {
//            System.out.println("Reading Politics");
            for (int i = 0; i < 10; i++) {
                try {
                    int j = rand.nextInt(203);
                    br = new BufferedReader(new FileReader("EuroParlDaEn" + j + ".txt"));
                    String name = "EuroParlDaEn" + j + ".txt";
                    texts.add(new Text(name, new Keywords(ta.countWords2(br)), "Politics"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            // Read Physics texts
//        System.out.println("Reading Physics");
            for (int i = 1; i < 5; i++) {
                try {
                    int j = rand.nextInt(7);
                    br = new BufferedReader(new FileReader("Physics" + i + ".txt"));
                    String name = "Physics" + i + ".txt";
                    texts.add(new Text(name, new Keywords(ta.countWords2(br)), "Physics"));

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            // Read Legal texts
//        System.out.println("Reading Legal");
            for (int i = 0; i < 5; i++) {
                try {
                    int j = rand.nextInt(8);
                    br = new BufferedReader(new FileReader("LegalEss" + i + ".txt"));
                    String name = "LegalEss" + i + ".txt";
                    texts.add(new Text(name, new Keywords(ta.countWords2(br)), "Legal"));

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            comparer = new CorpusCompare(bc);

            Collections.shuffle(texts);

//        System.out.println("Comparing: " + texts.size() + "Documents");
//        long start = System.currentTimeMillis();
            // Compare texts - generates the different corpora
//            for (Text t : texts) {
//                comparer.compareTextsBayes(t);
//            }

//            for (Text t : texts) {
//                comparer.compareTextsBayesSingle(t);
//            }

            int correct = 0;
            int totalDocs = 0;

            for (Corpus c : comparer.corpora) {
                totalDocs += c.texts.size();
                for (Text t : c.texts) {
                    if (t.expectedType == c.name) {
                        correct++;
                    }
                }
            }

            double accuracy = (double) correct / (double) totalDocs;

            System.out.println("Corpus1 size: " + comparer.corpora.get(0).texts.size());
            System.out.println("Accuracy: " + df.format(accuracy));
            System.out.println("Correct: " + correct + " :: Total " + totalDocs + "\n");

//        long end = System.currentTimeMillis();
//        comparer.getInfoBayes();
//        System.out.println("---------------");
//        System.out.println("Comparing Time: " + (end - start));
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Main m = new Main();
        BayesClassifier classifier = new BayesClassifier();

//        try {
//        m.runFirstWordsHash("LegalEss", 9);
//        m.runFirstWordsHash("EuroParlDaEn", 9);
//        m.newRun2(); // GENERATE TRAINING DATA
//        m.newRun3(); // GENERATE TRAINING DATA
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        m.bayesRun(classifier);// GENERATE CORPUS
        m.bayesRunResult(classifier, 2);// TEST GENERATION
    }

}
