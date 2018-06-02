package Vue;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Chronologie;
import Model.ModelTable;

public class PanelChrono extends JPanel {

    private static JTable chTable;
    private Chronologie chChronologie;
    private JScrollPane js;
    private PanelDiapo chPanelDiapo;

    public PanelChrono(Chronologie parChronologie, PanelDiapo parPanelDiapo) {
        chChronologie = parChronologie;
        chPanelDiapo = parPanelDiapo;
        ModelTable modele = new ModelTable(chChronologie);

        chTable = new JTable(modele);

        chTable.setPreferredScrollableViewportSize(new Dimension(1300, 200));
        chTable.setRowHeight(50);
        chTable.setFillsViewportHeight(true);

        js = new JScrollPane(chTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        chTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        chTable.setDefaultRenderer(Object.class, new CelluleRenderer());
        chTable.getTableHeader().setReorderingAllowed(false);
        chTable.getTableHeader().setResizingAllowed(false);
        chTable.setRowSelectionAllowed(false);

        add(js);
        chTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = chTable.rowAtPoint(evt.getPoint());
                int col = chTable.columnAtPoint(evt.getPoint());
                chPanelDiapo.getCardLayout().show(chPanelDiapo.getPanelCentre(), chTable.getValueAt(row, col) + "");
            }
        });

    }

    public static void goToCell(int parCell) {
        Rectangle cellRect = chTable.getCellRect(1, parCell, false);
        chTable.scrollRectToVisible(cellRect);
    }
}
