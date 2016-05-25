/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzertfidf;

import Kmeans.Centroid;
import com.datumbox.opensource.classifiers.NaiveBayes;
import com.datumbox.opensource.dataobjects.NaiveBayesKnowledgeBase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class BayesClassifier {

    public NaiveBayes nb;
    public int datasetsCount = 0;
    public String[] datasetNames;


    public BayesClassifier() {
        try {
            initFromClusters();
        } catch (IOException ex) {
            Logger.getLogger(BayesClassifier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Reads all the lines from a file and places it a String array. In each
     * record in the String array we store a training example text.
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String[] readLines(URL url) throws IOException {

        Reader fileReader = new InputStreamReader(url.openStream(), Charset.forName("UTF-8"));
        List<String> lines;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines.toArray(new String[lines.size()]);
    }

    /**
     * INITIALIZE THE CLASSIFIER
     *
     * @throws IOException
     */
    public void initializeClassifier() throws IOException {
        //map of dataset files
        Map<String, URL> trainingFiles = new HashMap<>();
//        trainingFiles.put("English", NaiveBayesExample.class.getResource("/datasets/training.language.en.txt"));
//        trainingFiles.put("French", NaiveBayesExample.class.getResource("/datasets/training.language.fr.txt"));
//        trainingFiles.put("German", NaiveBayesExample.class.getResource("/datasets/training.language.de.txt"));
        trainingFiles.put("Physics", BayesClassifier.class.getResource("/datasets/training.physics.en.txt"));
        trainingFiles.put("Politics", BayesClassifier.class.getResource("/datasets/training.politics.en.txt"));
        trainingFiles.put("Legal", BayesClassifier.class.getResource("/datasets/training.legal.en.txt"));

        // USED FOR CORPUSCOMPARER
        datasetsCount = trainingFiles.size();
        datasetNames = new String[datasetsCount];

        //loading examples in memory
        Map<String, String[]> trainingExamples = new HashMap<>();

        int i = 0;
        for (Map.Entry<String, URL> entry : trainingFiles.entrySet()) {
            trainingExamples.put(entry.getKey(), readLines(entry.getValue()));
            datasetNames[i] = entry.getKey();
            i++;
        }

        //train classifier
        NaiveBayes tempNB = new NaiveBayes();
        tempNB.setChisquareCriticalValue(6.63); //0.01 pvalue
        tempNB.train(trainingExamples);

        //get trained classifier knowledgeBase
        NaiveBayesKnowledgeBase knowledgeBase = tempNB.getKnowledgeBase();

        trainingExamples = null;

        //Use classifier
        nb = new NaiveBayes(knowledgeBase);
    }

    /**
     * INITIALIZE THE CLASSIFIER from generated clusters
     *
     * @throws IOException
     */
    public void initFromClusters() throws IOException {
        //map of dataset files
        Map<String, URL> trainingFiles = new HashMap<>();

        Files.walk(Paths.get("./resources/datasets/")).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                try {
                    trainingFiles.put(filePath.getFileName().toString(), filePath.toUri().toURL());
                } catch (MalformedURLException ex) {
                    Logger.getLogger(BayesClassifier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        System.out.println("TRAININGDATA: " + trainingFiles.size());
        for (Map.Entry<String, URL> entry : trainingFiles.entrySet()) {
            System.out.println("DATA: " + entry.getKey());
        }

        //loading examples in memory
        Map<String, String[]> trainingExamples = new HashMap<>();

        for (Map.Entry<String, URL> entry : trainingFiles.entrySet()) {
            trainingExamples.put(entry.getKey(), readLines(entry.getValue()));
        }

        //train classifier
        NaiveBayes tempNB = new NaiveBayes();
        tempNB.setChisquareCriticalValue(6.63); //0.01 pvalue
        tempNB.train(trainingExamples);

        //get trained classifier knowledgeBase
        NaiveBayesKnowledgeBase knowledgeBase = tempNB.getKnowledgeBase();

        trainingExamples = null;
        nb = null;

        //Use classifier
        nb = new NaiveBayes(knowledgeBase);
    }

    public String predictClassification(String text) {
        return nb.predict(text);
    }

}
