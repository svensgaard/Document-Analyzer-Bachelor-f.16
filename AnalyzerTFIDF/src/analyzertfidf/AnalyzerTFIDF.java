/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzertfidf;

import Kmeans.Centroid;
import Kmeans.Clustering;
import Kmeans.Comparer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

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

        for (int i = 44; i < 53; i++) {
            String fileName = "EuroparlDaEn" + i;
            System.out.println("Processing: " + fileName);
            tempMap = tp.readFile(fileName);
            texts.add(new Text(fileName, new Keywords(tempMap)));
        }

        for (int i = 1; i < 8; i++) {
            String fileName = "Physics" + i;
            System.out.println("Processing: " + fileName);
            tempMap = tp.readFile(fileName);
            texts.add(new Text(fileName, new Keywords(tempMap)));
        }
        for (int i = 1; i < 8; i++) {
            String fileName = "Dino" + i;
            System.out.println("Processing: " + fileName);
            tempMap = tp.readFile(fileName);
            texts.add(new Text(fileName, new Keywords(tempMap)));
        }

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

            t.keywords.keywordTFIDFMap = termWeightMap;
        }
        //Make a list of all distinct terms in the corpus
        ArrayList<String> distinctTerms = new ArrayList<>();
        for (Text t : texts) {
            Iterator it = t.keywords.keywordMap.entrySet().iterator();
            for (int i = 0; i < t.keywords.size(); i++) {
                Map.Entry<String, Integer> pair = (Map.Entry) it.next();
                if (!distinctTerms.contains(pair.getKey())) {
                    distinctTerms.add(pair.getKey());
                }
            }
        }
        //Initialize vectorspace in all texts
        for (Text t : texts) {
            t.vectorSpace = new Double[distinctTerms.size()];
            int count = 0;
            for (String s : distinctTerms) {
                if (t.keywords.keywordTFIDFMap.containsKey(s)) {
                    t.vectorSpace[count] = t.keywords.keywordTFIDFMap.get(s);
                } else {
                    t.vectorSpace[count] = 0.0;
                }
                count++;
            }
        }
        //Cluster texts
        Clustering clustering = new Clustering();
        ArrayList<Centroid> result = clustering.prepareCluster(3, texts, true);

        for (Centroid c : result) {
            System.out.println("\nCluster: ");
            for (Text t : c.GroupedDocument) {
                System.out.println(t.fileName);
            }
        }
        
        
        //Compare input to clusters
        System.out.println("Waiting for input...");
        Scanner scan = new Scanner(System.in);
        Text inputText = tp.readInput(scan.nextLine());
        //Calculate tfdif for input
        termWeightMap = new HashMap<>();

        for (HashMap.Entry<String, Integer> entry : inputText.keywords.keywordMap.entrySet()) {
            termWeightMap.put(entry.getKey(), calculator.calculateTFIDF(entry.getKey(), inputText, texts));
        }

        inputText.keywords.keywordTFIDFMap = termWeightMap;
        //Calculate vectorspace
        inputText.vectorSpace = new Double[distinctTerms.size()];
        int count = 0;
        for (String s : distinctTerms) {
            if (inputText.keywords.keywordTFIDFMap.containsKey(s)) {
                inputText.vectorSpace[count] = inputText.keywords.keywordTFIDFMap.get(s);
            } else {
                inputText.vectorSpace[count] = 0.0;
            }
            count++;
        }
        
        //Results of input
        Kmeans.Comparer kmeansComparer = new Comparer();

        int count2 = 1;
        for(Double d : kmeansComparer.getSimilarities(result, inputText)) {
            System.out.println("Similarity " + d + " with cluster "+ count2);
            count2++;
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
