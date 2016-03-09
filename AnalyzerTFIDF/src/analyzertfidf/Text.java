/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzertfidf;


/**
 *
 * @author Bryan
 */
public class Text {
    String fileName;
    public Double[] vectorSpace;

    public Double[] getVectorSpace() {
        return vectorSpace;
    }

    public void setVectorSpace(Double[] vectorSpace) {
        this.vectorSpace = vectorSpace;
    }
    Keywords keywords;
    
    public Text(String fileName, Keywords keywords) {
        this.fileName = fileName;
        this.keywords = keywords;
    }
    
    
    
}
