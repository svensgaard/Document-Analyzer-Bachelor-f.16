/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kmeans;

/**
 *
 * @author Mads
 */
public class Text {
    private String content;
    private Double[] vectorSpace;
    
    public Text(String content, Double[] vectorSpace) {
        this.content = content;
        this.vectorSpace = vectorSpace;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double[] getVectorSpace() {
        return vectorSpace;
    }

    public void setVectorSpace(Double[] VectorSpace) {
        this.vectorSpace = VectorSpace;
    }
}
