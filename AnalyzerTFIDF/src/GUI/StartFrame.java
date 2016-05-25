/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GroupOnFrequency.Grouper;
import Kmeans.Centroid;
import Kmeans.Clustering;
import analyzertfidf.BayesClassifier;
import analyzertfidf.Keywords;
import analyzertfidf.TFIDF;
import analyzertfidf.Text;
import analyzertfidf.TextProcessor;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;

/**
 *
 * @author Bryan
 */
public class StartFrame extends javax.swing.JFrame {

    JFileChooser chooser;
    String choosertitle;
    Clustering clustering;
    Grouper grouper;

    String filePath;
    ArrayList<Text> texts_list;
    ArrayList<String> distinctTerms;
    private BayesClassifier classifier;
    private final TextProcessor tp = new TextProcessor();

    /**
     * Creates new form StartFrame
     */
    public StartFrame() {
        grouper = new Grouper();
        filePath = "";
        clustering = new Clustering();
        updateFilePath();

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        readFiles1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        wordFrequencyReadBtn = new javax.swing.JButton();
        wordFrequencyTestBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        wordFrequencyMCWReadBtn = new javax.swing.JButton();
        startTest = new javax.swing.JButton();
        wordFrequencyMCWTestBtn = new javax.swing.JButton();
        readFiles = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        kmeansPlusReadBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        kmeansPlusTestBtn = new javax.swing.JButton();
        kmeansMCWReadBtn = new javax.swing.JButton();
        kmeansMCWTestBtn = new javax.swing.JButton();
        becnhmarkBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        checkbox_common_words = new javax.swing.JCheckBox();
        checkbox_better_start = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        combo_similarity_increment = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        text_clustering_iterations = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        text_clusters = new javax.swing.JTextField();
        combo_similarity = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        text_run_times = new javax.swing.JTextField();
        checkbox_use_params = new javax.swing.JCheckBox();

        readFiles1.setText("Read files");
        readFiles1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readFiles1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Group  on word frequency - plain");

        wordFrequencyReadBtn.setText("Read files");
        wordFrequencyReadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordFrequencyReadBtnActionPerformed(evt);
            }
        });

        wordFrequencyTestBtn.setText("Start clustering");
        wordFrequencyTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordFrequencyTestBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Group on word frequency - without most common words");

        wordFrequencyMCWReadBtn.setText("Read files");
        wordFrequencyMCWReadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordFrequencyMCWReadBtnActionPerformed(evt);
            }
        });

        startTest.setText("Start clustering");
        startTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTestActionPerformed(evt);
            }
        });

        wordFrequencyMCWTestBtn.setText("Start clustering");
        wordFrequencyMCWTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordFrequencyMCWTestBtnActionPerformed(evt);
            }
        });

        readFiles.setText("Read files");
        readFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readFilesActionPerformed(evt);
            }
        });

        jLabel5.setText("K means - with better initialization");

        jLabel1.setText("K means - plain");

        kmeansPlusReadBtn.setText("Read files");
        kmeansPlusReadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmeansPlusReadBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("K means - without most common words");

        kmeansPlusTestBtn.setText("Start clustering");
        kmeansPlusTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmeansPlusTestBtnActionPerformed(evt);
            }
        });

        kmeansMCWReadBtn.setText("Read files");
        kmeansMCWReadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmeansMCWReadBtnActionPerformed(evt);
            }
        });

        kmeansMCWTestBtn.setText("Start clustering");
        kmeansMCWTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmeansMCWTestBtnActionPerformed(evt);
            }
        });

        becnhmarkBtn.setText("Benchmark");
        becnhmarkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                becnhmarkBtnActionPerformed(evt);
            }
        });

        jLabel11.setText("Auto increment k means");

        jButton1.setText("Read files");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        checkbox_common_words.setText("Common words");
        checkbox_common_words.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_common_wordsActionPerformed(evt);
            }
        });

        checkbox_better_start.setText("Better start");

        jButton2.setText("Start clustering");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        combo_similarity_increment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(becnhmarkBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(kmeansPlusReadBtn))
                        .addGap(0, 244, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(readFiles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startTest))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(wordFrequencyReadBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(wordFrequencyTestBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(kmeansMCWReadBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kmeansMCWTestBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wordFrequencyMCWReadBtn)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(39, 39, 39)
                                .addComponent(checkbox_common_words)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkbox_better_start)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_similarity_increment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(kmeansPlusTestBtn)
                            .addComponent(wordFrequencyMCWTestBtn))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(readFiles)
                    .addComponent(startTest))
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kmeansMCWReadBtn)
                    .addComponent(kmeansMCWTestBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wordFrequencyReadBtn)
                    .addComponent(wordFrequencyTestBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wordFrequencyMCWReadBtn)
                    .addComponent(wordFrequencyMCWTestBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kmeansPlusReadBtn)
                    .addComponent(kmeansPlusTestBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(checkbox_common_words)
                    .addComponent(checkbox_better_start)
                    .addComponent(jButton2)
                    .addComponent(combo_similarity_increment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(becnhmarkBtn)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        jLabel6.setText("Parameters");

        text_clustering_iterations.setText("10");

        jLabel8.setText("Run times");

        text_clusters.setText("1");

        combo_similarity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0" }));

        jLabel10.setText("Clustering Iterations");

        jLabel9.setText("Clusters");

        jLabel7.setText("Min similarity");

        text_run_times.setText("1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(text_clusters)
                    .addComponent(text_clustering_iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_run_times, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_similarity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(text_clusters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_similarity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(text_clustering_iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_run_times, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        checkbox_use_params.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkbox_use_paramsStateChanged(evt);
            }
        });
        checkbox_use_params.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_use_paramsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkbox_use_params)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkbox_use_params)
                        .addGap(38, 38, 38))))
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void readFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readFilesActionPerformed

        filePath = promptFilepath();
        if (filePath != "") {
            startClustering(false, false);
        }
        updateFilePath();


    }//GEN-LAST:event_readFilesActionPerformed

    //Test kmeans plain
    private void startTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTestActionPerformed

        startClustering(false, false);
    }//GEN-LAST:event_startTestActionPerformed

    private void readFiles1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readFiles1ActionPerformed
        //Not used
    }//GEN-LAST:event_readFiles1ActionPerformed

    //Our won implementation read files and cluster
    private void wordFrequencyReadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordFrequencyReadBtnActionPerformed

        filePath = promptFilepath();
        if (filePath != "") {
            startGrouping(false);
        }

        updateFilePath();
    }//GEN-LAST:event_wordFrequencyReadBtnActionPerformed
    //Our own implementation test
    private void wordFrequencyTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordFrequencyTestBtnActionPerformed
        startGrouping(false);

    }//GEN-LAST:event_wordFrequencyTestBtnActionPerformed

    //Our own immplementation without most common read files and cluster
    private void wordFrequencyMCWReadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordFrequencyMCWReadBtnActionPerformed

        filePath = promptFilepath();
        if (filePath != "") {
            startGrouping(true);
        }

        updateFilePath();
    }//GEN-LAST:event_wordFrequencyMCWReadBtnActionPerformed

    //Our own immplementation without most common words test
    private void wordFrequencyMCWTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordFrequencyMCWTestBtnActionPerformed

        startGrouping(true);

    }//GEN-LAST:event_wordFrequencyMCWTestBtnActionPerformed

    //Kmeans with better start readfiles and cluster
    private void kmeansPlusReadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmeansPlusReadBtnActionPerformed

        filePath = promptFilepath();
        if (filePath != "") {
            startClustering(false, true);
        }

        updateFilePath();
    }//GEN-LAST:event_kmeansPlusReadBtnActionPerformed

    //Kmeans with better start test
    private void kmeansPlusTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmeansPlusTestBtnActionPerformed
        startClustering(false, true);

    }//GEN-LAST:event_kmeansPlusTestBtnActionPerformed

    //kmeans wihtout most common words read files and cluster
    private void kmeansMCWReadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmeansMCWReadBtnActionPerformed

        filePath = promptFilepath();
        if (filePath != "") {

            startClustering(true, false);

        }

        updateFilePath();
    }//GEN-LAST:event_kmeansMCWReadBtnActionPerformed
    //kmeans without most common words test
    private void kmeansMCWTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmeansMCWTestBtnActionPerformed
        startClustering(true, false);

    }//GEN-LAST:event_kmeansMCWTestBtnActionPerformed

    private void checkbox_use_paramsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_use_paramsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkbox_use_paramsActionPerformed

    private void checkbox_use_paramsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkbox_use_paramsStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_checkbox_use_paramsStateChanged

    private void becnhmarkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_becnhmarkBtnActionPerformed
        new BenchmarkOptions().setVisible(true);
    }//GEN-LAST:event_becnhmarkBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean betterStart = false;
        boolean withCommonWords = false;

        filePath = promptFilepath();
        if (filePath != "") {
            if (checkbox_better_start.isSelected()) {
                betterStart = true;
            }

            if (checkbox_common_words.isSelected()) {
                withCommonWords = true;
            }
            ArrayList<Text> texts = readFiles(filePath, withCommonWords);
            ArrayList<Centroid> result = clustering.prepareClusterIncrement(texts, betterStart);
            new MainFrame(result, classifier).setVisible(true);

        }
        updateFilePath();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void checkbox_common_wordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_common_wordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkbox_common_wordsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean betterStart = false;
        boolean withCommonWords = false;

        if (checkbox_better_start.isSelected()) {
            betterStart = true;
        }

        if (checkbox_common_words.isSelected()) {
            withCommonWords = true;
        }

        ArrayList<Text> texts = readFiles(filePath, withCommonWords);
        clustering.setMinSimilarity(Double.parseDouble(combo_similarity_increment.getSelectedItem().toString()));
        ArrayList<Centroid> result = clustering.prepareClusterIncrement(texts, betterStart);
        new MainFrame(result, classifier).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void benchMarkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_benchMarkBtnActionPerformed
        //Open benchmanrk options.
        new BenchmarkOptions().setVisible(true);
    }//GEN-LAST:event_benchMarkBtnActionPerformed

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
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartFrame().setVisible(true);
            }
        });
    }

    private void updateFilePath() {
        if (filePath == "") {
            filePath = "./resources/documents";
        }
    }

    private void startClustering(boolean withcommonwords, boolean betterStart) {
        if (checkbox_use_params.isSelected()) {
            ArrayList<Text> texts = readFiles(filePath, withcommonwords);
            System.out.println("PARAMS:\n"
                    + "Clusters: " + text_clusters.getText() + "\n"
                    + "Clustering iterations: " + text_clustering_iterations.getText() + "\n"
                    + "Minimum similarity: " + combo_similarity.getSelectedItem().toString() + "\n");
            int clusters = Integer.valueOf(text_clusters.getText());
            int max_iterations = Integer.valueOf(text_clustering_iterations.getText());
            double min_similarity = Double.valueOf(combo_similarity.getSelectedItem().toString());

            clustering.setParameters(max_iterations, min_similarity);
            ArrayList<Centroid> result = clustering.prepareCluster(clusters, texts, betterStart);
            new MainFrame(result, classifier).setVisible(true);
        } else {
            ArrayList<Text> texts = readFiles(filePath, withcommonwords);
            ArrayList<Centroid> result = clustering.prepareCluster(3, texts, betterStart);
            new MainFrame(result, classifier).setVisible(true);
        }
        filePath = "";
        updateFilePath();
    }

    private void startGrouping(boolean withcommonwords) {
        ArrayList<Text> texts = readFiles(filePath, withcommonwords);
        ArrayList<Centroid> result = grouper.group(texts);
        new MainFrame(result, classifier).setVisible(true);

    }

    /**
     * ACTUAL USE
     *
     */
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton becnhmarkBtn;
    private javax.swing.JCheckBox checkbox_better_start;
    private javax.swing.JCheckBox checkbox_common_words;
    private javax.swing.JCheckBox checkbox_use_params;
    private javax.swing.JComboBox combo_similarity;
    private javax.swing.JComboBox combo_similarity_increment;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton kmeansMCWReadBtn;
    private javax.swing.JButton kmeansMCWTestBtn;
    private javax.swing.JButton kmeansPlusReadBtn;
    private javax.swing.JButton kmeansPlusTestBtn;
    private javax.swing.JButton readFiles;
    private javax.swing.JButton readFiles1;
    private javax.swing.JButton startTest;
    private javax.swing.JTextField text_clustering_iterations;
    private javax.swing.JTextField text_clusters;
    private javax.swing.JTextField text_run_times;
    private javax.swing.JButton wordFrequencyMCWReadBtn;
    private javax.swing.JButton wordFrequencyMCWTestBtn;
    private javax.swing.JButton wordFrequencyReadBtn;
    private javax.swing.JButton wordFrequencyTestBtn;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Text> readFiles(String filePath, boolean withoutMostCommon) {

        ArrayList<Text> tempTexts = new ArrayList<>();

        if (withoutMostCommon) {
            File[] files = new File(filePath).listFiles();
            showFilesWithout(files, tempTexts);
        } else {
            System.out.println("Filepath: " + filePath);
            File[] files = new File(filePath).listFiles();
            showFiles(files, tempTexts);
        }

//        if (withoutMostCommon) {
//            //Read files without most common words
//
//            try {
//                Files.walk(Paths.get(filePath)).forEach(fp -> {
//                    if (Files.isRegularFile(fp)) {
//                        //Read corpus files
//                        final HashMap<String, Integer> tempMap;
//                        tempMap = tp.readFileWith100MostCommon(fp.getFileName().toString());
//                        tempTexts.add(new Text(fp.getFileName().toString(), new Keywords(tempMap)));
//                    }
//                });
//            } catch (IOException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            System.out.println("Processing Done");
//        } else {
//            //Just read files
//            try {
//                System.out.println(Paths.get(filePath));
//                Files.walk(Paths.get(filePath)).forEach(fp -> {
//                    if (Files.isRegularFile(fp)) {
//                        //Read corpus files
//                        final HashMap<String, Integer> tempMap;
//                        tempMap = tp.readFileActual(fp.getFileName().toString());
//                        tempTexts.add(new Text(fp.getFileName().toString(), new Keywords(tempMap)));
//                    }
//                });
//            } catch (IOException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            System.out.println("Processing Done");
//        }
        long start = System.currentTimeMillis();
        ArrayList<Text> texts = calculateTFDIF(tempTexts);
        long end = System.currentTimeMillis();

        System.out.println("TF-IDF Running time: " + (end - start) + "ms");

        return texts;
    }

    public String promptFilepath() {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //    
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getPath();
        } else {
            System.out.println("No Selection ");
            return "";
        }
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
                texts.add(new Text(file.getName(), new Keywords(tempMap), file.getPath()));
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
}
