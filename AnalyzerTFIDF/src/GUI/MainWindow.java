/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Evaluation.EvaluationWrapper;
import Kmeans.Centroid;
import Kmeans.Clustering;
import Kmeans.Comparer;
import LIX.LIXCalculator;
import SentenceLenght.SentenceClustere;
import SentenceLenght.SentenceFileReader;
import analyzertfidf.Keywords;
import analyzertfidf.TFIDF;
import analyzertfidf.Text;
import analyzertfidf.TextProcessor;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import static java.nio.file.Files.lines;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Mads
 */
public class MainWindow extends javax.swing.JFrame {

    ArrayList<Text> texts = new ArrayList<>();
    ArrayList<Text> textsWithout100Common = new ArrayList<>();

    ArrayList<String> distinctTerms;
    ArrayList<String> distinctTermsWithoutCommon;
    //Results
    ArrayList<Centroid> freqResult;
    ArrayList<Centroid> sentenceResult;
    ArrayList<Centroid> freqWithout100CommonResult;

    //ArrayLists for holding the true results
    EvaluationWrapper evaluation = new EvaluationWrapper();
    DecimalFormat df = new DecimalFormat("#.00");

    //Map to hold results and their counts
    TreeMap<String, Integer> countedResults = new TreeMap<String, Integer>();

    /**
     * Creates new form MainWindow
     */
    public MainWindow() throws FileNotFoundException, IOException {
        initComponents();
        //Set UI components
        jLabel1.setFont(new Font("Arial", Font.BOLD, 25));
        jLabel2.setFont(new Font("Arial", Font.BOLD, 25));
        jLabel3.setFont(new Font("Arial", Font.BOLD, 25));
        jLabel4.setFont(new Font("Arial", Font.BOLD, 25));
        jLabel5.setFont(new Font("Arial", Font.BOLD, 25));
        outputArea.setLineWrap(true);
        texts = new ArrayList<>();

        //Read textfiles
        readTexts();
        //Calculate IDIDF scores
        calculateTFDIF();
        calculateTFDIFWithoutMostCommon();
        //Cluster the texts
        for (int i = 0; i < 500; i++) {
            clusterTexts();
            //Count result
            double result = evaluation.getAverageSimilarityToTrueMostCommonWordsResult(freqWithout100CommonResult);
            if (countedResults.containsKey(df.format(result))) {
                countedResults.put(df.format(result), countedResults.get(df.format(result)) + 1);
            } else {
                countedResults.put(df.format(result), 1);
            }
        }
        writeSimilaritiesToFileCount();
//        clusterTexts();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        freqList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sentenceList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        outputTextArea = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        reClusterBtn = new javax.swing.JButton();
        findBtn = new javax.swing.JButton();
        accuracyBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        freqWithoutCommonList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1337, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setMaximumSize(new java.awt.Dimension(500, 500));

        freqList.setMaximumSize(new java.awt.Dimension(1500, 150));
        freqList.setMinimumSize(new java.awt.Dimension(1500, 150));
        freqList.setPreferredSize(new java.awt.Dimension(1500, 150));
        jScrollPane3.setViewportView(freqList);

        jLabel2.setText("Input");

        inputTextArea.setColumns(20);
        inputTextArea.setRows(5);
        inputTextArea.setMaximumSize(new java.awt.Dimension(200, 400));
        inputTextArea.setMinimumSize(new java.awt.Dimension(200, 400));
        inputTextArea.setPreferredSize(new java.awt.Dimension(200, 200));
        jScrollPane2.setViewportView(inputTextArea);

        jLabel1.setText("Word frequency");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(500, 500));

        sentenceList.setPreferredSize(new java.awt.Dimension(1500, 150));
        jScrollPane1.setViewportView(sentenceList);

        jLabel3.setText("Average sentence length");

        jLabel4.setText("Output");

        outputArea.setColumns(20);
        outputArea.setRows(5);
        outputTextArea.setViewportView(outputArea);

