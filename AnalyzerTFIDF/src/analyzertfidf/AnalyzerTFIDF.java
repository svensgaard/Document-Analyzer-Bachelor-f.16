/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzertfidf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Bryan
 */
public class AnalyzerTFIDF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextProcessor tp = new TextProcessor();
        TFIDF calculator = new TFIDF();
        TextComparer comparer = new TextComparer();

        ArrayList<Text> texts = new ArrayList<>();
        ArrayList<Double> termWeights = new ArrayList<>();
        HashMap<String, Double> termWeightMap;
        HashMap<String, Integer> tempMap = new HashMap<>();

        // -------- READING FILES --------
        for (int i = 0; i < 4; i++) {
            String fileName = "EuroparlDaEn" + i;
            System.out.println("Reading: " + fileName);
            tempMap = tp.readFile(fileName);
            texts.add(new Text(fileName, new Keywords(tempMap)));
        }

        String fileName = "Physics1";
        System.out.println("Reading: " + fileName);
        tempMap = tp.readFile(fileName);
        texts.add(new Text(fileName, new Keywords(tempMap)));

        System.out.println("Reading Done\n");

        for (Text t : texts) {
            System.out.println(t.fileName + ", Words: " + t.keywords.keywordMap.size());
        }

        // -------- Calculating TF-IDF --------
        System.out.println("-- TF-IDF weight processing --");

        ArrayList<String> words = new ArrayList<>();

        for (Text t : texts) {
            termWeightMap = new HashMap<>();

            for (HashMap.Entry<String, Integer> entry : t.keywords.keywordMap.entrySet()) {
                // Add key to word array
                if (!words.contains(entry.getKey())) {
                    words.add(entry.getKey());
                }

                // Calculate TF-IDF
                termWeightMap.put(entry.getKey(), calculator.calculateTFIDF(entry.getKey(), t, texts));
            }
            
            t.keywords.TFIDFMap(termWeightMap);

        }

        System.out.println("TOTAL WORD COUNT: " + words.size());

        // -------- Generating Corpora --------
    }

}
