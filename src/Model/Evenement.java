package Model;

import java.io.Serializable;

public class Evenement implements Comparable<Evenement>, Serializable {
    private Date chDate;
    private String chNom;
    private String chTexte;
    private String chPath;
    private int chPoids;
    private static int chNbEvt = 0;

    public String toString() {
        return chNom;
    }

    public Evenement(Date parDate, String parNom, String parTexte, String parPath, int parPoids) {
        chDate = parDate;
        chNom = parNom;
        chTexte = parTexte;
        chPath = parPath;
        chPoids = parPoids;
        chNbEvt = chNbEvt + 1;
    }

    public String getNom() {
        return chNom;
    }

    public String getPath() {
        return chPath;
    }

    public void setNom(String parNom) {
        chNom = parNom;
    }

    public static int getNbEvt() {
        return chNbEvt;
    }

    /*
     * public static Evenement lireEvenement(){ Date a = Date.saisirUneDate();
     * System.out.println("Nom de l'evenement: "); String b = Clavier.lireString();
     * System.out.println("Lieu de l'evenement: "); String c = Clavier.lireString();
     * return new Evenement(a,b,c); }
     */
    public int compareTo(Evenement parEvt) {
        if (chDate.compareTo(parEvt.chDate) != 0)
            return (chDate.compareTo(parEvt.chDate));
        else
            return (chNom.compareTo(parEvt.chNom));

    }

    public Date getDate() {
        return chDate;
    }

    public String getTitre() {
        return chNom;
    }

    public int getPoids() {
        return chPoids;
    }
}