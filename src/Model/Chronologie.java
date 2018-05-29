package Model;

import java.io.Serializable;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import java.io.File;

public class Chronologie implements Serializable{
	public ArrayList<Evenement> chListe = new ArrayList();
	public TreeSet<Evenement> chSet = new TreeSet();
	public HashMap<Integer, ArrayList<Evenement>> chMap = new HashMap<Integer, ArrayList<Evenement>>();
	public String chNom;
	public int chDebut;
	public int chFin;

	public String toString() {
		return chSet.toString() + "\n" + getNombre() + "\n";
	}

	public void ajout(Evenement parEvt) {
		GregorianCalendar aujoudhui = new GregorianCalendar(parEvt.getDate().getAnnee(), parEvt.getDate().getMois() - 1,
				parEvt.getDate().getJour());
		int numsemaine = aujoudhui.get(Calendar.WEEK_OF_YEAR);

		if (chMap.containsKey(numsemaine) == true) {
			ArrayList<Evenement> list = chMap.get(numsemaine);
			list.add(parEvt);
		} else {
			ArrayList<Evenement> list = new ArrayList();
			list.add(parEvt);
			chMap.put(numsemaine, list);
		}

		chListe.add(parEvt);
		chSet.add(parEvt);
	}

	public int calNbEvt(String parTitre) {
		int nb = 0;
		for (int i = 0; i < chListe.size(); i++) {
			if (chListe.get(i).getNom().contains(parTitre))
				nb++;
		}
		return nb;
	}

	public int calNbEvt(Date parDate) {
		int nb = 0;
		Iterator<Evenement> it = chSet.iterator();
		while (it.hasNext()) {
			Evenement e = it.next();
			if (e.getDate().compareTo(parDate) == 0)
				nb++;
		}
		return nb;
	}

	public int getNombre() {
		return chSet.size();
	}
}
