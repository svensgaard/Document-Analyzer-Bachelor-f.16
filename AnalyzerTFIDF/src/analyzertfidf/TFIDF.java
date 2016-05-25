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

    private ArrayList<String> distinctTerms;
    public HashMap<String, Double> termIDF;

    public ArrayList<String> getDistinctTerms() {
        return distinctTerms;
    }

    public void setDistinctTerms(ArrayList<String> distinctTerms) {
        this.distinctTerms = distinctTerms;
    }

    public TFIDF() {
        termIDF = new HashMap<>();
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
        //WRONG
//        int total = document.keywords.keywordMap.size();
        //CORRECT
        int total = 0;

        for (HashMap.Entry<String, Integer> entry : document.keywords.keywordMap.entrySet()) {
            total += entry.getValue();
        }

        double d = (double) frequency / (double) total;
//        System.out.println("\tTF: " + d);
        return d;
    }

    /**
     * Calculates Inverse Document Frequency of a term across all texts in a
     * corpus Uses log10
     *
     * idf(term, Corpus) = log(a/b) a: Size of corpus b: Term occurrences in
     * texts
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
        if (count == 0) {
            count++;
        }
        double a = (double) corpus.size() / (double) (count);
        double d = Math.log10(a);
//        System.out.println("\tCorpus size: " + corpus.size() + ", " + "Appears in: " + count);
//        System.out.println("\tIDF: " + d);
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
        double tfidf = 0;
        // MAP !CONTAINS TERM
        if (!termIDF.containsKey(term)) {
            double tf = calculateTF(term, document);
            double idf = calculateIDF(term, corpus);
            termIDF.put(term, idf);
            tfidf = tf * idf;
        } else {
            tfidf = calculateTF(term, document) * termIDF.get(term);
        }
        return tfidf;

    }

}
