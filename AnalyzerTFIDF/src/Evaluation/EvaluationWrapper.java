/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evaluation;

import Kmeans.Centroid;
import Kmeans.SimilarityMatrics;
import analyzertfidf.Text;
import java.util.ArrayList;

/**
 *
 * @author Mads
 */
public class EvaluationWrapper {

    SimilarityMatrics simMatrics = new SimilarityMatrics();

    public EvaluationWrapper() {

    }

    public double getAvgSimilarity(ArrayList<Centroid> clusters) {
        int numberOfTexts = 0;
        double totalSimilarity = 0.0;
        if (clusters != null) {
            for (Centroid c : clusters) {
                //Add texts to total
                numberOfTexts += c.GroupedDocument.size();
                //Count similarity
                for (Text t : c.GroupedDocument) {
                    totalSimilarity += simMatrics.findCosineSimilarity(c.getAverageVector(), t.getVectorSpace());
                }
            }
        }

        return totalSimilarity / (double) numberOfTexts;
    }

    public double getAvgDistance(ArrayList<Centroid> clusters) {

        int numberOfTexts = 0;
        double totalDistance = 0.0;
        for (Centroid c : clusters) {
            //Add texts to total
            numberOfTexts += c.GroupedDocument.size();
            //Count similarity
            if (c.getAverageVector().length != 0) {
                for (Text t : c.GroupedDocument) {

                    totalDistance += getDistance(t.getVectorSpace(), c.getAverageVector());
                }
            }

        }
        return totalDistance / (double) numberOfTexts;

    }

    private double getDistance(Double[] vector1, Double[] vector2) {

        double diff_square_sum = 0.0;
        if (vector1.length > 0 && vector2.length > 0) {
            for (int i = 0; i < vector1.length; i++) {
                diff_square_sum += (vector1[i] - vector2[i]) * (vector1[i] - vector2[i]);
            }
        }
        return Math.sqrt(diff_square_sum);
    }

    public double getAvgInterClusterDist(ArrayList<Centroid> result) {
        if (result.size() > 1) {
            double totalDistance = 0.0;
            for (Centroid c : result) {
                totalDistance += getDistance(result.get(0).getAverageVector(), c.getAverageVector());
            }
            return totalDistance / (double) result.size();
        } else {
            return 0.0;
        }

    }

    public double getAvgInterClusterSim(ArrayList<Centroid> result) {

        if (result.size() >= 1) {
            double totalSimilarity = 0.0;
            for (Centroid c : result) {
//                System.out.println("Cosine sim: " + simMatrics.findCosineSimilarity(result.get(0).getAverageVector(), c.getAverageVector()));
                totalSimilarity += simMatrics.findCosineSimilarity(result.get(0).getAverageVector(), c.getAverageVector());
            }
//            System.out.println("Result size " + result.size());
//            System.out.println("Total similarity " + totalSimilarity);
            return totalSimilarity / result.size();
        } else {
            return 0.0;
        }

    }
    
    public double getAvgPurity(ArrayList<Centroid> result) {
        
        double sum = 0.0;
        
        for (Centroid c : result) {
            sum += c.getPurity();
        }
        
        double avgPurity = sum / result.size();
        
        return avgPurity;
    }
}
