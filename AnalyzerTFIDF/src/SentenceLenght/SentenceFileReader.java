/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SentenceLenght;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mads
 */
public class SentenceFileReader {

    public int readFile(String fileName) {
        // Read file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));
            ArrayList<Integer> lengths = new ArrayList<>();

            int r;
            int sentenceLength = 0;
            boolean newSentence = false;
            //read each line
            while ((r = reader.read()) != -1) {
                char ch = (char) r;
                
                if (newSentence) {
                    //Disabled because of how txt files are strucutersd.
//                    if (ch == ' ' || ch == '"') {
                        //Add sentenceLength to array and reset.
                        lengths.add(sentenceLength);
                        sentenceLength = 0;
                        newSentence = false;
//                    } else {
//                        newSentence = false;
//                        sentenceLength++;
//                    }
                } else {
                    //If char is . set newSentence to true
                    if (ch == '.') {
                        newSentence = true;
                        sentenceLength++;

                    } else {
                        sentenceLength++;
                    }
                }

            }
            //Calculate and return average
            int total = 0;
            for (Integer i : lengths) {
                total += i;
            }

            return total / lengths.size();

        } catch (IOException e) {
            throw new Error("Reading File Exception", e);
        }
    }
}
