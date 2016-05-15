/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textanalyzer;

import java.util.ArrayList;

/**
 *
 * @author Bryan
 */
public class Text {

    String fileName;
    Keywords keywords;
    String expectedType;

    public Text(String fileName, Keywords keywords) {
        this.fileName = fileName;
        this.keywords = keywords;
    }

    public Text(String fileName, Keywords keywords, String expectedType) {
        this.fileName = fileName;
        this.keywords = keywords;
        this.expectedType = expectedType;
    }

}
