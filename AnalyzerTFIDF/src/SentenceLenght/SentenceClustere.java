/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SentenceLenght;

import Kmeans.Centroid;
import Kmeans.SimilarityMatrics;
import analyzertfidf.Text;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 *
 * @author Mads
 */
public class SentenceClustere {

    private int globalCounter = 0;
    private int counter;
    public int publicCounter;

    //k is number of clusters.
    public ArrayList<Centroid> prepareCluster(int k, ArrayList<Text> texts) {
        globalCounter = 0;
        ArrayList<Centroid> centroids = new ArrayList<>();
        Centroid x;
        //Choose 3 centroids at random
        HashSet<Integer> uniqNumber = generateRandomNumbers(k, texts.size());
        for (Integer i : uniqNumber) {
            x = new Centroid();
            x.GroupedDocument = new ArrayList<>();
            x.GroupedDocument.add(texts.get(i));
            centroids.add(x);
        }
        Boolean stop;
        ArrayList<Centroid> result;
        ArrayList<Centroid> previousClusterCenter;
        result = InitializeClusterCentroid(centroids.size());

        do { //Continue until stop criteria are met.
            previousClusterCenter = centroids;

            for (Text t : texts) {
                int i = FindClosestClusterCenter(centroids, t);
                result.get(i).GroupedDocument.add(t);
            }
//            centroids = InitializeClusterCentroid(centroids.size());
//           centroids = CalculateMeanPoints(result);
            stop = CheckStop(previousClusterCenter, centroids);
            if (!stop) {
                result = InitializeClusterCentroid(centroids.size());
            }
        } while (stop == false);
        publicCounter = counter;
        return result;

    }

    private HashSet<Integer> generateRandomNumbers(int k, int size) {
        HashSet<Integer> uniqRandom = new HashSet<>();
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 1; i < size; i++) {
            randomNumbers.add(i);
        }
        Collections.shuffle(randomNumbers);
        for (int i = 0; i < k; i++) {
            uniqRandom.add(randomNumbers.get(i));
        }

        return uniqRandom;
    }

    private ArrayList<Centroid> InitializeClusterCentroid(int size) {
        Centroid c;
        ArrayList<Centroid> centroid = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            c = new Centroid();
            c.GroupedDocument = new ArrayList<>();
            centroid.add(c);
        }
        return centroid;

    }

    public int FindClosestClusterCenter(ArrayList<Centroid> centroids, Text t) {
        SentenceComparer sentenceComparer = new SentenceComparer();
        Double[] tfdif = new Double[centroids.size()];
        for (int i = 0; i < centroids.size(); i++) {
//            tfdif[i] = sentenceComparer.findCosineSimilarity(centroids.get(i).GroupedDocument.get(0).getVectorSpace(), t.getVectorSpace());
            tfdif[i] = sentenceComparer.findSentenceSimilarity(centroids.get(i).getAverageSentenceLength(), t.averageSentenceLength);

        }

        int index = 0;
        Double maxFound = tfdif[0];
        for (int i = 0; i < tfdif.length; i++) {
            if (tfdif[i] < maxFound) {
                maxFound = tfdif[i];
                index = i;
            }
        }
        return index;
    }

//    private ArrayList<Centroid> CalculateMeanPoints(ArrayList<Centroid> result) {
//        for (Centroid centroid : result) {
//            if (result.get(i).GroupedDocument.size() > 0) {
//                for (int k = 0; k < result.get(i).GroupedDocument.get(0).getVectorSpace().length; k++) {
//                    Double total = 0.0;
//
//                    for (Text t : result.get(i).GroupedDocument) {
//                        total += t.getVectorSpace()[k];
//                    }
//                    result.get(i).GroupedDocument.get(0).getVectorSpace()[k] = total / result.get(i).GroupedDocument.size();
//                }
//               
//            }
//            centroid.
//        }
//        return result;
//    }

    private Boolean CheckStop(ArrayList<Centroid> previousClusterCenter, ArrayList<Centroid> centroids) {
        globalCounter++;
        counter = globalCounter;
        Boolean stop = false;
        if (globalCounter > 1000) {

            return true;
        } else {
            Integer[] changeIndex = new Integer[centroids.size()];
            int index = 0;

            do {

                
                if (centroids.get(index).GroupedDocument.isEmpty() && previousClusterCenter.get(index).GroupedDocument.isEmpty()) {
                    changeIndex[index] = 0;
                    index++;
                } else if (!centroids.get(index).GroupedDocument.isEmpty() && !previousClusterCenter.get(index).GroupedDocument.isEmpty()) {
                  
                    //If change in averageSentenceLength something changed.
                    if(!centroids.get(index).getAverageSentenceLength().equals(previousClusterCenter.get(index).getAverageSentenceLength())) {
                        changeIndex[index] = 1;
                    } else {
                        changeIndex[index] = 0;
                    }
                    index++;
                } else {
                    //Set change to one if one is empty and the other is not
                    changeIndex[index] = 1;
                    index++;
                }

            } while (index < centroids.size());
//            If any index contains 1
            for (int i : changeIndex) {
                if (i == 1) {
                    stop = true;
                }
            }
        }
        return stop;
    }

    //Uses the average vectorspacemodel instead of the centroids.
    public int findClosestClusterAverage(ArrayList<Centroid> centroids, Text t) {
        SentenceComparer sentenceComparer = new SentenceComparer();
        Double[] tfdif = new Double[centroids.size()];
        for (int i = 0; i < centroids.size(); i++) {
            tfdif[i] = sentenceComparer.findSentenceSimilarity(centroids.get(i).getAverageSentenceLength(), t.averageSentenceLength);
        }

        int index = 0;
        Double maxFound = tfdif[0];
        for (int i = 0; i < tfdif.length; i++) {
            if (tfdif[i] < maxFound) {

                maxFound = tfdif[i];
                index = i;
            }
        }
        return index;
    }
}
