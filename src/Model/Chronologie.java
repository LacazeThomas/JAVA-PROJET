/* @author Thomas LACAZE & Noe BELLEFON
 * @version 1.0
 * 
 * 
 **/
package Model;

import java.io.Serializable;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
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
		//S'il y a deja un evenement
		//La HashMap utilise comme key l'ann�e de l'evenement
		if (chMap.containsKey(parEvt.getDate().getAnnee()) == true) {
			ArrayList<Evenement> list = chMap.get(parEvt.getDate().getAnnee());
			
			//On parcours l'annee en question est on regarde s'il y a deja un evenement avec ce poids
			for (Evenement s : list) {
				if(s.getPoids() == parEvt.getPoids()){
					throw new ExceptionChronologie("Erreur un evenement existe d�j��cette ann�e et ce poids!");
				}
			}
			list.add(parEvt);
		} else {
			ArrayList<Evenement> list = new ArrayList();
			list.add(parEvt);
			chMap.put(parEvt.getDate().getAnnee(), list);
		}

		chListe.add(parEvt);
	}
	
	public int getNb() {
		return chMap.size();
	}
}
