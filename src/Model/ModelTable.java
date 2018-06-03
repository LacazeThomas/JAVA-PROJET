package Model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ModelTable extends DefaultTableModel implements Data {

	private int chDebut;
	private int chFin;

	public ModelTable(Chronologie parchronologie) {

		int chDebut = parchronologie.getDebut();
		int chFin = parchronologie.getFin();

		//On défini 4 lignes
		this.setRowCount(4);

		//On défini les colonnes en fonction de l'écart entre la date de debut et de fin de la chronologie
		this.setColumnCount(chFin - chDebut);

		String[] col = new String[chFin - chDebut + 1];

		//Puis on écrit l'année tous les 5 ans
		for (int i = 0; i < chFin - chDebut + 1; i++) {
			if (i % 5 == 0)
				col[i] = chDebut + i + "";
			else
				col[i] = "";
		}


		//On affecte le String comme identifier
		this.setColumnIdentifiers(col);



		//Puis on place tous les evenements présentent dans la ModelTable
		ArrayList<Evenement> list = parchronologie.getArrayList();

		for (Evenement s : list) {
			setValueAt(s, s.getPoids() - 1, s.getDate().getAnnee() - chDebut);
		}

	}

/* 	public Class getColumnClass(int parColonne) {
		return Evenement.class;
	} */

}