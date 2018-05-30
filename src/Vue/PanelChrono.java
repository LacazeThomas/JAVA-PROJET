package Vue;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Chronologie;
import Model.ModelTable;

public class PanelChrono extends JPanel {

    public static JTable chTable;
    Chronologie chChronologie;
    JScrollPane js;
    PanelDiapo chPanelDiapo;

    public PanelChrono(Chronologie parChronologie, PanelDiapo parPanelDiapo) {
        chChronologie = parChronologie;
        chPanelDiapo = parPanelDiapo;
        ModelTable modele = new ModelTable(chChronologie);

        chTable = new JTable(modele);

        chTable.setPreferredScrollableViewportSize(new Dimension(1300, 170));
        chTable.setRowHeight(50);
        chTable.setFillsViewportHeight(true);

        js = new JScrollPane(chTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        chTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        chTable.setDefaultRenderer(Object.class, new CelluleRenderer());
        add(js);
        chTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = chTable.rowAtPoint(evt.getPoint());
                int col = chTable.columnAtPoint(evt.getPoint());
                System.out.println(chTable.getValueAt(row, col));
                chPanelDiapo.gestionnaireDesCartes.show(chPanelDiapo.panelCentre, chTable.getValueAt(row, col) + "");
            }
        });

    }

    public static void goToCell(int parCell) {
        Rectangle cellRect = chTable.getCellRect(1, parCell, false);
        chTable.scrollRectToVisible(cellRect);
    }
}
