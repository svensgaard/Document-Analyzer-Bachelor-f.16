/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzertfidf;

import Stemming.WordStemmer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class TextProcessor {

    WordStemmer stemmer;

    public TextProcessor() {
        stemmer = new WordStemmer();
        stemmer.setLangugage("english");
    }

    public HashMap<String, Integer> readFile(String fileName) {

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
            
            // Sort HashMap and return a LinkedHashMap
//            LinkedHashMap sorted = sortHashMapByValuesAInt(tempMap);

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

    /**
     * http://stackoverflow.com/questions/8119366/sorting-hashmap-by-values
     *
     * @param passedMap Map to sort
     * @return
     */
    public LinkedHashMap sortHashMapByValuesAInt(HashMap passedMap) {
        List mapKeys = new ArrayList(passedMap.keySet());
        List mapValues = new ArrayList(passedMap.values());
        Collections.sort(mapValues);
        Collections.reverse(mapValues);
        Collections.sort(mapKeys);
        Collections.reverse(mapKeys);

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

    public LinkedHashMap sortHashMapByValuesADouble(HashMap passedMap) {
        List mapKeys = new ArrayList(passedMap.keySet());
        List mapValues = new ArrayList(passedMap.values());
        Collections.sort(mapValues);
        Collections.reverse(mapValues);
        Collections.sort(mapKeys);
        Collections.reverse(mapKeys);

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
                    sortedMap.put((String) key, (Double) val);
                    break;
                }
            }
        }
        return sortedMap;
    }

}
