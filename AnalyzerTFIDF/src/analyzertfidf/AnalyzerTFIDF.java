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

        for (int i = 0; i < 4; i++) {
            String fileName = "EuroparlDaEn" + i;
            System.out.println("Processing: " + fileName);
            tempMap = tp.readFile(fileName);
            texts.add(new Text(fileName, new Keywords(tempMap)));
        }

        String fileName = "Physics1";
        System.out.println("Processing: " + fileName);
        tempMap = tp.readFile(fileName);
        texts.add(new Text(fileName, new Keywords(tempMap)));

        System.out.println("Processing Done\n");

        for (Text t : texts) {
            System.out.println(t.fileName + ", " + t.keywords.keywordMap.size());
        }

        System.out.println("-- IF-IDF weight processing --");

        for (Text t : texts) {
            termWeightMap = new HashMap<>();

            for (HashMap.Entry<String, Integer> entry : t.keywords.keywordMap.entrySet()) {
                termWeightMap.put(entry.getKey(), calculator.calculateTFIDF(entry.getKey(), t, texts));
            }

            t.keywords.TFIDFMap(tp.sortHashMapByValuesDouble(termWeightMap));
        }
        
        // top 3 most important words in each text
        for (Text t : texts) {
            System.out.println(t.fileName);
            Iterator it = t.keywords.keywordTFIDFMap.entrySet().iterator();
            for (int i = 0; i < 3; i++) {
                Map.Entry<String, Double> pair = (Map.Entry) it.next();
                System.out.println(pair.getKey() + ", " + pair.getValue());
            }
        }

//        for (Text t : texts) {
//            comparer.compareText(t);
//        }

//        for (HashMap.Entry<String, Double> entry : termWeightMap.entrySet()) {
//            if (entry.getValue() > 0) {
//                System.out.println(entry.getKey() + ", " + entry.getValue());
//            }
//        }
//        System.out.println("Text: " + texts.get(0).fileName);
//        for (HashMap.Entry<String, Integer> entry : texts.get(0).keywords.keywordMap.entrySet()) {
//            System.out.println("Word: " + entry.getKey() + ", " + entry.getValue());
//        }
//        System.out.println("Size: " + texts.get(0).keywords.keywordMap.size());
    }

}
