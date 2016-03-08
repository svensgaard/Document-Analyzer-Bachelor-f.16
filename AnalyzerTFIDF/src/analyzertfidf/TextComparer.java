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
        
        if (corpora.size() < 1) {
            corpora.add(new Corpus(t));
        }
        
        double match = 0;
        double tempMatch = 0;
        Corpus tempCorpus = null;
        
        for (Corpus c : corpora) {
            tempMatch = c.keywords.compare(t.keywords);
//            System.out.println("Match: " + match);
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
        
        System.out.println("Corpora size: " + corpora.size());
        int count = 1;
        for (Corpus c : corpora) {
            System.out.println("Corpus"+count);
            for (Text text : c.texts) {
                System.out.println(text.fileName);
            }
            System.out.println("----");
            count++;
        }
    }
    
}
