package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Chronologie implements Serializable {
	private ArrayList<Evenement> chListe = new ArrayList();
	//HashMap qui contient tous les evenements
	private HashMap<Integer, ArrayList<Evenement>> chMap = new HashMap<Integer, ArrayList<Evenement>>();
	private String chNom;
	private int chDebut;
	private int chFin;

	public String toString() {
		return chListe.toString();
	}

	public ArrayList<Evenement> getArrayList() {
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

	public void setDebutFin(int parDebut, int parFin) throws ExceptionChronologie {
		if(parDebut > parFin)
			throw new ExceptionChronologie("Erreur la date de fin est plus petite que la date de debut");
		else{
			chDebut = parDebut;
			chFin = parFin;
		}

	}

	public void ajout(Evenement parEvt) throws ExceptionChronologie{
		//On recupe le numeros de semaine qui est l'indentificateur du chMap
		GregorianCalendar aujoudhui = new GregorianCalendar(parEvt.getDate().getAnnee(), parEvt.getDate().getMois() - 1,
				parEvt.getDate().getJour());
		int numsemaine = aujoudhui.get(Calendar.WEEK_OF_YEAR);

		//S'il y a deja un evenement
		if (chMap.containsKey(numsemaine) == true) {
			ArrayList<Evenement> list = chMap.get(numsemaine);
			for (Evenement s : list) {
				if(s.getPoids() == parEvt.getPoids()){
					throw new ExceptionChronologie("Erreur un evenement existe déjà à cette année et ce poids!");
				}
			}
			list.add(parEvt);
		} else {
			ArrayList<Evenement> list = new ArrayList();
			list.add(parEvt);
			chMap.put(numsemaine, list);
		}

		chListe.add(parEvt);
	}
}
