/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzertfidf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Bryan
 */
public class Corpus {

    ArrayList<Text> texts;
    Keywords keywords;

    public Corpus() {
        texts = new ArrayList<>();
        keywords = new Keywords(new HashMap<>());
    }

    public Corpus(Text text) {
        texts = new ArrayList<Text>();
        keywords = new Keywords(text);
        update(text);
    }

    public Corpus(ArrayList<Text> texts) {
        this.texts = new ArrayList<>();
        keywords = new Keywords(new HashMap<>());

        for (Text t : texts) {
            update(t);
        }
    }

    public void update(Text text) {
        // TODO update keywords
        // Add text to corpus
        texts.add(text);

        // Update key value (frequency) map
        for (Map.Entry<String, Integer> entry : text.keywords.keywordMap.entrySet()) {
            if (keywords.keywordMap.containsKey(entry.getKey())) {
                keywords.keywordMap.put(entry.getKey().toString(), keywords.keywordMap.get(entry.getKey()) + 1);
            } else {
                keywords.keywordMap.put(entry.getKey().toString(), 1);
            }
        }

    }

    @Override
    public String toString() {
        return keywords.toString();
    }
}
