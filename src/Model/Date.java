package Model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date>, Serializable {
	private int jour;
	private int mois;
	private int annee;
	private int jourSemaine;

	public Date() {
		GregorianCalendar dateAuj = new GregorianCalendar();
		annee = dateAuj.get(Calendar.YEAR);
		mois = dateAuj.get(Calendar.MONTH) + 1; // janvier = 0, fevrier = 1...
		jour = dateAuj.get(Calendar.DAY_OF_MONTH);
		jourSemaine = dateAuj.get(Calendar.DAY_OF_WEEK);
	}

	public Date(int parJour, int parMois, int parAnnee) {
		jour = parJour;
		mois = parMois;
		annee = parAnnee;
		GregorianCalendar date = new GregorianCalendar(annee, mois - 1, jour);
		jourSemaine = date.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * retourne 0 si this et parDate sont �gales, 
	 * -1 si this pr�c�de parDate,
	 *  1 si parDate pr�c�de this
	 */
	public int compareTo(Date parDate) {
		if (annee < parDate.annee)
			return -1;
		if (annee > parDate.annee)
			return 1;
		// les ann�es sont =
		if (mois < parDate.mois)
			return -1;
		if (mois > parDate.mois)
			return 1;
		// les mois sont =
		if (jour < parDate.jour)
			return -1;
		if (jour > parDate.jour)
			return 1;
		return 0;
	}
	public String toString() {
		String chaine = new String();
		switch (jourSemaine) {
		case 1:
			chaine = "dimanche";
			break;
		case 2:
			chaine = "lundi";
			break;
		case 3:
			chaine = "mardi";
			break;
		case 4:
			chaine = "mercredi";
			break;
		case 5:
			chaine = "jeudi";
			break;
		case 6:
			chaine = "vendredi";
			break;
		case 7:
			chaine = "samedi";
			break;
		}
		chaine += " " + jour + " ";
		switch (mois) {
		case 1:
			chaine += "janvier";
			break;
		case 2:
			chaine += "f�vrier";
			break;
		case 3:
			chaine += "mars";
			break;
		case 4:
			chaine += "avril";
			break;
		case 5:
			chaine += "mai";
			break;
		case 6:
			chaine += "juin";
			break;
		case 7:
			chaine += "juillet";
			break;
		case 8:
			chaine += "ao�t";
			break;
		case 9:
			chaine += "septembre";
			break;
		case 10:
			chaine += "octobre";
			break;
		case 11:
			chaine += "novembre";
			break;
		case 12:
			chaine += "d�cembre";
			break;
		}
		return chaine;
	}

	public int getAnnee() {
		return annee;
	}

	public int getJour() {
		return jour;
	}

	public int getMois() {
		return mois;
	}

	public int getJourSemaine() {
		return jourSemaine;
	}
	
	public void setJour(int parJour) {
		jour = parJour;
	}
	
	public void setMois(int parMois) {
		mois = parMois;
	}
	
	public void setAnnee(int parAnnee) {
		annee = parAnnee;
	}
	
} // class Date