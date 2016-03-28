/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kmeans;

import analyzertfidf.Text;
import java.util.ArrayList;

/**
 *
 * @author Mads
 */
public class Comparer {

    public Centroid compareTextAverage(ArrayList<Centroid> corpus, Text t) {
//        for(Double d : t.vectorSpace) {
//            System.out.println(d);
//        }
        Clustering clusterText = new Clustering();
        ArrayList<Centroid> nonEmptyClusters = new ArrayList<>();
        //Only look though clusters that are not empty
        for (Centroid c : corpus) {
            if (!c.GroupedDocument.isEmpty()) {
                nonEmptyClusters.add(c);
            }
        }
        int index = clusterText.findClosestClusterAverage(nonEmptyClusters, t);
        return corpus.get(index);
    }

    public Centroid compareTextCentroid(ArrayList<Centroid> corpus, Text t) {
        Clustering clusterText = new Clustering();
        ArrayList<Centroid> nonEmptyClusters = new ArrayList<>();
        //Only look though clusters that are not empty
        for (Centroid c : corpus) {
            if (!c.GroupedDocument.isEmpty()) {
                nonEmptyClusters.add(c);
            }
        }
        int index = clusterText.FindClosestClusterCenter(nonEmptyClusters, t);
        return corpus.get(index);
    }

    public ArrayList<Double> getSimilarities(ArrayList<Centroid> corpus, Text t) {
        SimilarityMatrics simMatrics = new SimilarityMatrics();
        ArrayList<Double> result = new ArrayList<>();
        for (Centroid c : corpus) {
            if (!c.GroupedDocument.isEmpty()) {
                result.add(simMatrics.findCosineSimilarity(c.getAverageVector(), t.vectorSpace));
            }
        }
        return result;
    }
}
