/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzertfidf;

import java.util.ArrayList;

/**
 *
 * @author Bryan
 */
public class TextComparer {
    
    ArrayList<Corpus> corpora;
    
    public TextComparer() {
        corpora = new ArrayList<>();
    }
    
    public void compareText(Text t) {
        
        double match = 0;
        double tempMatch = 0;
        Corpus tempCorpus = null;
        
        for (Corpus c : corpora) {
            tempMatch = c.keywords.compare(t.keywords);
            if (match < tempMatch) {
                match = tempMatch;
                tempCorpus = c;
            }
        }
        
        if (match < 0.5) {
            corpora.add(new Corpus(t));
        } else if (tempCorpus != null) {
            tempCorpus.update(t);
        }
    }
    
}
