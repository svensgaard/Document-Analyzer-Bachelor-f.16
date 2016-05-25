/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Evaluation.EvaluationWrapper;
import Evaluation.Result;
import Kmeans.Centroid;
import analyzertfidf.Text;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mads
 */
public class BenchmarkResults extends javax.swing.JFrame {

    private EvaluationWrapper evaluation = new EvaluationWrapper();
    private ArrayList<Result> results;

    /**
     * Creates new form BenchmarkResults
     *
     * @param results
     */
    public BenchmarkResults(ArrayList<Result> results) {
        initComponents();
        fillTable(results);
        this.results = results;
    }

    private BenchmarkResults() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsTabel = new javax.swing.JTable();
        printBtn = new javax.swing.JButton();
        button_close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Results");

        resultsTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Method", "Internal cluster similarity", "Inter cluster similarity", "Runtime", "Iterations run", "Purity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(resultsTabel);
        if (resultsTabel.getColumnModel().getColumnCount() > 0) {
            resultsTabel.getColumnModel().getColumn(0).setResizable(false);
            resultsTabel.getColumnModel().getColumn(1).setResizable(false);
            resultsTabel.getColumnModel().getColumn(2).setResizable(false);
            resultsTabel.getColumnModel().getColumn(3).setResizable(false);
            resultsTabel.getColumnModel().getColumn(4).setResizable(false);
            resultsTabel.getColumnModel().getColumn(5).setResizable(false);
        }

        printBtn.setText("Print to file");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });

        button_close.setText("Close");
        button_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(printBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(button_close)
                        .addGap(239, 239, 239)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_close))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(printBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
        String filepath = promptFilepath();
        if (filepath != "") {
            try {
                writeResultToFile(results, filepath);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BenchmarkResults.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(BenchmarkResults.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_printBtnActionPerformed

    private void button_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_button_closeActionPerformed

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
            java.util.logging.Logger.getLogger(BenchmarkResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BenchmarkResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BenchmarkResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BenchmarkResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BenchmarkResults().setVisible(true);
            }
        });
    }

    private void fillTable(ArrayList<Result> results) {
        DefaultTableModel model = (DefaultTableModel) resultsTabel.getModel();
        for (Result result : results) {             
            model.addRow(new Object[]{result.method, evaluation.getAvgSimilarity(result.result), evaluation.getAvgInterClusterSim(result.result), result.runtime, result.iterations, result.purity});
        }
    }

    private void writeResultToFile(ArrayList<Result> results, String filepath) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        FileWriter fileWriter = new FileWriter(filepath+".txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String headers = "Mehtod \t Internal cluster similarity \t Inter cluster similarity \t Runtime \t Iterations \t Purity";
        bufferedWriter.write(headers);
        for (Result result : results) {
            String stringToWrite = result.method + "\t"
                    + evaluation.getAvgSimilarity(result.result) + "\t"
                    + evaluation.getAvgInterClusterSim(result.result) + "\t"
                    + result.runtime + "\t"
                    + result.iterations + "\t"
                    + result.purity;
            try {
                bufferedWriter.newLine();
                bufferedWriter.write(stringToWrite);

            } catch (IOException ex) {
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printBtn;
    private javax.swing.JTable resultsTabel;
    // End of variables declaration//GEN-END:variables
}
