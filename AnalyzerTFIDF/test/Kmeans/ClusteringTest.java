/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kmeans;

import analyzertfidf.Keywords;
import analyzertfidf.TFIDF;
import analyzertfidf.Text;
import analyzertfidf.TextProcessor;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bryan
 */
public class ClusteringTest {

    public ClusteringTest() {
    }

    TextProcessor tp = new TextProcessor();

    private void showFiles(File[] files, ArrayList<Text> texts) {
        for (File file : files) {

            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                showFiles(file.listFiles(), texts); // Calls same method again.
            } else if (!file.getName().contains("DS_Store")) {
                System.out.println("File: " + file.getName());
                //Read corpus files
                HashMap<String, Integer> tempMap;

                tempMap = tp.readFileActual(file.getPath());
                texts.add(new Text(file.getName(), new Keywords(tempMap), file.getPath(), file.getParentFile().getName()));
            }
        }
    }

    private ArrayList<Text> calculateTFIDF(ArrayList<Text> texts) {
        TFIDF calculator = new TFIDF();
        HashMap<String, Double> termWeightMap;

        for (Text t : texts) {
            termWeightMap = new HashMap<>();

            for (HashMap.Entry<String, Integer> entry : t.keywords.keywordMap.entrySet()) {
                termWeightMap.put(entry.getKey(), calculator.calculateTFIDF(entry.getKey(), t, texts));
            }

            t.keywords.keywordTFIDFMap = termWeightMap;
        }

        //Initialize vectorspace in all texts
        for (Text t : texts) {
            t.vectorSpace = new Double[calculator.termIDF.size()];
            int count = 0;
            for (String s : calculator.termIDF.keySet()) {
                if (t.keywords.keywordTFIDFMap.containsKey(s)) {
                    t.vectorSpace[count] = t.keywords.keywordTFIDFMap.get(s);
                } else {
                    t.vectorSpace[count] = 0.0;
                }
                count++;
            }
        }
        return texts;
    }

    /**
     * Test of prepareCluster method, of class Clustering.
     */
    @Test
    public void testPrepareCluster() {

        Clustering clustering = new Clustering();
        ArrayList<Text> texts = new ArrayList<>();

        ArrayList<Text> tempTexts = new ArrayList<>();
        File[] files = new File("./resources/document").listFiles();

        for (File file : files) {

            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                showFiles(file.listFiles(), texts); // Calls same method again.
            } else if (!file.getName().contains("DS_Store")) {
                System.out.println("File: " + file.getName());
                //Read corpus files
                HashMap<String, Integer> tempMap;

                tempMap = tp.readFileActual(file.getPath());
                texts.add(new Text(file.getName(), new Keywords(tempMap), file.getPath(), file.getParentFile().getName()));
            }
        }

        texts = calculateTFIDF(texts);

        clustering.setMinSimilarity(Double.parseDouble("0.3"));
        ArrayList<Centroid> result = clustering.prepareClusterIncrement(texts, true);

        for (Centroid c : result) {
            assertNotNull(c);
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
