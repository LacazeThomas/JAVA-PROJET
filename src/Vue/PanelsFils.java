package Vue;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import Controler.Controler;
import Model.Chronologie;
import Model.Data;
import Model.LectureEcriture;

public class PanelsFils extends JPanel implements ActionListener, Data {

    private static CardLayout gestionnaireDesCartes = new CardLayout();

    FenetreMere chFenetreMere;
    File chSer;
    JFileChooser chooser = new JFileChooser();
    PanelCreation panelCreation;
    PanelFormulaire panelFormulaire;
    PanelChronoDiapo panelChronoDiapo;
    
    public PanelsFils(FenetreMere parFenetreMere, File parSer) {
    	
    	chFenetreMere = parFenetreMere;
    	chSer = parSer;
    	
        setLayout(gestionnaireDesCartes);

        panelCreation = new PanelCreation();

        Chronologie chronologie;
        if (chSer.length() == 0) {
            add(panelCreation, "Creation");
            gestionnaireDesCartes.show(this, "Creation");
            chronologie = new Chronologie();

        } else
            chronologie = (Chronologie) LectureEcriture.lecture(chSer);
        	
        panelChronoDiapo = new PanelChronoDiapo(chronologie);
        panelFormulaire = new PanelFormulaire(chronologie);

        add(panelFormulaire, NOMSOUSMENU2[0]);
        add(panelChronoDiapo, NOMSOUSMENU2[1]);

        panelChronoDiapo.getPanelDiapo().getChNomJLabel().setText(chronologie.getNom());

        new Controler(this,panelChronoDiapo, panelFormulaire, chSer, chronologie, panelCreation);

    }

    public void actionPerformed(ActionEvent parEvt) {

        if (parEvt.getActionCommand() == NOMSOUSMENU2[2]) {
            System.exit(0);
        }

        if (parEvt.getActionCommand() == NOMSOUSMENU2[0]) {
            gestionnaireDesCartes.show(this, NOMSOUSMENU2[0]);
        }

        if (parEvt.getActionCommand() == NOMSOUSMENU2[1]) {
            gestionnaireDesCartes.show(this, NOMSOUSMENU2[1]);
        }
        
        if (parEvt.getActionCommand() == NOMSOUSMENU1[0]) {
			chooser.setCurrentDirectory(new java.io.File("save/."));
			chooser.setDialogTitle("Choisir une chronologie");
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setAcceptAllFileFilterUsed(false);

			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { // Parce que le java
				System.out.println(chooser.getSelectedFile().getName().toString());
				chSer = new File("save" + File.separator + chooser.getSelectedFile().getName().toString());
				reset(chFenetreMere, chSer);
			} else {
				
			}
        }
    }
    
    
    public CardLayout getCardLayout() {
    	return gestionnaireDesCartes;
    	
    }
 
    
    public FenetreMere getFenetreMere() {
    	return chFenetreMere;
    }

    public void reset(FenetreMere parFenetreMere, File parSer) {
    	
    	chFenetreMere = parFenetreMere;
    	chSer = parSer;
    	
        setLayout(gestionnaireDesCartes);

        panelCreation = new PanelCreation();

        Chronologie chronologie;
        if (parSer.length() == 0) {
            add(panelCreation, "Creation");
            gestionnaireDesCartes.show(this, "Creation");
            chronologie = new Chronologie();

        } else {
        	chronologie = (Chronologie) LectureEcriture.lecture(chSer);
        	gestionnaireDesCartes.show(this, NOMSOUSMENU2[0]);
        }
        
        	
        panelChronoDiapo = new PanelChronoDiapo(chronologie);
        panelFormulaire = new PanelFormulaire(chronologie);

        add(panelFormulaire, NOMSOUSMENU2[0]);
        add(panelChronoDiapo, NOMSOUSMENU2[1]);

        panelChronoDiapo.getPanelDiapo().getChNomJLabel().setText(chronologie.getNom());
        new Controler(this,panelChronoDiapo, panelFormulaire, chSer, chronologie, panelCreation);

    }
}
