/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Kmeans.Centroid;
import Kmeans.Clustering;
import Kmeans.Comparer;
import analyzertfidf.Keywords;
import analyzertfidf.TFIDF;
import analyzertfidf.Text;
import analyzertfidf.TextProcessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Mads
 */
public class MainWindow extends javax.swing.JFrame {

    ArrayList<Text> texts = new ArrayList<>();
    ArrayList<String> distinctTerms;
    ArrayList<Centroid> result;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        //Initialize classes and maps
        TextProcessor tp = new TextProcessor();
        TFIDF calculator = new TFIDF();
        texts = new ArrayList<>();
        HashMap<String, Double> termWeightMap;

        //Read corpus files
        HashMap<String, Integer> tempMap;
//        for (int i = 1; i < 8; i++) {
//            String fileName = "Fighter" + i;
//            System.out.println("Processing: " + fileName);
//            tempMap = tp.readFile(fileName);
//            texts.add(new Text(fileName, new Keywords(tempMap)));
//        }
//        for (int i = 1; i < 8; i++) {
//            String fileName = "Dino" + i;
//            System.out.println("Processing: " + fileName);
//            tempMap = tp.readFile(fileName);
//            texts.add(new Text(fileName, new Keywords(tempMap)));
//        }
//        for (int i = 1; i < 8; i++) {
//            String fileName = "Physics" + i;
//            System.out.println("Processing: " + fileName);
//            tempMap = tp.readFile(fileName);
//            texts.add(new Text(fileName, new Keywords(tempMap)));
//        }

        for (int i = 1; i < 8; i++) {
            String fileName = "EuroparlDaEn" + i;
            System.out.println("Processing: " + fileName);
            tempMap = tp.readFile(fileName);
            texts.add(new Text(fileName, new Keywords(tempMap)));
        }
        for (int i = 1; i < 8; i++) {
            String fileName = "fairytale" + i;
            System.out.println("Processing: " + fileName);
            tempMap = tp.readFile(fileName);
            texts.add(new Text(fileName, new Keywords(tempMap)));
        }
//        for (int i = 1; i < 8; i++) {
//            String fileName = "Tank" + i;
//            System.out.println("Processing: " + fileName);
//            tempMap = tp.readFile(fileName);
//            texts.add(new Text(fileName, new Keywords(tempMap)));
//        }

        System.out.println("Processing Done\n");

        //Calculate IDIDF scores
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
        clusterTexts();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clustersList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        reClusterBtn = new javax.swing.JButton();
        findBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Clusters");

        clustersList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(clustersList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jLabel2.setText("Input");

        inputTextArea.setColumns(20);
        inputTextArea.setRows(5);
        jScrollPane2.setViewportView(inputTextArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reClusterBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(findBtn)
                        .addGap(0, 70, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reClusterBtn)
                    .addComponent(findBtn))
                .addContainerGap())
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
                new MainWindow().setVisible(true);
            }
        });
    }

    private void clusterTexts() {
        System.out.println("Clustering...");
        //Cluster texts
        Clustering clustering = new Clustering();
        result = clustering.prepareCluster(2, texts);
        //Add texts to List
        setListItems(result);
    }

    private void displayBelongingCorpus(Text input) {
        Kmeans.Comparer kmeansComparer = new Comparer();

        Double maxFound = 0.0;
        int index = 0;
        int count = 0;
        for (Double d : kmeansComparer.getSimilarities(result, input)) {
            if (d > maxFound) {
                maxFound = d;
                index = count;
                count++;
            } else {
                count++;
            }
        }
        //Set the isTheOne bool to true for the right index and false for all others
        for (Centroid c : result) {
            if (c == result.get(index)) {
                c.isTheOne = true;
            } else {
                c.isTheOne = false;
            }
        }
        setListItems(result);
    }

    private void setListItems(ArrayList<Centroid> items) {
        clustersList.setCellRenderer(new ClusterCellRenderer());
        DefaultListModel listModel = new DefaultListModel();
        for (Centroid c : items) {
            listModel.addElement(c);
        }
        clustersList.setModel(listModel);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList clustersList;
    private javax.swing.JButton findBtn;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton reClusterBtn;
    // End of variables declaration//GEN-END:variables
}
