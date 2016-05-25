/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzertfidf;

import Kmeans.Centroid;
import Kmeans.SimilarityMatrics;

/**
 *
 * @author Bryan
 */
public class Text {

    public String fileName;
    public Double[] vectorSpace;
    public Keywords keywords;
    public String type;
    public String path;

    public double getDistanceToCentroid(Centroid centroid) {
        SimilarityMatrics similarity = new SimilarityMatrics();
        return similarity.findCosineSimilarity(centroid.getAverageVector(), vectorSpace);
    }

    public Double[] getVectorSpace() {
        return vectorSpace;
    }

    public void setVectorSpace(Double[] vectorSpace) {
        this.vectorSpace = vectorSpace;
    }

    public Text(String fileName, Keywords keywords) {
        this.fileName = fileName;
        this.keywords = keywords;
    }

    public Text(String fileName, Keywords keywords, String path) {
        this.fileName = fileName;
        this.keywords = keywords;
        this.path = path;
    }

    public Text(String fileName, Keywords keywords, String path, String parent) {
        this.fileName = fileName;
        this.keywords = keywords;
        this.path = path;
        this.type = parent;
    }

}
