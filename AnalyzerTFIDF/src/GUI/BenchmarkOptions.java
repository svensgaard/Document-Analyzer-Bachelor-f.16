/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Evaluation.EvaluationWrapper;
import Evaluation.Result;
import GroupOnFrequency.Grouper;
import Kmeans.Centroid;
import Kmeans.Clustering;
import analyzertfidf.Keywords;
import analyzertfidf.TFIDF;
import analyzertfidf.Text;
import analyzertfidf.TextProcessor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Mads
 */
public class BenchmarkOptions extends javax.swing.JFrame {

    private static final String englishCorpus = "./resources/englishCorpus";
    private static final String danishCorpus = "./resources/danishCorpus";
    private static final String classicCorpus = "./resources/classicCorpus";
    private static final String twentyCorpus = "./resources/twentyCorpus";
    private Clustering clustering = new Clustering();
    private EvaluationWrapper evaluation = new EvaluationWrapper();
    private final Grouper grouper = new Grouper();
    private final TextProcessor tp = new TextProcessor();
    private String corpus;

    /**
     * Creates new form BenchmarkOptions
     */
    public BenchmarkOptions() {
        initComponents();
        
        //Add radiobuttons to button group.
        corpusBtnGroups.add(englishCorpusRadioBtn);
        corpusBtnGroups.add(danishCorpusRadioBtn);
        corpusBtnGroups.add(classicCorpusRadioBtn);
        corpusBtnGroups.add(twentyCorpusRadioBtn);
        corpusBtnGroups.add(chooseFolderRadioBtn);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        corpusBtnGroups = new javax.swing.ButtonGroup();
        statusLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        englishCorpusRadioBtn = new javax.swing.JRadioButton();
        danishCorpusRadioBtn = new javax.swing.JRadioButton();
        classicCorpusRadioBtn = new javax.swing.JRadioButton();
        twentyCorpusRadioBtn = new javax.swing.JRadioButton();
        chooseFolderRadioBtn = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        clustersTxtBx = new javax.swing.JTextField();
        iterationTxtBx = new javax.swing.JTextField();
        clusterBtn = new javax.swing.JButton();
        combobox_similarity = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        resultBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        statusLabel.setText("Please choose options for benchmarking");

        jLabel2.setText("Corpus:");

        englishCorpusRadioBtn.setText("English test corpus");
        englishCorpusRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                englishCorpusRadioBtnActionPerformed(evt);
            }
        });

        danishCorpusRadioBtn.setText("Danish test corpus");
        danishCorpusRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                danishCorpusRadioBtnActionPerformed(evt);
            }
        });

        classicCorpusRadioBtn.setText("Classic corpus");
        classicCorpusRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classicCorpusRadioBtnActionPerformed(evt);
            }
        });

        twentyCorpusRadioBtn.setText("20news corpus");
        twentyCorpusRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twentyCorpusRadioBtnActionPerformed(evt);
            }
        });

        chooseFolderRadioBtn.setText("Choose folder");
        chooseFolderRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFolderRadioBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Options:");

        jLabel4.setText("Number of clusters");

        jLabel5.setText("Maximum iterations");

        jLabel6.setText("Minimum similarity");

        clustersTxtBx.setText("3");

        iterationTxtBx.setText("50");

        clusterBtn.setText("Cluster");
        clusterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clusterBtnActionPerformed(evt);
            }
        });

        combobox_similarity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9" }));

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        resultBtn.setText("Generate results");
        resultBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(danishCorpusRadioBtn)
                                            .addComponent(englishCorpusRadioBtn)
                                            .addComponent(classicCorpusRadioBtn, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(twentyCorpusRadioBtn, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chooseFolderRadioBtn, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(40, 40, 40))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(resultBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(77, 77, 77)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(clusterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(iterationTxtBx)
                                .addComponent(clustersTxtBx, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(combobox_similarity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(statusLabel))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusLabel)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(englishCorpusRadioBtn)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(danishCorpusRadioBtn)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(classicCorpusRadioBtn)
                            .addComponent(jLabel6)
                            .addComponent(combobox_similarity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(twentyCorpusRadioBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chooseFolderRadioBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clustersTxtBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(iterationTxtBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clusterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clusterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clusterBtnActionPerformed
        if (corpus != null) {
            
            //Read files
            statusLabel.setText("Reading files..");
            ArrayList<Text> corpusTexts = readFiles(corpus, false);
            ArrayList<Text> corpusTextsMCW = readFiles(corpus, true);
            statusLabel.setText("Clustering....");
            ArrayList<Result> results = cluster(corpusTexts, corpusTextsMCW);
            new BenchmarkResults(results).setVisible(true);
        }


    }//GEN-LAST:event_clusterBtnActionPerformed

    private void englishCorpusRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_englishCorpusRadioBtnActionPerformed
        corpus = englishCorpus;
    }//GEN-LAST:event_englishCorpusRadioBtnActionPerformed

    private void danishCorpusRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_danishCorpusRadioBtnActionPerformed
        corpus = danishCorpus;
    }//GEN-LAST:event_danishCorpusRadioBtnActionPerformed

    private void classicCorpusRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classicCorpusRadioBtnActionPerformed
        corpus = classicCorpus;
    }//GEN-LAST:event_classicCorpusRadioBtnActionPerformed

    private void twentyCorpusRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twentyCorpusRadioBtnActionPerformed
        corpus = twentyCorpus;
    }//GEN-LAST:event_twentyCorpusRadioBtnActionPerformed

    private void chooseFolderRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFolderRadioBtnActionPerformed
        // TODO show a filechooser to set equal to corpus;
        //corpus = filechooser.filename();
    }//GEN-LAST:event_chooseFolderRadioBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void resultBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultBtnActionPerformed
        if (corpus != null) {
            
            //Read files
            statusLabel.setText("Reading files..");
            ArrayList<Text> corpusTexts = readFiles(corpus, false);
            ArrayList<Text> corpusTextsMCW = readFiles(corpus, true);
            statusLabel.setText("Clustering....");
            ArrayList<ArrayList<Result>> resultList = new ArrayList<>();
            for(int i = 0; i < 25;i++) {
                ArrayList<Result> results = cluster(corpusTexts, corpusTextsMCW);
                resultList.add(results);
            }
            //Write to file
            String filepath = promptFilepath();
            try {
                writeResultToFile(resultList, filepath);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BenchmarkOptions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(BenchmarkOptions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_resultBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BenchmarkOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BenchmarkOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BenchmarkOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BenchmarkOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BenchmarkOptions().setVisible(true);
            }
        });
    }

    private ArrayList<Result> cluster(ArrayList<Text> corpusTexts, ArrayList<Text> corpusTextsMCW) {
        ArrayList<Result> results = new ArrayList<>();
        int clusters = Integer.parseInt(clustersTxtBx.getText());
        int maxIterations = Integer.parseInt(iterationTxtBx.getText());
        double minSimilarity = Double.parseDouble(combobox_similarity.getSelectedItem().toString());
        clustering.setParameters(maxIterations, minSimilarity);
        
       System.out.println("Clustering with k means plain");
        long start = System.currentTimeMillis();
        ArrayList<Centroid> resultKmeans = clustering.prepareCluster(clusters, corpusTexts, false);
        long end = System.currentTimeMillis();
        results.add(new Result(resultKmeans, end - start, "K means plain", clustering.globalCounter, evaluation.getAvgPurity(resultKmeans)));
        System.out.println("Clustering with k without most common words");
        start = System.currentTimeMillis();
        ArrayList<Centroid> resultKmeansMCW = clustering.prepareCluster(clusters, corpusTextsMCW, false);
        end = System.currentTimeMillis();
        results.add(new Result(resultKmeansMCW, end - start, "K means MCW", clustering.globalCounter, evaluation.getAvgPurity(resultKmeansMCW)));
//        System.out.println("Grouping on word frequency");
//        start = System.currentTimeMillis();
//        ArrayList<Centroid> resultGrouper = grouper.group(corpusTexts, clusters);
//        end = System.currentTimeMillis();
//        results.add(new Result(resultGrouper, start - end, "Grouping", grouper.counter, evaluation.getAvgPurity(resultGrouper)));
//        System.out.println("Grouping on word frequency without most common words");
//        start = System.currentTimeMillis();
//        ArrayList<Centroid> resultGrouperMCW = grouper.group(corpusTextsMCW, clusters);
//        end = System.currentTimeMillis();
//        results.add(new Result(resultGrouperMCW, end - start, "Grouping MCW", grouper.counter, evaluation.getAvgPurity(resultGrouperMCW)));
        System.out.println("Clustering with kmeans with better start");
        start = System.currentTimeMillis();
        ArrayList<Centroid> resultKmeansPlus = clustering.prepareCluster(clusters, corpusTexts, true);
        end = System.currentTimeMillis();
        results.add(new Result(resultKmeansPlus, end - start, "K means better start", clustering.globalCounter, evaluation.getAvgPurity(resultKmeansPlus)));
        System.out.println("Clustering with kmeans with incremental");
        start = System.currentTimeMillis();
        ArrayList<Centroid> resultKmeansIncremental = clustering.prepareClusterIncrement(corpusTexts, true);//Use better start?
        end = System.currentTimeMillis();
        results.add(new Result(resultKmeansIncremental, end - start, "K means incremental", clustering.globalCounter, evaluation.getAvgPurity(resultKmeansIncremental)));
        
        
        return results;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton chooseFolderRadioBtn;
    private javax.swing.JRadioButton classicCorpusRadioBtn;
    private javax.swing.JButton clusterBtn;
    private javax.swing.JTextField clustersTxtBx;
    private javax.swing.JComboBox combobox_similarity;
    private javax.swing.ButtonGroup corpusBtnGroups;
    private javax.swing.JRadioButton danishCorpusRadioBtn;
    private javax.swing.JRadioButton englishCorpusRadioBtn;
    private javax.swing.JTextField iterationTxtBx;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton resultBtn;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JRadioButton twentyCorpusRadioBtn;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Text> readFiles(String filePath, boolean withoutMostCommon) {

        ArrayList<Text> tempTexts = new ArrayList<>();

        if (withoutMostCommon) {
            File[] files = new File(filePath).listFiles();
            showFilesWithout(files, tempTexts);
        } else {
            File[] files = new File(filePath).listFiles();
            showFiles(files, tempTexts);
        }

        ArrayList<Text> texts = calculateTFDIF(tempTexts);
        


        return texts;
    }
    private void showFilesWithout(File[] files, ArrayList<Text> texts) {
        for (File file : files) {

            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                showFiles(file.listFiles(), texts); // Calls same method again.
            } else if (!file.getName().contains("DS_Store")) {
                System.out.println("File: " + file.getName());
                //Read corpus files
                HashMap<String, Integer> tempMap;

                tempMap = tp.readFileWith100MostCommon(file.getPath());
                texts.add(new Text(file.getName(), new Keywords(tempMap), file.getPath(), file.getParentFile().getName()));
            }
        }
    }

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
     private ArrayList<Text> calculateTFDIF(ArrayList<Text> texts) {
        TFIDF calculator = new TFIDF();
        HashMap<String, Double> termWeightMap;
        System.out.println("-- IF-IDF weight processing --");

        for (Text t : texts) {
            termWeightMap = new HashMap<>();

            for (HashMap.Entry<String, Integer> entry : t.keywords.keywordMap.entrySet()) {
                termWeightMap.put(entry.getKey(), calculator.calculateTFIDF(entry.getKey(), t, texts));
            }

            t.keywords.keywordTFIDFMap = termWeightMap;
        }

        //Initialize vectorspace in all texts
        for (Text t : texts) {
//            System.out.println(t.fileName + " size = " + calculator.termIDF.size());
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
     private void writeResultToFile(ArrayList<ArrayList<Result>> resultList, String filepath) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        FileWriter fileWriter = new FileWriter(filepath+".txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String headers = "Mehtod \t Purity \t Runtime";
        bufferedWriter.write(headers);
        for(ArrayList<Result> result : resultList) {
            for (Result r : result) {
                
            String stringToWrite = r.method + "\t"
                    + r.purity + "\t"
                    + r.runtime + "\t"
                    ;
            try {
                bufferedWriter.newLine();
                bufferedWriter.write(stringToWrite);

            } catch (IOException ex) {
            }
        }
        }
        
        bufferedWriter.close();

    }

    public String promptFilepath() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose where to save"); 
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getPath();
        } else {
            System.out.println("No Selection ");
            return "";
        }
    }
}