        reClusterBtn.setText("Re cluster");
        reClusterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reClusterBtnActionPerformed(evt);
            }
        });

        findBtn.setText("Find belonging cluster");
        findBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findBtnActionPerformed(evt);
            }
        });

        accuracyBtn.setText("Show accuracy");
        accuracyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accuracyBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Word frequency without most common words");

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setMaximumSize(new java.awt.Dimension(500, 500));

        freqWithoutCommonList.setPreferredSize(new java.awt.Dimension(1500, 150));
        jScrollPane4.setViewportView(freqWithoutCommonList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(reClusterBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(findBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accuracyBtn))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(outputTextArea))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(outputTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reClusterBtn)
                            .addComponent(findBtn)
                            .addComponent(accuracyBtn))
                        .addGap(120, 120, 120)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Recluster texts and show them
    private void reClusterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reClusterBtnActionPerformed
        clusterTexts();
    }//GEN-LAST:event_reClusterBtnActionPerformed
    //Find the belonging cluster of the input
    private void findBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findBtnActionPerformed
        //Read the textfield and generate a text object.
        TextProcessor tp = new TextProcessor();
        Text inputText = tp.readInput(inputTextArea.getText());

        //Calculate tfdif for input
        TFIDF calculator = new TFIDF();
        HashMap<String, Double> termWeightMap = new HashMap<>();
        for (HashMap.Entry<String, Integer> entry : inputText.keywords.keywordMap.entrySet()) {
            termWeightMap.put(entry.getKey(), calculator.calculateTFIDF(entry.getKey(), inputText, texts));
        }
        //TODO Find average sentence length of input
        inputText.keywords.keywordTFIDFMap = termWeightMap;
        //Calculate vectorspace
        inputText.vectorSpace = new Double[distinctTerms.size()];
        int count = 0;
        for (String s : distinctTerms) {
            if (inputText.keywords.keywordTFIDFMap.containsKey(s)) {
                inputText.vectorSpace[count] = inputText.keywords.keywordTFIDFMap.get(s);
            } else {
                inputText.vectorSpace[count] = 0.0;
            }
            count++;
        }

        //Results of input
        displayBelongingCorpus(inputText);
    }//GEN-LAST:event_findBtnActionPerformed

    private void accuracyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accuracyBtnActionPerformed
        int count = 1;
        outputArea.append("\n>>>>> frequency <<<<<<\n");
        for (Centroid centroid : freqResult) {

            outputArea.append("Cluster " + count + "\n");
            outputArea.append("Purity = " + centroid.getPurity() + "\n");
            outputArea.append("Average similarity of documents to average vector = " + df.format(centroid.getAverageDistance()) + "\n");
            count++;
        }
        outputArea.append("\n>>>>> frequency without most common words <<<<<<\n");
        for (Centroid centroid : freqWithout100CommonResult) {

            outputArea.append("Cluster " + count + "\n");
            outputArea.append("Purity = " + centroid.getPurity() + "\n");
            outputArea.append("Average similarity of documents to average vector = " + df.format(centroid.getAverageDistance()) + "\n");
            count++;
        }

        outputArea.append("Average similarity in frequency = " + evaluation.getAverageSimilarityToTrueFreqResult(freqResult) + "\n");
        outputArea.append("Average similarity in frequency without most common words = " + evaluation.getAverageSimilarityToTrueMostCommonWordsResult(freqWithout100CommonResult) + "\n");

    }//GEN-LAST:event_accuracyBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainWindow().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void clusterTexts() {
        System.out.println("Clustering...");
        Clustering clustering = new Clustering();
        SentenceClustere sentenceClustering = new SentenceClustere();

        //Cluster frequency  
        freqResult = clustering.prepareCluster(3, texts);
        //Add texts to List
        setFreqListItems(freqResult);

        //Cluster sentence length
        sentenceResult = sentenceClustering.prepareCluster(3, texts);
        //Add to list
        setSentenceListItems(sentenceResult);

        //Cluster frequecny without most common words
        freqWithout100CommonResult = clustering.prepareCluster(3, textsWithout100Common);
        //Add to list
        setFreqWithoutMostCommonListItems(freqWithout100CommonResult);
    }

    private void displayBelongingCorpus(Text input) {
        Kmeans.Comparer kmeansComparer = new Comparer();

        Double maxFound = 0.0;
        int index = 0;
        int count = 0;
        for (Double d : kmeansComparer.getSimilarities(freqResult, input)) {
            if (d > maxFound) {
                maxFound = d;
                index = count;
                count++;
            } else {
                count++;
            }
        }
        //Set the isTheOne bool to true for the right index and false for all others
        for (Centroid c : freqResult) {
            if (c == freqResult.get(index)) {
                c.isTheOne = true;
            } else {
                c.isTheOne = false;
            }
        }
        setFreqListItems(freqResult);
    }

    private void setFreqListItems(ArrayList<Centroid> items) {
        freqList.setCellRenderer(new ClusterCellRenderer());
        DefaultListModel listModel = new DefaultListModel();
        for (Centroid c : items) {
            listModel.addElement(c);
        }
        freqList.setModel(listModel);
    }

    private void setFreqWithoutMostCommonListItems(ArrayList<Centroid> items) {
        freqWithoutCommonList.setCellRenderer(new ClusterCellRenderer());
        DefaultListModel listModel = new DefaultListModel();
        for (Centroid c : items) {
            listModel.addElement(c);
        }
        freqWithoutCommonList.setModel(listModel);
    }

    private void setSentenceListItems(ArrayList<Centroid> items) {
        sentenceList.setCellRenderer(new ClusterCellRenderer());
        DefaultListModel listModel = new DefaultListModel();
        for (Centroid c : items) {
            listModel.addElement(c);
        }
        sentenceList.setModel(listModel);
    }

    //MCW = most commonwords
    private void readTexts() {
        //Initialize classes and maps
        LIXCalculator lixCalculator = new LIXCalculator();
        TextProcessor tp = new TextProcessor();
        texts = new ArrayList<>();
        textsWithout100Common = new ArrayList<>();
        ArrayList<Centroid> trueFreqResultHolder = new ArrayList<>();
        ArrayList<Centroid> trueMCWResultHolder = new ArrayList<>();
        SentenceFileReader sentenceReader = new SentenceFileReader();

        //Read corpus files
        HashMap<String, Integer> tempMap;
        Centroid trueFreqEuroparl = new Centroid();
        Centroid trueMCWEuroparl = new Centroid();
        for (int i = 1; i < 8; i++) {
            String fileName = "EuroparlDaEn" + i;
            System.out.println("Processing: " + fileName);
            System.out.println("Lix number: " + lixCalculator.calculateLix(fileName));
            //Text with most common words
            tempMap = tp.readFile(fileName);
            Text freqText = new Text(fileName, new Keywords(tempMap), "Politic", sentenceReader.readFile(fileName));
            texts.add(freqText);
            //Add to true centroid
            trueFreqEuroparl.GroupedDocument.add(freqText);
            //Text without 100 most common words
            tempMap = tp.readFileWith100MostCommon(fileName);
            Text MCWText = new Text(fileName, new Keywords(tempMap), "Politic");
            textsWithout100Common.add(MCWText);
            trueMCWEuroparl.GroupedDocument.add(MCWText);

        }
        Centroid trueFreqFairytale = new Centroid();
        Centroid trueMCWFairytale = new Centroid();

        for (int i = 1; i < 8; i++) {
            String fileName = "fairytale" + i;
            System.out.println("Processing: " + fileName);
            System.out.println("Lix number: " + lixCalculator.calculateLix(fileName));

            //Texts with the most common words
            tempMap = tp.readFile(fileName);
            Text freqText = new Text(fileName, new Keywords(tempMap), "Fairytale", sentenceReader.readFile(fileName));
            texts.add(freqText);
            //Add to true centroid
            trueFreqFairytale.GroupedDocument.add(freqText);
            //Text without 100 most common words
            tempMap = tp.readFileWith100MostCommon(fileName);
            Text MCWText = new Text(fileName, new Keywords(tempMap), "Fairytale");
            textsWithout100Common.add(MCWText);
            trueMCWFairytale.GroupedDocument.add(MCWText);
        }
        Centroid trueFreqMedical = new Centroid();
        Centroid trueMCWMedical = new Centroid();
        for (int i = 1; i < 8; i++) {
            String fileName = "Medical" + i;
            System.out.println("Processing: " + fileName);
            System.out.println("Lix number: " + lixCalculator.calculateLix(fileName));

            //Text with the most common words
            tempMap = tp.readFile(fileName);
            Text freqText = new Text(fileName, new Keywords(tempMap), "Medical", sentenceReader.readFile(fileName));
            texts.add(freqText);
            //Add to true centroid
            trueFreqMedical.GroupedDocument.add(freqText);
            //Text without the 100 most common words
            tempMap = tp.readFileWith100MostCommon(fileName);
            Text MCWText = new Text(fileName, new Keywords(tempMap), "Medical");
            textsWithout100Common.add(MCWText);
            trueMCWMedical.GroupedDocument.add(MCWText);
        }
        //Add to array and then add the evaluation wrapper.
        trueFreqResultHolder.add(trueFreqEuroparl);
        trueFreqResultHolder.add(trueFreqFairytale);
        trueFreqResultHolder.add(trueFreqMedical);
        trueMCWResultHolder.add(trueMCWEuroparl);
        trueMCWResultHolder.add(trueMCWFairytale);
        trueMCWResultHolder.add(trueMCWMedical);
        evaluation.setTrueFreqResult(trueFreqResultHolder);
        evaluation.setTrueMostCommonWordsResult(trueMCWResultHolder);
        System.out.println("Processing Done");
    }

    private void calculateTFDIF() {
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
    }

    private void calculateTFDIFWithoutMostCommon() {
        TFIDF calculator = new TFIDF();
        HashMap<String, Double> termWeightMap;
        System.out.println("-- IF-IDF weight without most common words--");

        for (Text t : textsWithout100Common) {
            termWeightMap = new HashMap<>();

            for (HashMap.Entry<String, Integer> entry : t.keywords.keywordMap.entrySet()) {
                termWeightMap.put(entry.getKey(), calculator.calculateTFIDF(entry.getKey(), t, textsWithout100Common));
            }

            t.keywords.keywordTFIDFMap = termWeightMap;
        }

        //Make a list of all distinct terms in the corpus
        distinctTermsWithoutCommon = new ArrayList<>();
        for (Text t : textsWithout100Common) {
            Iterator it = t.keywords.keywordMap.entrySet().iterator();
            for (int i = 0; i < t.keywords.size(); i++) {
                Map.Entry<String, Integer> pair = (Map.Entry) it.next();
                if (!distinctTermsWithoutCommon.contains(pair.getKey())) {
                    distinctTermsWithoutCommon.add(pair.getKey());
                }
            }
        }
        //Initialize vectorspace in all texts
        for (Text t : textsWithout100Common) {
            t.vectorSpace = new Double[distinctTermsWithoutCommon.size()];
            int count = 0;
            for (String s : distinctTermsWithoutCommon) {
                if (t.keywords.keywordTFIDFMap.containsKey(s)) {
                    t.vectorSpace[count] = t.keywords.keywordTFIDFMap.get(s);
                } else {
                    t.vectorSpace[count] = 0.0;
                }
                count++;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accuracyBtn;
    private javax.swing.JButton findBtn;
    private javax.swing.JList freqList;
    private javax.swing.JList freqWithoutCommonList;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JScrollPane outputTextArea;
    private javax.swing.JButton reClusterBtn;
    private javax.swing.JList sentenceList;
    // End of variables declaration//GEN-END:variables

    //Write to file
    private void writeSimilaritiesToFile() throws UnsupportedEncodingException, FileNotFoundException, IOException {
        String stringToWrite = "0" + df.format(evaluation.getAverageSimilarityToTrueFreqResult(freqResult)) + "\t";
        try {
            Files.write(Paths.get("resultsFreq.txt"), stringToWrite.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {

        }
    }

    private void writeSimilaritiesToFileCount() throws UnsupportedEncodingException, FileNotFoundException, IOException {
        FileWriter fileWriter = new FileWriter("resultsMCW200Counted.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
        for (Map.Entry<String, Integer> entry : countedResults.entrySet()) {
            String stringToWrite = entry.getKey() + "\t" + entry.getValue();
            try {
                bufferedWriter.newLine();
                bufferedWriter.write(stringToWrite);

            } catch (IOException ex) {
            }
        }
        bufferedWriter.close();

    }
}
