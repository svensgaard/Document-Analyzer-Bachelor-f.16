/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Kmeans.Centroid;
import analyzertfidf.Text;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.border.LineBorder;

/**
 *
 * @author Mads
 */
public class ClusterCellRenderer extends DefaultListCellRenderer{
    public Component getListCellRendererComponent(JList<?> list,
                                 Object value,
                                 int index,
                                 boolean isSelected,
                                 boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Centroid) {
            Centroid cluster = (Centroid)value;
            //Build string for cluster
            if(cluster.isTheOne) {
                setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.red), new LineBorder(Color.white)));
            }
            StringBuilder textBuilder = new StringBuilder();
            textBuilder.append("Cluster ");
            for (Text text : cluster.GroupedDocument) {
                textBuilder.append(text.fileName);
                
            }
            setText(textBuilder.toString());
            //setToolTipText(" ");
            // setIcon(ingredient.getIcon());
        }
        return this;
    }
}
