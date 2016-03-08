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
    private int calculateTF(String term, Text document) {
        return document.keywords.keywordMap.get(term);
    }

    /**
     * Calculates Inverse Document Frequency of a term across all texts in a corpus
     * Uses log10
     * 
     * idf(term, Corpus) = log(a/b)
     * a: Size of corpus
     * b: Term occurrences in texts
     * 
     * returns 0 if term occurs in every text - e.g 2/2
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
        return Math.log10(corpus.size()/count);
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
        return calculateTF(term, document) * calculateIDF(term, corpus);
    }
    
}
