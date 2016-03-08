/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KmeansTests;

import Kmeans.Centroid;
import Kmeans.Clustering;
import Kmeans.Text;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mads
 */
public class ClusteringTest {
    Double[] space1;
    Double[] space2;
    Double[] space3;
    Double[] space4;
    Text text1;
    Text text2;
    Text text3;
    Text text4;
    ArrayList<Text> corpus;
    Clustering clusterClass;
    public ClusteringTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {  
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //Setup vector space for each text
        //The values are approximately correct, but not computed. 
        space1 = new Double[10];
        space1[0] = 0.1;
        space1[1] = 0.2;
        space1[2] = 0.2;
        space1[3] = 0.0;
        space1[4] = 0.0;
        space1[5] = 0.0;
        space1[6] = 0.0;
        space1[7] = 0.0;
        space1[8] = 0.0;
        space1[9] = 0.0;
        space2 = new Double[10];
        space2[0] = 0.0;
        space2[1] = 0.2;
        space2[2] = 0.2;
        space2[3] = 0.1;
        space2[4] = 0.0;
        space2[5] = 0.0;
        space2[6] = 0.0;
        space2[7] = 0.0;
        space2[8] = 0.0;
        space2[9] = 0.0;
        space3 = new Double[10];
        space3[0] = 0.0;
        space3[1] = 0.0;
        space3[2] = 0.0;
        space3[3] = 0.0;
        space3[4] = 0.2;
        space3[5] = 0.2;
        space3[6] = 0.1;
        space3[7] = 0.0;
        space3[8] = 0.0;
        space3[9] = 0.0;
        space4 = new Double[10];
        space4[0] = 0.0;
        space4[1] = 0.0;
        space4[2] = 0.0;
        space4[3] = 0.0;
        space4[4] = 0.2;
        space4[5] = 0.2;
        space4[6] = 0.0;
        space4[7] = 0.1;
        space4[8] = 0.1;
        space4[9] = 0.1;
        //Create test texts
        text1 = new Text("Mads er dejlig", space1);
        text2 = new Text("Is er dejlig", space2);
        text3 = new Text("En sort kat", space3);
        text4 = new Text("En sort gryde med låg", space4);
        clusterClass = new Clustering();
        corpus = new ArrayList<>();
        //Add texts to corpus
        corpus.add(text4); corpus.add(text2); corpus.add(text3); corpus.add(text1);
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void clustering() { 
         
         //Because of the random picking of centroids, testing the clustering will not always yield the correct result.
         //Use Human eyes to verify test results. 
         //Expected result is a cluster with: "Is er dejlig" & "Mads er dejlig" and a cluster with: "En sort gryde med låg" & "En sort kat"
         //Not necessarily in that order.
         
         ArrayList<ArrayList<Centroid>> results = new ArrayList<>();
        results.add(clusterClass.prepareCluster(2, corpus));
        results.add(clusterClass.prepareCluster(2, corpus));
        results.add(clusterClass.prepareCluster(2, corpus));
        results.add(clusterClass.prepareCluster(2, corpus));
        results.add(clusterClass.prepareCluster(2, corpus));
        int i = 1;
        for(ArrayList<Centroid> r : results) {
            int index =1;
            System.out.println("---------------------------------------Result: " + i + "-------------------------------------------------");
            for(Centroid c : r) {
            System.out.println("\nCluster: " + index);
            for(Text t : c.GroupedDocument) {
                System.out.println(t.getContent());
            }
            index++;
        }
        }
        
     }
}
