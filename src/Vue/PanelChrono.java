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
    private JScrollPane chJs;
    private PanelDiapo chPanelDiapo;

    public PanelChrono(Chronologie parChronologie, PanelDiapo parPanelDiapo) {
        chChronologie = parChronologie;
        chPanelDiapo = parPanelDiapo;
        ModelTable modele = new ModelTable(chChronologie);

        chTable = new JTable(modele);


        //On affecte une dimension qui correspond à la fenetre mere
        chTable.setPreferredScrollableViewportSize(new Dimension(1300, 200));
        chTable.setRowHeight(50);
        chTable.setFillsViewportHeight(true);

        //On mets une scroolbar si necessaire
        chJs = new JScrollPane(chTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //On refuse la resize
        chTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        //On appelle CelluleRenderer
        chTable.setDefaultRenderer(Object.class, new CelluleRenderer());
        chTable.getTableHeader().setReorderingAllowed(false);
        chTable.getTableHeader().setResizingAllowed(false);
        //On refuse la selection d'un ligne
        chTable.setRowSelectionAllowed(false);

        add(chJs);

        //Si il y a un clique sur un evenement 
        chTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                //On recupere les coordonées
                int row = chTable.rowAtPoint(evt.getPoint());
                int col = chTable.columnAtPoint(evt.getPoint());

                //Puis on affiche la diapo en rapport
                //Les diapo sont identifées par leurs nom d'evenement
                chPanelDiapo.getCardLayout().show(chPanelDiapo.getPanelCentre(), chTable.getValueAt(row, col) + "");
            }
        });

    }


    //Cette methode permet de déplacer la scrollbar en fonction du diaporama
    public static void goToCell(int parCell) {
        Rectangle cellRect = chTable.getCellRect(1, parCell, false);
        chTable.scrollRectToVisible(cellRect);
    }
}
