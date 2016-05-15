/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIX;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mads
 */
public class LIXFileReader {

    public int readDots(String fileName) {
        // Read file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));

            int r;
            int dots = 0;
            //read each line
            while ((r = reader.read()) != -1) {
                char ch = (char) r;
                if (ch == '.' || ch == '?' || ch == ':' || ch == ';') {
                    dots++;
                }

            }

            return dots;

        } catch (IOException e) {
            throw new Error("Reading File Exception", e);
        }
    }

   public int readWords(String filename) {
        // Read file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename + ".txt"));

            String line;
            int words = 0;
            // Split symbols
            while ((line = reader.readLine()) != null) {
                String[] wordArray = line.toLowerCase().split("\\s");

                // Count words
                words += wordArray.length;

            }

            return words;

        } catch (IOException e) {
            throw new Error("Reading File Exception", e);
        }
    }

   public int readBigWords(String filename) {
        // Read file      
        int bigWords = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename + ".txt"));

            String line;
            
            // Split symbols
            while ((line = reader.readLine()) != null) {
                String[] wordArray = line.toLowerCase().split("\\s");

                // Count words
                for (String word : wordArray) {
                    if (word.length() > 6) {
                        bigWords++;
                    }

                }
                
            }
            return bigWords;

        } catch (IOException e) {
            throw new Error("Reading File Exception", e);
        }
    }
}
