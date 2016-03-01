/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stemming;

import Stemming.Snowball.ext.danishStemmer;
import Stemming.Snowball.ext.englishStemmer;

/**
 *
 * @author Mads
 */
public class WordStemmer {
    danishStemmer danishStemmer; 
    englishStemmer englishStemmer;
    String langugage;

    public WordStemmer() {
       danishStemmer = new danishStemmer();
       englishStemmer = new englishStemmer();
       
        //Set current
        //Stem()
        //Get Current
    }
    
    public void setLangugage(String langugage) {
        this.langugage = langugage;
    }
    public String stem(String value) {
        if(langugage.equals("danish")) {
            danishStemmer.setCurrent(value);
            danishStemmer.stem();
            return danishStemmer.getCurrent();
        } else if(langugage.equals("english")) {
            englishStemmer.setCurrent(value);
            englishStemmer.stem();
            return englishStemmer.getCurrent();
        } else {
            return value;
        }
    }
}
