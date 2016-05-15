/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textanalyzer;

import java.util.ArrayList;

/**
 *
 * @author Bryan
 */
public class CorpusCompare {

    ArrayList<Corpus> corpora, tempCorpora;
    BayesClassifier bc;

    public CorpusCompare() {
        corpora = new ArrayList<>();
        tempCorpora = new ArrayList<>();
    }

    public CorpusCompare(BayesClassifier bc) {
        corpora = new ArrayList<>();
        tempCorpora = new ArrayList<>();
        this.bc = bc;
        initializeComparerBayes();
    }

    private void initializeComparerBayes() {
        for (int i = 0; i < bc.datasetsCount; i++) {
            corpora.add(new Corpus(bc.datasetNames[i]));
        }
        // TEST NAMES
//        System.out.println("------------- CORPUS NAMES");
//        for (Corpus c : corpora) {
//            System.out.println(c.name);
//        }
//        System.out.println("------------- CORPUS NAMES");
    }

    public void compareTexts(Text toCompare) {

        double match = 0;
        double tempMatch = 0;
        Corpus tempCorpus = null;

        for (Corpus c : corpora) {
            tempMatch = c.keywords.compare(toCompare.keywords);
            if (match < tempMatch) {
                match = tempMatch;
                tempCorpus = c;
            }
        }

        match = match * 100;
        if (match < 0.5) {
            corpora.add(new Corpus(toCompare));
        } else if (tempCorpus != null) {
            tempCorpus.update(toCompare);
        }

    }

    void compareTextsBayes(Text t) {
        for (Corpus c : corpora) {
            if (c.name.equalsIgnoreCase(bc.predictClassification(t.keywords.toString()))) {
                c.update(t);
            }
        }
    }

    public void compareCorpus(Corpus toCompare) {

        double match = 0;
        double tempMatch = 0;
        Corpus tempCorpus = new Corpus();

        for (Corpus c : corpora) {
            if (!c.equals(toCompare)) {
                tempMatch = c.keywords.compare(toCompare.keywords);
                if (match < tempMatch) {
                    match = tempMatch;
                    tempCorpus = c;
                }
            }
        }

//        System.out.println("Corpus match: " + match);
        if (match < 0.70) {
            tempCorpora.add(new Corpus(toCompare.texts));
        } else if (tempCorpus != null) {
            Corpus tempCorpus2 = new Corpus();
            for (Text t : toCompare.texts) {
                if (!tempCorpus2.texts.contains(t)) {
                    tempCorpus2.update(t);

                }
            }
            for (Text t : tempCorpus.texts) {
                if (!tempCorpus2.texts.contains(t)) {
                    tempCorpus2.update(t);

                }
            }

            tempCorpora.add(tempCorpus2);
        }

    }

    public void getInfo() {

        int count = 1;
        for (Corpus c : corpora) {
            System.out.println("\nCorpus " + count);
            for (Text t : c.texts) {
                System.out.println("Text name: " + t.fileName);
            }
            count++;
        }
    }

    public void getInfoBayes() {

        for (Corpus c : corpora) {
            System.out.println("\nCorpus " + c.name);
            for (Text t : c.texts) {
                System.out.println("Text name: " + t.fileName);
            }
        }
    }

    public void getInfoTemp() {

        int count = 1;
        for (Corpus c : tempCorpora) {
            System.out.println("Corpus " + count);
            for (Text t : c.texts) {
                System.out.println("Text name: " + t.fileName);
            }
            count++;
        }
    }

    @Override
    public String toString() {
        String s = "";
        s += ("Corpora size: " + corpora.size());

        int count = 0;

        for (Corpus c : corpora) {
            s += ("\n --- Corpora: " + count + " ---");
            s += ("\n --- Keywords: ---\n" + c.toString());
            s += ("\n --- End of Corpus ---");
        }

        return s;
    }

}
