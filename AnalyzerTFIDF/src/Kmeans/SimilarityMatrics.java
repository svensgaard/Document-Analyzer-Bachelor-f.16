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
        //Make sure both vectors are the same length
        if (vector1.length != vector2.length) {
            //If vector 1 is smaller than vector 2
            if (vector1.length < vector2.length) {
                Double[] tempVector = new Double[vector2.length];
                int lengthDifference = vector2.length - vector1.length;
                for (int i = 0; i < vector1.length; i++) {
                    tempVector[i] = vector1[i];
                }
                for (int i = vector1.length; i < lengthDifference; i++) {
                    tempVector[i] = 0.0;
                }
                vector1 = tempVector;
            } else { //Else vector 2 is smaller than vector 1
                Double[] tempVector = new Double[vector1.length];
                int lengthDifference = vector1.length - vector2.length;
                for (int i = 0; i < vector2.length; i++) {
                    tempVector[i] = vector2[i];
                }
                for (int i = vector2.length; i < lengthDifference; i++) {
                    tempVector[i] = 0.0;
                }
                vector2 = tempVector;
            }

        }
        Double dotProduct = dotProduct(vector1, vector2);
        Double magnitude1 = magnitude(vector1);
        Double magnitude2 = magnitude(vector2);
        Double result;
        result = dotProduct / (magnitude1 * magnitude2);

        if (result.isNaN()) {
            result = 0.0;
        }
        return result;
    }

    private Double dotProduct(Double[] vector1, Double[] vector2) {
        Double result = 0.0;
        for (int i = 0; i < vector1.length; i++) {
            //SORRY ABOUT THIS ONE
            if (vector1[i] == null) {
            } else if (vector2[i] == null) {
            } else {
                result += (vector1[i] * vector2[i]);
            }

        }
        return result;
    }

    private Double magnitude(Double[] vector) {
        return Math.sqrt(dotProduct(vector, vector));
    }
}
