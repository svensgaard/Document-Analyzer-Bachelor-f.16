/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SentenceLenght;

/**
 *
 * @author Mads
 */
public class SentenceComparer {
    public Double findSentenceSimilarity(double clusterLength, int textLength) {
        double result = clusterLength / (double) textLength;
        return result;
    }
}
