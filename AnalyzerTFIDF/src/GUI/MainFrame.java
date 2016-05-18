/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Evaluation.EvaluationWrapper;
import Kmeans.Centroid;
import analyzertfidf.BayesClassifier;
import analyzertfidf.Text;
import analyzertfidf.TextProcessor;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Bryan
 */
public class MainFrame extends javax.swing.JFrame {

    String filePath;
    ArrayList<Text> texts_list;
    ArrayList<String> distinctTerms;
    private ArrayList<Centroid> result;
    private ArrayList<String> cluster_list;
    private BayesClassifier classifier;
    private final TextProcessor tp = new TextProcessor();
    private EvaluationWrapper evaluation = new EvaluationWrapper();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initFields();
        
        initComponents();
    }
    
    public MainFrame(ArrayList<Centroid> result) {
        initFields();
        this.result = result;
        initComponents();
    }
    
    public MainFrame(ArrayList<Centroid> result, String filePath, BayesClassifier classifier) {
        initFields();

        this.filePath = filePath;
        this.result = result;
        this.classifier = classifier;
        
        initComponents();
    }

    public MainFrame(ArrayList<Centroid> result, BayesClassifier classifier) {
        initFields();

        this.result = result;
        this.classifier = classifier;
        
        initComponents();
    }

    private void initFields() {
        texts_list = new ArrayList<>();
    }
    private void evaluateResult(ArrayList<Centroid> result) {
        avgDistToCenterLabel.setText(String.valueOf(evaluation.getAvgDistance(result)));
        avgDistBetweenClustersLabel.setText(String.valueOf(evaluation.getAvgInterClusterDist(result)));
        avgSimToCenterLabel.setText(String.valueOf(evaluation.getAvgSimilarity(result)));
        avgSimBetweenCentersLabel.setText(String.valueOf(evaluation.getAvgInterClusterSim(result)));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        corpora_scroll = new javax.swing.JScrollPane();
        list_corpus = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        texts_scroll = new javax.swing.JScrollPane();
        list_texts = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        button_back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_area_input = new javax.swing.JTextArea();
        classify = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        text_area_result = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        avgDistToCenterLabel = new javax.swing.JLabel();
        avgDistBetweenClustersLabel = new javax.swing.JLabel();
        avgSimToCenterLabel = new javax.swing.JLabel();
        avgSimBetweenCentersLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        list_corpus.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return result.size(); }
            public Object getElementAt(int i) { return result.get(i); }
        });
        list_corpus.setSelectedIndex(0);

        list_corpus.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    getTexts(list_corpus.getSelectedIndex());
                }
            }
        });
        corpora_scroll.setViewportView(list_corpus);

        jLabel1.setText("Corpora");

        list_texts.setModel(new javax.swing.AbstractListModel() {

            public int getSize() { return texts_list.size(); }
            public Object getElementAt(int i) { return texts_list.get(i).fileName; }
        });
        texts_scroll.setViewportView(list_texts);
        getTexts(list_corpus.getSelectedIndex());

        jLabel2.setText("Texts");

        button_back.setText("Back");
        button_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_backActionPerformed(evt);
            }
        });

        text_area_input.setColumns(20);
        text_area_input.setRows(5);
        jScrollPane1.setViewportView(text_area_input);

        classify.setText("Classify");
        classify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classifyActionPerformed(evt);
            }
        });

        text_area_result.setEditable(false);
        text_area_result.setColumns(20);
        text_area_result.setRows(5);
        jScrollPane2.setViewportView(text_area_result);

        jLabel3.setText("Result");

        jLabel4.setText("Input");

        jLabel5.setText("Stats for clustering");

        jLabel6.setText("Average distance to cluster center");

        jLabel7.setText("Average distance bewtween clusters");

        jLabel8.setText("Average similarity to cluster center");

        jLabel9.setText("Average similarity between cluster centers:");

        avgDistToCenterLabel.setText("jLabel10");

        avgDistBetweenClustersLabel.setText("jLabel11");

        avgSimToCenterLabel.setText("jLabel12");

        avgSimBetweenCentersLabel.setText("jLabel13");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_back)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(corpora_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(texts_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(avgDistToCenterLabel)
                                    .addComponent(avgDistBetweenClustersLabel)
                                    .addComponent(avgSimToCenterLabel)
                                    .addComponent(avgSimBetweenCentersLabel))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(143, 143, 143))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(152, 152, 152))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(classify)
                                .addGap(118, 118, 118))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_back)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(texts_scroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(corpora_scroll, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(classify)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(avgDistToCenterLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(avgDistBetweenClustersLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(avgSimToCenterLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(avgSimBetweenCentersLabel))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_backActionPerformed
        new StartFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_backActionPerformed

    private void classifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classifyActionPerformed
        text_area_result.setText("Your input belongs to cluster: " + classifier.predictClassification(text_area_input.getText()));
    }//GEN-LAST:event_classifyActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    public void getTexts(int index) {
        texts_list = result.get(index).GroupedDocument;

        list_texts.setModel(new javax.swing.AbstractListModel() {
            public int getSize() {
                return texts_list.size();
            }

            public Object getElementAt(int i) {
                return texts_list.get(i).fileName;
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avgDistBetweenClustersLabel;
    private javax.swing.JLabel avgDistToCenterLabel;
    private javax.swing.JLabel avgSimBetweenCentersLabel;
    private javax.swing.JLabel avgSimToCenterLabel;
    private javax.swing.JButton button_back;
    private javax.swing.JButton classify;
    private javax.swing.JScrollPane corpora_scroll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList list_corpus;
    private javax.swing.JList list_texts;
    private javax.swing.JTextArea text_area_input;
    private javax.swing.JTextArea text_area_result;
    private javax.swing.JScrollPane texts_scroll;
    // End of variables declaration//GEN-END:variables

}
