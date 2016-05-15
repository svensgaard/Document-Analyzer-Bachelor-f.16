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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Mainly uses Countwords2 Splitsessions mostCommonWords
 *
 *
 * @author Bryan
 */
public class TextAnalyzer {

    ArrayList<String> commonWords;

    public TextAnalyzer() {
        commonWords = new ArrayList<>();
    }

    public void mostCommonWords() {

        try {
            FileReader fr = new FileReader("100MostUsedWords.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";

            while ((line = br.readLine()) != null) {
                commonWords.add(line.toLowerCase());
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void countWords(String readPath, String writePath) {
        ArrayList<Word> wordCount = new ArrayList<>();

        try {
            FileReader fr = new FileReader(readPath);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(writePath)));

            String line = "";

            while ((line = br.readLine()) != null) {

                String[] s = line.split("[\\p{Punct}\\s]+|\\d");
                Word w;
                for (String word : s) {
                    w = new Word(word);
                    if (wordCount.contains(w)) {
                        wordCount.get(wordCount.indexOf(w)).increment();
                    } else {
                        wordCount.add(w);
                    }
                }
            }

            Collections.sort(wordCount);
            Collections.reverse(wordCount);

            for (Word w : wordCount) {
                bw.write("Count: " + w.count + "\t | Word: " + w.getWord() + "\n");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void numWords(String readPath, String writePath) {
        ArrayList<Word> wordCount = new ArrayList<>();

        try {
            FileReader fr = new FileReader(readPath);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(writePath)));

            String line = "";

            while ((line = br.readLine()) != null) {

                String[] s = line.split("\\-|\\.|\\,|\\s+|\\t+|\\?|\\!|\\(|\\)");
                Word w;
                for (String word : s) {
                    if (word.length() > 3) {
                        w = new Word(word);
                        if (wordCount.contains(w)) {
                        } else {
                            wordCount.add(w);
                        }
                    }
                }
            }

            Collections.sort(wordCount);
            Collections.reverse(wordCount);

            for (Word w : wordCount) {
                System.out.println("Word: " + w.word);
            }
            System.out.println("Count: " + wordCount.size());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // OLD
    public TreeMap<String, Double> countWords2(BufferedReader br) {

        HashMap<String, Double> words = new HashMap<>();
        TreeMap<String, Double> words2 = new TreeMap<>();

        try {

            String line = "";
            double count = 0;

            while ((line = br.readLine()) != null) {

                String[] s = line.toLowerCase().split("[\\p{Punct}\\s]+|\\d");
                for (String word : s) {
                    if (word.length() >= 2) {
                        if (!commonWords.contains(word)) {
                            if (words.containsKey(word)) {
                                words.put(word, words.get(word) + 1);
                            } else {
                                words.put(word, 1.0);
                            }
                        }
                    }
                }
                count++;
            }

            // calculate average frequencies
            Iterator it = words.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();

                words2.put(pair.getKey().toString(), ((double) pair.getValue() / count));
            }

//            System.out.println("TREEMAP ----- \n" + words2);
//            System.out.println(entriesSortedByValues(words2));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return words2;
    }

    static <K, V extends Comparable<? super V>>
            SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
                new Comparator<Map.Entry<K, V>>() {
                    @Override
                    public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

//    public void wordPopulation(String inFile, String outFileName, int n) {
//
//        try {
//            BufferedReader br;
//
//            for (int i = 0; i < n; i++) {
//                br = new BufferedReader(new FileReader(inFile + i + ".txt"));
//                countWords2(br);
//            }
//
//            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File(outFileName))));
//
//            System.out.println("Map size: " + words.size());
//            
//            Iterator it = words.entrySet().iterator();
//            
//            while (it.hasNext()) {
//                Map.Entry pair = (Map.Entry) it.next();
//                out.println(pair.getKey() + " = " + pair.getValue());
//                it.remove(); // avoids a ConcurrentModificationException
//            }
//            
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public static void splitSessions(String readPath, String newFileName) {

        try {
            File file;
            FileReader fr = new FileReader(readPath);
            BufferedReader br = new BufferedReader(fr);
            PrintWriter out = null;

            int count = 0;
            String line = "";

            while ((line = br.readLine()) != null) {
                if (line.contains("Resumption of the session")) {
                    file = new File(newFileName + String.valueOf(count) + ".txt");
                    out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                    count++;
                }
                out.println(line);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void firstWords() {

    }

    // USED FOR GENERATING TRAINING DATA (WORDS)
    public void countWordsTraining(BufferedReader br, ArrayList<String> words) {

        try {

            String line = "";

            while ((line = br.readLine()) != null) {

                String[] s = line.toLowerCase().split("[\\p{Punct}\\s]+|\\d");
                for (String w : s) {
                    if (w.length() >= 2) {
                        if (!commonWords.contains(w)) {
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
}
