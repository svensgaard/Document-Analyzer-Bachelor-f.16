/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzertfidf;

import java.util.HashMap;

/**
 *
 * @author Bryan
 */
public class AnalyzerTFIDF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextProcessor tp = new TextProcessor();
        
        HashMap<String, Integer> testMap = tp.readFile("EuroparlDaEn1.txt");
        
        for (HashMap.Entry<String, Integer> entry : testMap.entrySet()) {
            System.out.println("Word: " + entry.getKey() + ", " + entry.getValue());
        }
    }
    
}
