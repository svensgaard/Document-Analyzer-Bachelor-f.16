/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kmeans;

import analyzertfidf.Text;
import java.util.ArrayList;

/**
 *
 * @author Mads
 */
public class Centroid {
    public ArrayList<Text> GroupedDocument;
    public boolean isTheOne = false;

    public ArrayList<Text> getGroupedDocument() {
        return GroupedDocument;
    }

    public void setGroupedDocument(ArrayList<Text> GroupedDocument) {
        this.GroupedDocument = GroupedDocument;
    }
    public Double[] getAverageVector() {
        Double[] averageVector;
        if(GroupedDocument.size() > 0) {
           averageVector = new Double[GroupedDocument.get(0).vectorSpace.length];
        } else {
            averageVector = new Double[0];
        }
        //Initialize average vector
        for (int i = 0; i < averageVector.length; i++) {
             averageVector[i] = 0.0;
        }
        //Add the total
        int count = 0;       
        for(Text t : GroupedDocument) {
            for(int i = 0; i < averageVector.length;i++) {                
                averageVector[i] += t.vectorSpace[i];
            }
            count++;
        }
        for(int i = 0; i < averageVector.length;i++) {
            averageVector[i] = averageVector[i] / count;
        }
        return averageVector;
    }
}
