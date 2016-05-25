/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupOnFrequency;

import Kmeans.Centroid;
import analyzertfidf.Text;
import java.util.ArrayList;

/**
 *
 * @author Mads
 */
public class Grouper {
    private ArrayList<Centroid> corpora, tempCorpora;
    public int counter = 0;
    private int MAX_CLUSTERS = 3;
    public Grouper() {
        corpora = new ArrayList<>();
        tempCorpora = new ArrayList<>();
    }
    
    public ArrayList<Centroid> group(ArrayList<Text> texts) {
        counter = 0;
        for(Text t : texts) {
            compareTexts(t);
        }
        return corpora;
    }
    public ArrayList<Centroid> group(ArrayList<Text> texts, int MAX_CLUSTERS) {
        
        this.MAX_CLUSTERS = MAX_CLUSTERS;
        counter = 0;
        for(Text t : texts) {
            compareTexts(t);
        }
        return corpora;
    }
    public void compareTexts(Text toCompare) {
        counter++;
        double match = 0;
        double tempMatch = 0;
        Centroid tempCorpus = null;

        for (Centroid c : corpora) {
            tempMatch = c.keywords.compare(toCompare.keywords);
            if (match < tempMatch) {
                match = tempMatch;
                tempCorpus = c;
            }
        }

//        match = match;
        if (match < 0.3 || MAX_CLUSTERS >= corpora.size()) {
            corpora.add(new Centroid(toCompare));
        } else if (tempCorpus != null) {
            tempCorpus.update(toCompare);
        }

    }
}
