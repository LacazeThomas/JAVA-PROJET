package Vue;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import Model.Evenement;

public class CelluleRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof Evenement) {
            Evenement testEvt = (Evenement) value;
            setIcon(new ImageIcon("images/" + testEvt.getPath()));
        } else {
            setIcon(new ImageIcon("dffd"));
        }
        // setBackground(new java.awt.Color(255,012,120));
        // System.out.print(testEvt.getNom().equals(null));
        // setIcon(new ImageIcon("images/"+testEvt.getPath()));

        return cell;
    }
}
