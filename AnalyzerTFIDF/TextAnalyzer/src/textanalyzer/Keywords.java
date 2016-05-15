/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textanalyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Bryan
 */
public class Keywords {

    TreeMap<String, Double> keywordMap;

    public Keywords(TreeMap<String, Double> keywords) {
        this.keywordMap = keywords;
    }

    public boolean contains(String keyword) {
        return keywordMap.containsKey(keyword);
    }

    public double compare(Keywords k) {

        Iterator it = keywordMap.entrySet().iterator();
        double difference = 0;
        double sumDifferences = 0;
        int count = 0;

        ArrayList<Double> differences = new ArrayList<>();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            if (k.keywordMap.containsKey(pair.getKey())) {
                difference = k.keywordMap.get(pair.getKey()) / (double) pair.getValue();
            } else {
                difference = 0;
            }
            differences.add(difference);

        }

        Collections.sort(differences);
        Collections.reverse(differences);
        
//        System.out.println("Size " + differences.size());

        // 100 most frequent words
        for (int i = 0; i < 100; i++) {
            
            sumDifferences += differences.get(i);
        }

        return sumDifferences / (double) 500;
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
//            s += ("\n Word: " + pair.getKey() + ", " + pair.getValue());
            s += pair.getKey() + " ";
        }
        return s;
    }

}
