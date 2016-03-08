/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzertfidf;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * Term Frequency - Inverse Document Frequency
 *
 * @author Bryan
 */
public class TFIDF {

    public TFIDF() {
        
    }
    
    /**
     * Calculates raw Term Frequency weight 
     * 
     * f(term, document) = frequency
     * 
     * @param term - Word
     * @param document - Text containing word
     * @return Frequency of term in document
     */
    private double calculateTF(String term, Text document) {
        
        int frequency = document.keywords.keywordMap.get(term);
        int total = document.keywords.keywordMap.size();
//        System.out.println("Frequency: " + frequency +" / "+total);
        double i = (double)frequency/(double)total;
        System.out.println("TF: " + i);
        return i;
    }

    /**
     * Calculates Inverse Document Frequency of a term across all texts in a corpus
     * Uses log10
     * 
     * idf(term, Corpus) = log(a/b)
     * a: Size of corpus
     * b: Term occurrences in texts
     * 
     * returns 0 if term occurs in every text
     * 
     * @param term
     * @param corpus
     * @return IDF Weight of term in corpus
     */
    private double calculateIDF(String term, ArrayList<Text> corpus) {
        int count = 0;
        
        for (Text text : corpus) {
            if (text.keywords.contains(term)) {
                count++;
            }
        }
        
        double a = (double) corpus.size() / (double) (1+count);
        
        double d = Math.log10(a);
        System.out.println("IDF: " + d);
        
        return d;

    }
    
    /**
     * Calculates weight of a term in a corpus
     * 
     * tfidf(term, document, corpus) = tf(term, document) * idf(term, corpus)
     * 
     * @param term
     * @param document
     * @param corpus
     * @return
     */
    public double calculateTFIDF(String term, Text document, ArrayList<Text> corpus) {
        double tfidf = calculateTF(term, document) * calculateIDF(term, corpus);
        System.out.println("TF-IDF: " + tfidf);
        return tfidf;
    }
    
}
