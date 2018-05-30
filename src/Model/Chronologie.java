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
	private ArrayList<Evenement> chListe = new ArrayList();
	private HashMap<Integer, ArrayList<Evenement>> chMap = new HashMap<Integer, ArrayList<Evenement>>();
	private String chNom;
	private int chDebut;
	private int chFin;

	public String toString() {
		return chListe.toString();
	}
	
	public ArrayList<Evenement> getArrayList(){
		return chListe;
	}

	public String getNom() {
		return chNom;
	}
	
	public int getDebut() {
		return chDebut;
	}
	
	public int getFin() {
		return chFin;
	}
	
	public void setNom(String parNom) {
		chNom = parNom;
	}
	
	public void setDebut(int parDebut) {
		chDebut = parDebut;
	}
	
	public void setFin(int parFin) {
		chFin = parFin;
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
	}
}
