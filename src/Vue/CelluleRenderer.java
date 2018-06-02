package Vue;

import java.awt.Component;
import java.awt.Image;

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
            setIcon(new ImageIcon(new ImageIcon("images/" + testEvt.getPath()).getImage().getScaledInstance(70, 50,
                    Image.SCALE_DEFAULT)));
        } else {
            setIcon(new ImageIcon("dffd"));
        }

        return cell;
    }
}
