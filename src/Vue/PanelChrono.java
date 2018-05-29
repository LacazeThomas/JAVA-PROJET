package Vue;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Chronologie;
import Model.ModelTable;

public class PanelChrono extends JPanel{
	
    JTable chTable;
    Chronologie chChronologie;
    
	public PanelChrono(Chronologie parChronologie) {
        chChronologie = parChronologie;
        ModelTable modele = new ModelTable(chChronologie);

        chTable = new JTable(modele);

        chTable.setPreferredScrollableViewportSize(new Dimension(1300,170));
        chTable.setRowHeight(40);
        chTable.setFillsViewportHeight(true);

        JScrollPane js = new JScrollPane(chTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        chTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        add(js);
        
	}
	
    public void setModel(Chronologie parChronologie){
        ModelTable modele = new ModelTable(parChronologie);
        chTable.setModel(modele);
    }
}