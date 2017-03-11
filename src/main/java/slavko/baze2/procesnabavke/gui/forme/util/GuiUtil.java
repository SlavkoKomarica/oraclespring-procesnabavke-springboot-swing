/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slavko.baze2.procesnabavke.gui.forme.util;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Slavko
 */
public class GuiUtil {

    public static void resizeColumnWidth(JTable table, int minWidth) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = minWidth; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    public static void enableComponents(Container container, boolean enable) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (!(component instanceof JLabel)) {
                component.setEnabled(enable);
                if(component instanceof JButton){
                    ((JButton)component).setSelected(false);
                }
            }
            if (component instanceof Container) {
                enableComponents((Container) component, enable);
            }
        }
    }
}
