/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kmeans;

/**
 *
 * @author Mads
 */
public class SimilarityMatrics {
    
    public Double findCosineSimilarity(Double[] vector1, Double[] vector2) {
        Double dotProduct = dotProduct(vector1, vector2);
        Double magnitude1 = magnitude(vector1);
        Double magnitude2 = magnitude(vector2);
        Double result = dotProduct / (magnitude1 * magnitude2);

        return result;
    }

    private Double dotProduct(Double[] vector1, Double[] vector2) {
        Double result = 0.0;
        for(int i = 0; i < vector1.length; i ++) {
            result += (vector1[i] * vector2[i]);
        }
        return result;
    }

    private Double magnitude(Double[] vector) {
        return Math.sqrt(dotProduct(vector, vector));
    }
}
