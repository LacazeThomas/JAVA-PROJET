package Vue;

import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Model.Evenement;
/** Cet héritage de jlabel permet d'ajouter une image a côté d'un texte*/
public class JLabelDescription extends JLabel {

    private Evenement chEvenement;

    public JLabelDescription(Evenement parEvt) {

        chEvenement = parEvt;
        setIcon(new ImageIcon("images/" + parEvt.getPath()));

        String DescriptionStringTokenizer = new String();

        //On mets un espace tous les 12 mots 
        StringTokenizer st = new StringTokenizer(parEvt.getTexte());
        int retourligne = 0;
        while (st.hasMoreTokens()) {
            retourligne++;
            DescriptionStringTokenizer += st.nextToken() + " ";
            if (retourligne == 12) {
                //Si on est au 12eme mots alors on mets un retour à la ligne et ton retourne au premier mot
                DescriptionStringTokenizer += "<br/>";
                retourligne = 0;
            }
        }

        setText("<html><h4>" + parEvt.getDate().toString() + "</h4><h3> " + parEvt.getTitre() + "</h3>"
                + DescriptionStringTokenizer + "</html>");
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);

    }

    public Evenement getEvt() {
        return chEvenement;
    }
}