package Model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ModelTable extends DefaultTableModel implements Data {

	private int chDebut;
	private int chFin;

	public ModelTable(Chronologie parchronologie) {

		int chDebut = parchronologie.getDebut();
		int chFin = parchronologie.getFin();

		this.setRowCount(4);
		this.setColumnCount(chFin - chDebut);

		String[] col = new String[chFin - chDebut + 1];

		for (int i = 0; i < chFin - chDebut + 1; i++) {
			if (i % 5 == 0)
				col[i] = chDebut + i + "";
			else
				col[i] = "";
		}

		this.setColumnIdentifiers(col);

		ArrayList<Evenement> list = parchronologie.getArrayList();

		for (Evenement s : list) {
			setValueAt(s, s.getPoids() - 1, s.getDate().getAnnee() - chDebut);
		}

	}

	public Class getColumnClass(int parColonne) {
		return Evenement.class;
	}

}