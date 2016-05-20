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
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        filePath = null;
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
        startTest = new javax.swing.JButton();
        readFiles = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kmeansMCWReadBtn = new javax.swing.JButton();
        kmeansMCWTestBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        wordFrequencyReadBtn = new javax.swing.JButton();
        wordFrequencyTestBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        wordFrequencyMCWReadBtn = new javax.swing.JButton();
        wordFrequencyMCWTestBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        kmeansPlusReadBtn = new javax.swing.JButton();
        kmeansPlusTestBtn = new javax.swing.JButton();

        readFiles1.setText("Read files");
        readFiles1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readFiles1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startTest.setText("Start test");
        startTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTestActionPerformed(evt);
            }
        });

        readFiles.setText("Read files");
        readFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readFilesActionPerformed(evt);
            }
        });

        jLabel1.setText("K means - plain");

        jLabel2.setText("K means - without most common words");

        kmeansMCWReadBtn.setText("Read files");
        kmeansMCWReadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmeansMCWReadBtnActionPerformed(evt);
            }
        });

        kmeansMCWTestBtn.setText("Start test");
        kmeansMCWTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmeansMCWTestBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Group  on word frequency - plain");

        wordFrequencyReadBtn.setText("Read files");
        wordFrequencyReadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordFrequencyReadBtnActionPerformed(evt);
            }
        });

        wordFrequencyTestBtn.setText("Start test");
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

        wordFrequencyMCWTestBtn.setText("Start test");
        wordFrequencyMCWTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordFrequencyMCWTestBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("K means - with better initialization");

        kmeansPlusReadBtn.setText("Read files");
        kmeansPlusReadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmeansPlusReadBtnActionPerformed(evt);
            }
        });

        kmeansPlusTestBtn.setText("Start test");
        kmeansPlusTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmeansPlusTestBtnActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(readFiles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(startTest))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(wordFrequencyReadBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(wordFrequencyTestBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kmeansMCWReadBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kmeansMCWTestBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(wordFrequencyMCWReadBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kmeansPlusTestBtn)
                                    .addComponent(wordFrequencyMCWTestBtn))))
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(kmeansPlusReadBtn))
                        .addGap(0, 73, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(readFiles)
                    .addComponent(startTest))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kmeansMCWReadBtn)
                    .addComponent(kmeansMCWTestBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wordFrequencyReadBtn)
                    .addComponent(wordFrequencyTestBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wordFrequencyMCWReadBtn)
                    .addComponent(wordFrequencyMCWTestBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kmeansPlusReadBtn)
                    .addComponent(kmeansPlusTestBtn))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void readFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readFilesActionPerformed

        filePath = promptFilepath();
        if (filePath != "") {
            ArrayList<Text> texts = readFiles(filePath, false);
            ArrayList<Centroid> result = clustering.prepareCluster(3, texts, false);
            initClassifier(result);
            new MainFrame(result, classifier).setVisible(true);
        }


    }//GEN-LAST:event_readFilesActionPerformed

    //Test kmeans plain
    private void startTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTestActionPerformed
        //TODO read test files
        ArrayList<Text> texts = readFiles(filePath, false);
        ArrayList<Centroid> result = clustering.prepareCluster(3, texts, false);
        initClassifier(result);
        new MainFrame(result, classifier).setVisible(true);
    }//GEN-LAST:event_startTestActionPerformed

    private void readFiles1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readFiles1ActionPerformed
        //Not used
    }//GEN-LAST:event_readFiles1ActionPerformed

    //Our won implementation read files and cluster
    private void wordFrequencyReadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordFrequencyReadBtnActionPerformed

        filePath = promptFilepath();
        if (filePath != "") {
            ArrayList<Text> texts = readFiles(filePath, false);
            ArrayList<Centroid> result = grouper.group(texts);
            initClassifier(result);
            new MainFrame(result, classifier).setVisible(true);
        }
    }//GEN-LAST:event_wordFrequencyReadBtnActionPerformed
    //Our own implementation test
    private void wordFrequencyTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordFrequencyTestBtnActionPerformed
        // TODO read test files
        ArrayList<Text> texts = readFiles(filePath, false);
        ArrayList<Centroid> result = grouper.group(texts);
        initClassifier(result);
        new MainFrame(result, classifier).setVisible(true);
    }//GEN-LAST:event_wordFrequencyTestBtnActionPerformed

    //Our own immplementation without most common read files and cluster
    private void wordFrequencyMCWReadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordFrequencyMCWReadBtnActionPerformed
       
        filePath = promptFilepath();
        if (filePath != "") {
            ArrayList<Text> texts = readFiles(filePath, true);
            ArrayList<Centroid> result = grouper.group(texts);
            initClassifier(result);
            new MainFrame(result, classifier).setVisible(true);
        }
    }//GEN-LAST:event_wordFrequencyMCWReadBtnActionPerformed

    //Our own immplementation without most common words test
    private void wordFrequencyMCWTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordFrequencyMCWTestBtnActionPerformed
        // TODO read test files without most frequent words
        ArrayList<Text> texts = readFiles(filePath, true);
        ArrayList<Centroid> result = grouper.group(texts);

        initClassifier(result);

        new MainFrame(result, classifier).setVisible(true);
    }//GEN-LAST:event_wordFrequencyMCWTestBtnActionPerformed

    //Kmeans with better start readfiles and cluster
    private void kmeansPlusReadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmeansPlusReadBtnActionPerformed
        
        filePath = promptFilepath();
        if (filePath != "") {
            ArrayList<Text> texts = readFiles(filePath, false);
            ArrayList<Centroid> result = clustering.prepareCluster(3, texts, true);
            initClassifier(result);
            new MainFrame(result, classifier).setVisible(true);
        }
    }//GEN-LAST:event_kmeansPlusReadBtnActionPerformed

    //Kmeans with better start test
    private void kmeansPlusTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmeansPlusTestBtnActionPerformed
       
        ArrayList<Text> texts = readFiles(filePath, false);
        ArrayList<Centroid> result = clustering.prepareCluster(3, texts, true);
        initClassifier(result);
        new MainFrame(result, classifier).setVisible(true);
    }//GEN-LAST:event_kmeansPlusTestBtnActionPerformed

    //kmeans wihtout most common words read files and cluster
    private void kmeansMCWReadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmeansMCWReadBtnActionPerformed
        
        filePath = promptFilepath();
        if (filePath != "") {
            ArrayList<Text> texts = readFiles(filePath, true);
            ArrayList<Centroid> result = clustering.prepareCluster(3, texts, false);

            initClassifier(result);
            new MainFrame(result, classifier).setVisible(true);
        }
    }//GEN-LAST:event_kmeansMCWReadBtnActionPerformed
    //kmeans without most common words test
    private void kmeansMCWTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmeansMCWTestBtnActionPerformed
        //TODO read test files without most common words
        ArrayList<Text> texts = readFiles(filePath, true);
        ArrayList<Centroid> result = clustering.prepareCluster(3, texts, false);

        initClassifier(result);
        new MainFrame(result, classifier).setVisible(true);
    }//GEN-LAST:event_kmeansMCWTestBtnActionPerformed

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
        if (filePath == null) {
            filePath = "./resources/documents";
        }
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

        //Make a list of all distinct terms in the corpus
        distinctTerms = new ArrayList<>();
        for (Text t : texts) {
            Iterator it = t.keywords.keywordMap.entrySet().iterator();
            for (int i = 0; i < t.keywords.size(); i++) {
                Map.Entry<String, Integer> pair = (Map.Entry) it.next();
                if (!distinctTerms.contains(pair.getKey())) {
                    distinctTerms.add(pair.getKey());
                }
            }
        }
        //Initialize vectorspace in all texts
        for (Text t : texts) {
            t.vectorSpace = new Double[distinctTerms.size()];
            int count = 0;
            for (String s : distinctTerms) {
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

    private void initClassifier(ArrayList<Centroid> result) {
        try {
            tp.generateTrainingData(result, filePath);
        } catch (IOException ex) {
            Logger.getLogger(StartFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Initialize classifier
        classifier = new BayesClassifier();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton kmeansMCWReadBtn;
    private javax.swing.JButton kmeansMCWTestBtn;
    private javax.swing.JButton kmeansPlusReadBtn;
    private javax.swing.JButton kmeansPlusTestBtn;
    private javax.swing.JButton readFiles;
    private javax.swing.JButton readFiles1;
    private javax.swing.JButton startTest;
    private javax.swing.JButton wordFrequencyMCWReadBtn;
    private javax.swing.JButton wordFrequencyMCWTestBtn;
    private javax.swing.JButton wordFrequencyReadBtn;
    private javax.swing.JButton wordFrequencyTestBtn;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Text> readFiles(String filePath, boolean withoutMostCommon) {

        ArrayList<Text> tempTexts = new ArrayList<>();

        if (withoutMostCommon) {
            //Read files without most common words

            try {
                Files.walk(Paths.get(filePath)).forEach(fp -> {
                    if (Files.isRegularFile(fp)) {
                        //Read corpus files
                        final HashMap<String, Integer> tempMap;
                        tempMap = tp.readFileWith100MostCommon(fp.getFileName().toString());
                        tempTexts.add(new Text(fp.getFileName().toString(), new Keywords(tempMap)));
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Processing Done");
        } else {
            //Just read files
            try {
                System.out.println(Paths.get(filePath));
                Files.walk(Paths.get(filePath)).forEach(fp -> {
                    if (Files.isRegularFile(fp)) {
                        //Read corpus files
                        final HashMap<String, Integer> tempMap;
                        tempMap = tp.readFileActual(fp.getFileName().toString());
                        tempTexts.add(new Text(fp.getFileName().toString(), new Keywords(tempMap)));
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Processing Done");
        }

        ArrayList<Text> texts = calculateTFDIF(tempTexts);

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
}
