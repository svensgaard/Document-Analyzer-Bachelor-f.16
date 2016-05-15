/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIX;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Mads
 */
public class LIXCalculator {
    LIXFileReader filereader = new LIXFileReader();
    
    public int calculateLix(String filename) {
        int dots = filereader.readDots(filename);
        int words = filereader.readWords(filename);
        int bigWords = filereader.readBigWords(filename);

        //Calculate LIX and return
        return (words/dots) + (bigWords*100)/words;
    }

}
