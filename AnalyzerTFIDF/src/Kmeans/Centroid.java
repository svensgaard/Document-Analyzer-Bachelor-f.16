/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kmeans;

import analyzertfidf.Keywords;
import analyzertfidf.Text;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Mads
 */
public class Centroid {

    public ArrayList<Text> GroupedDocument = new ArrayList<>();
    public boolean isTheOne = false;
    private Double[] averageVector;
    public String name;

    public Centroid() {
        //Empty constructor
    }

    //Used for old implementation
    public Keywords keywords;

    public Centroid(Text text) {
        GroupedDocument = new ArrayList<Text>();
        keywords = new Keywords(text.keywords.keywordMap);
        update(text);
    }

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

    //Calculate the purity
    public double getPurity() {
        Map.Entry<String, Integer> dominantType = getClusterType();
        //return purity 
        if (dominantType != null) {
            return (double) dominantType.getValue() / (double) GroupedDocument.size();
        } else {
            return 1;
        }
    }

    public Map.Entry<String, Integer> getClusterType() {
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
        if (maxType == null) {
            return new AbstractMap.SimpleEntry<String, Integer>("None", 0);
        } else {
            return maxType;
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
        for (Text t : GroupedDocument) {
            totalDistance += simMatrics.findCosineSimilarity(t.getVectorSpace(), averageVector);
        }
        return totalDistance / GroupedDocument.size();
    }

    public void update(Text text) {
        // TODO update keywords
        // Add text to corpus
        GroupedDocument.add(text);

        // compare text keywords with the rest of the corpus texts
        for (Text t : GroupedDocument) {

            Iterator it = t.keywords.keywordMap.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();

                if (keywords.keywordMap.containsKey(pair.getKey())) {
                    keywords.keywordMap.put(pair.getKey().toString(), keywords.keywordMap.get(pair.getKey()) + 1);
                } else {
                    keywords.keywordMap.put(pair.getKey().toString(), 1);
                }

            }

        }
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
