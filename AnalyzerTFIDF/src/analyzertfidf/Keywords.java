/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzertfidf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Bryan
 */
public class Keywords {

    public HashMap<String, Integer> keywordMap;
    public HashMap<String, Double> keywordTFIDFMap;

    public Keywords(HashMap<String, Integer> keywords) {
        this.keywordMap = keywords;
    }

    public Keywords(Text t) {
        this.keywordMap = t.keywords.keywordMap;
        this.keywordTFIDFMap = t.keywords.keywordTFIDFMap;
    }

    public void TFIDFMap(HashMap<String, Double> keywordTFIDMap) {
        this.keywordTFIDFMap = keywordTFIDMap;
    }

    public boolean contains(String keyword) {
        return keywordMap.containsKey(keyword);
    }

    public double compare(Keywords k) {

        double difference = 0;
        double sumDifferences = 0;
        
        double a = 0;
        double b = 0;

        ArrayList<Double> differences = new ArrayList<>();

        for (Map.Entry<String, Double> entry : this.keywordTFIDFMap.entrySet()) {
            if (k.keywordTFIDFMap.containsKey(entry.getKey())) {
//                if (entry.getValue() > 0.0 && k.keywordTFIDFMap.get(entry.getKey()) > 0.0) {
//                    System.out.println("Keyword match: " + entry.getKey());
//                    System.out.println("A value: " + entry.getValue());
//                    System.out.println("B value: " + k.keywordTFIDFMap.get(entry.getKey()));
//                }
                a += entry.getValue();
                b += k.keywordTFIDFMap.get(entry.getKey());

            } else {
                difference = 0;
            }
            differences.add(difference);
        }
        
        System.out.println("A sum value: " + a);
        System.out.println("B sum value: " + b);
        System.out.println("------------");

        Collections.sort(differences);
        Collections.reverse(differences);

//        System.out.println("Size " + differences.size());
        // 100 most frequent words
        int mostFrequent = 100;
        for (int i = 0; i < mostFrequent; i++) {
            sumDifferences += differences.get(i);
        }

//        System.out.println("Sum of Differences: " + sumDifferences);
        return sumDifferences / (double) mostFrequent;
    }

//    public double compare(Keywords k) {
//
//        Iterator it = keywordMap.entrySet().iterator();
//        int count = 0;
//        int matches = 0;
//        
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry) it.next();
//            
//            if (k.keywordMap.containsKey(pair.getKey())) {
//                matches++;
//            }
//            
//            count++;
//        }
//        
//        return (double) matches/ (double) count;
//    }
    public int size() {
        return keywordMap.size();
    }

    public String toString() {
        String s = "";
        Iterator it = keywordMap.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            s += ("\n Word: " + pair.getKey() + ", " + pair.getValue());
        }

        return s;
    }

}
