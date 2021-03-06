/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzertfidf;

import GUI.MainFrame;
import Kmeans.Centroid;
import Stemming.WordStemmer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class TextProcessor {

    ArrayList<String> mostCommon100Words;
    WordStemmer stemmer = new WordStemmer();

    public TextProcessor() {
        readCommonWords();
    }

    private void readCommonWords() {
        mostCommon100Words = new ArrayList<>();
        stemmer = new WordStemmer();
        stemmer.setLangugage("english");

        //Read 100 most common
        try {
            FileReader fr = new FileReader(new File("100MostUsedWords.txt"));
//            FileReader fr = new FileReader(new File("top200words.txt"));
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                mostCommon100Words.add(stemmer.stem(line).toLowerCase());
            }

        } catch (FileNotFoundException ex) {
            throw new Error(ex.getMessage());
        } catch (IOException ex) {
            throw new Error(ex.getMessage());
        }
        //Read 200 most common
//         try {
//            FileReader fr = new FileReader(new File("top200words.txt"));
//            BufferedReader br = new BufferedReader(fr);
//            String line = "";
//
//            while ((line = br.readLine()) != null) {
//                mostCommon200Words.add(stemmer.stem(line).toLowerCase());
//            }
//
//        } catch (FileNotFoundException ex) {
//            throw new Error(ex.getMessage());
//        } catch (IOException ex) {
//            throw new Error(ex.getMessage());
//        }
    }

    public HashMap readFileActual(String path) {
        // Read file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            HashMap<String, Integer> tempMap = new HashMap<>();
            String line = "";
            String stem = "";

            // Split symbols
            while ((line = reader.readLine()) != null) {
                String[] wordArray = line.toLowerCase().split("[\\d\\p{Punct}\\s]+");

                // Generate HashMap with keys and values
                for (String word : wordArray) {
                    // Remove letters
                    if (word.length() > 1) {

                        // Stem word
                        stem = stemmer.stem(word);

                        // Increment if word is known
                        if (tempMap.containsKey(stem)) {
                            tempMap.put(stem, tempMap.get(stem) + 1);
                        } else {
                            // Add new word and frequency to map
                            tempMap.put(stem, 1);
                        }

                    }
                }
            }

//            writeToFile(fileName, sorted);
            // Sort HashMap and return a LinkedHashMap
            return tempMap;

        } catch (IOException e) {
            e.printStackTrace();
            throw new Error("Reading File Exception", e);
        }
    }

    public HashMap readFile(String fileName) {
        // Read file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));

            HashMap<String, Integer> tempMap = new HashMap<>();
            String line = "";
            String stem = "";

            // Split symbols
            while ((line = reader.readLine()) != null) {
                String[] wordArray = line.toLowerCase().split("[\\d\\p{Punct}\\s]+");

                // Generate HashMap with keys and values
                for (String word : wordArray) {
                    // Remove letters
                    if (word.length() > 1) {

                        // Stem word
                        stem = stemmer.stem(word).toLowerCase();

                        // Increment if word is known
                        if (tempMap.containsKey(stem)) {
                            tempMap.put(stem, tempMap.get(stem) + 1);
                        } else {
                            // Add new word and frequency to map
                            tempMap.put(stem, 1);
                        }

                    }
                }
            }

            return tempMap;

        } catch (IOException e) {
            throw new Error("Reading File Exception", e);
        }
    }

    public HashMap readFileWith100MostCommon(String filePath) {
        //Read common words
        if (mostCommon100Words == null) {
            readCommonWords();
        }
        // Read file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            HashMap<String, Integer> tempMap = new HashMap<>();
            String line = "";
            String stem = "";

            // Split symbols
            while ((line = reader.readLine()) != null) {
                String[] wordArray = line.toLowerCase().split("[\\d\\p{Punct}\\s]+");

                // Generate HashMap with keys and values
                for (String word : wordArray) {
                    // Remove letters
                    if (word.length() > 1) {

                        // Stem word
                        stem = stemmer.stem(word).toLowerCase();
                        //Check if word is common
                        if (!mostCommon100Words.contains(stem)) {
                            // Increment if word is known
                            if (tempMap.containsKey(stem)) {
                                tempMap.put(stem, tempMap.get(stem) + 1);
                            } else {
                                // Add new word and frequency to map
                                tempMap.put(stem, 1);
                            }
                        }

                    }
                }
            }

            return tempMap;

        } catch (IOException e) {
            throw new Error("Reading File Exception", e);
        }
    }

    public void writeToFile(String fileName, HashMap<String, Integer> keywords) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName + "keywords.txt")));

        for (HashMap.Entry<String, Integer> entry : keywords.entrySet()) {
            bw.write(entry.getKey() + ", " + entry.getValue() + "\n");
        }
        bw.close();

    }

    public HashMap findKeywords(BufferedReader br) throws IOException {

        HashMap<String, Integer> tempMap = new HashMap<>();
        String line = "";
        String stem = "";

        // Split symbols
        while ((line = br.readLine()) != null) {
            String[] wordArray = line.toLowerCase().split("[\\d\\p{Punct}\\s]+");

            // Generate HashMap with keys and values
            for (String word : wordArray) {
                // Remove letters
                if (word.length() > 1) {
                    // Remove most common words
                    if (!mostCommon100Words.contains(word)) {

                        // Stem word
                        stem = stemmer.stem(word);

                        // Increment if word is known
                        if (tempMap.containsKey(stem)) {
                            tempMap.put(stem, tempMap.get(stem) + 1);
                        } else {
                            // Add new word and frequency to map
                            tempMap.put(stem, 1);
                        }
                    }
                }
            }
        }

        // Sort HashMap and return a LinkedHashMap
        return tempMap;
    }

    /**
     * http://stackoverflow.com/questions/8119366/sorting-hashmap-by-values
     *
     * @param passedMap Map to sort
     * @return
     */
    public LinkedHashMap sortHashMapByValuesD(HashMap passedMap) {
        List mapKeys = new ArrayList(passedMap.keySet());
        List mapValues = new ArrayList(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap sortedMap = new LinkedHashMap();

        Iterator valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Object val = valueIt.next();
            Iterator keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Object key = keyIt.next();
                String comp1 = passedMap.get(key).toString();
                String comp2 = val.toString();

                if (comp1.equals(comp2)) {
                    passedMap.remove(key);
                    mapKeys.remove(key);
                    sortedMap.put((String) key, (Integer) val);
                    break;
                }
            }
        }
        return sortedMap;
    }

    public Text readInput(String input) {
        try {
            InputStream is = new ByteArrayInputStream(input.getBytes());

            // read it with BufferedReader
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            HashMap<String, Integer> tempMap = new HashMap<>();
            String line = "";
            String stem = "";

            // Split symbols
            while ((line = reader.readLine()) != null) {
                String[] wordArray = line.toLowerCase().split("[\\d\\p{Punct}\\s]+");

                // Generate HashMap with keys and values
                for (String word : wordArray) {
                    // Remove letters
                    if (word.length() > 1) {

                        // Stem word
                        stem = stemmer.stem(word);

                        // Increment if word is known
                        if (tempMap.containsKey(stem)) {
                            tempMap.put(stem, tempMap.get(stem) + 1);
                        } else {
                            // Add new word and frequency to map
                            tempMap.put(stem, 1);
                        }

                    }
                }
            }
            //Create text object
            Text inputText = new Text("Input", new Keywords(tempMap));
            // Sort HashMap and return a LinkedHashMap
            return inputText;

        } catch (IOException e) {
            throw new Error("Reading File Exception", e);
        }
    }

    /**
     * Generates training data from clusters
     *
     * @throws IOException
     */
    public void generateTrainingData(ArrayList<Centroid> clusters, String path) throws IOException {

        // MAKE SURE DIR IS FRESH
        Files.walk(Paths.get("./resources/datasets")).forEach(fp -> {
            if (Files.isRegularFile(fp)) {
                try {
                    Files.deleteIfExists(fp);
                } catch (IOException ex) {
                    Logger.getLogger(TextProcessor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        BufferedReader br;
        BufferedWriter bw;

        int i = 0;
        System.out.println("CLUSTER SIZE: " + clusters.size());
        // Iterate through all clusters
        for (Centroid c : clusters) {

            // Create dataset for cluster
            String fileName = c.name + ".txt";
            bw = new BufferedWriter(new FileWriter(new File("./resources/datasets/" + fileName)));

            // Iterate through all texts in clusters
            for (Text t : c.GroupedDocument) {
//                br = new BufferedReader(new FileReader(path + "/" + t.fileName));
                br = new BufferedReader(new FileReader(t.path));

                String line = "";

                while ((line = br.readLine()) != null) {

                    String[] s = line.toLowerCase().split("[\\p{Punct}\\s]+|\\d");
                    for (String w : s) {
                        bw.write(w + " ");
                    }
                }

                // Write to dataset
                bw.write("\n");
            }
            bw.close();
            i++;
        }
    }

    /**
     * Used in MAIN FRAME
     *
     * Reads input file, and returns it as a string
     *
     * @return
     */
    public String readFileToString(String path) {
        try {
            System.out.println("LOG: Trying to read file");
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line = "";
            String text = "";
            
            while ((line = reader.readLine()) != null) {
                text += line;
            }
            System.out.println("LOG: READ FILE DONE");
            return text;

        } catch (IOException e) {
            e.printStackTrace();
            throw new Error("Reading File Exception", e);
        }
    }

}
