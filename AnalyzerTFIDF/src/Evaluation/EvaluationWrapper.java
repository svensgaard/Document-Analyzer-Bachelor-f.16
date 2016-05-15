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

    ArrayList<Centroid> trueFreqResult = new ArrayList<>();

    public ArrayList<Centroid> getTrueFreqResult() {
        return trueFreqResult;
    }

    public void setTrueFreqResult(ArrayList<Centroid> trueFreqResult) {
        this.trueFreqResult = trueFreqResult;
    }

    public ArrayList<Centroid> getTrueMostCommonWordsResult() {
        return trueMostCommonWordsResult;
    }

    public void setTrueMostCommonWordsResult(ArrayList<Centroid> trueMostCommonWordsResult) {
        this.trueMostCommonWordsResult = trueMostCommonWordsResult;
    }
    ArrayList<Centroid> trueMostCommonWordsResult = new ArrayList<>();

    SimilarityMatrics simMatrics = new SimilarityMatrics();

    

    public EvaluationWrapper() {

    }

    public double getAverageSimilarityToTrueFreqResult(ArrayList<Centroid> result) {
        double total = 0;
        
        //Find the distance to the 
        for (Centroid centroid : result) {
            for (Centroid trueCentroid : trueFreqResult) {
                if (centroid.getClusterType().getKey().equalsIgnoreCase(trueCentroid.getClusterType().getKey())) {
                    total += simMatrics.findCosineSimilarity(trueCentroid.getAverageVector(), centroid.getAverageVector());
                }
            }
        }
           
        // Divide by number of clusters
        return total / 3;
    }
    public double getAverageSimilarityToTrueMostCommonWordsResult(ArrayList<Centroid> result) {
        double total = 0;
        
        //Find the distance to the 
        for (Centroid centroid : result) {
            for (Centroid trueCentroid : trueMostCommonWordsResult) {
                if (centroid.getClusterType().getKey().equalsIgnoreCase(trueCentroid.getClusterType().getKey())) {
                    total += simMatrics.findCosineSimilarity(trueCentroid.getAverageVector(), centroid.getAverageVector());
                }
            }
        }
           
        // Divide by number of clusters
        return total / 3;
    }
}
