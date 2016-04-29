/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kmeans;

import analyzertfidf.Text;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mads
 */
public class Centroid {

    public ArrayList<Text> GroupedDocument;
    public boolean isTheOne = false;
    private Double[] averageVector;
    

    public ArrayList<Text> getGroupedDocument() {
        return GroupedDocument;
    }

    public void setGroupedDocument(ArrayList<Text> GroupedDocument) {
        this.GroupedDocument = GroupedDocument;
    }

    public Double[] getAverageVector() {
        if (averageVector == null) { //If null calculate it, else just return it. Saves calculations

            if (GroupedDocument.size() > 0) {
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
            for (Text t : GroupedDocument) {
                for (int i = 0; i < averageVector.length; i++) {
                    averageVector[i] += t.vectorSpace[i];
                }
                count++;
            }
            for (int i = 0; i < averageVector.length; i++) {
                averageVector[i] = averageVector[i] / count;
            }
        }

        return averageVector;
    }

    //Calculate the accuracy
    public double getPurity() {
        //Find what type of cluster this is, by counting the types in the cluster
        HashMap<String, Integer> types = new HashMap<>();

        for (Text text : GroupedDocument) {
            if (types.isEmpty()) {
                //If empty put in first type
                types.put(text.type, 1);
            } else {
                //If type already in map, increment count by one. else put in new type
                if (types.containsKey(text.type)) {
                    types.put(text.type, types.get(text.type) + 1);
                } else {
                    types.put(text.type, 1);
                }
            }
        }
        //Find the most dominant type in the cluster
        Map.Entry<String, Integer> maxType = null;
        for (Map.Entry<String, Integer> entry : types.entrySet()) {
            if (maxType == null || entry.getValue().compareTo(maxType.getValue()) > 0) {
                maxType = entry;
            }
        }
        //return purity 
        if (maxType != null) {
            return (double) maxType.getValue() / (double) GroupedDocument.size();
        } else {
            return 1;
        }
    }

    //Return the average sentence length for the cluster

    public Double getAverageSentenceLength() {

        double totalLength = 0;
        for (Text t : GroupedDocument) {
            totalLength += t.averageSentenceLength;
        }
        return totalLength / (double) GroupedDocument.size();

    }
    //Only works for frequency!
    public double getAverageDistance() {
        SimilarityMatrics simMatrics = new SimilarityMatrics();
        double totalDistance = 0;
        for(Text t : GroupedDocument) {
            totalDistance += simMatrics.findCosineSimilarity(t.getVectorSpace(), averageVector);
        }
        return totalDistance/GroupedDocument.size();
    }
}
