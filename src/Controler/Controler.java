package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

import Model.Chronologie;
import Model.Data;
import Model.Date;
import Model.Evenement;
import Model.LectureEcriture;
import Vue.PanelChrono;
import Vue.PanelCreation;
import Vue.PanelDiapo;
import Vue.PanelFormulaire;

public class Controler implements ActionListener, Data {

    PanelFormulaire panelFormulaire;
    File chFile;
    Chronologie chChronologie;
    PanelCreation chPanelCreation;
    PanelDiapo chPanelDiapo;
    PanelChrono chPanelChrono;
    
    public Controler(PanelFormulaire parPanelFormulaire, File parFile, Chronologie parChronologie, PanelCreation parPanelCreation,PanelDiapo parPanelDiapo, PanelChrono parPanelChrono) {
        panelFormulaire = parPanelFormulaire;
        panelFormulaire.enregistreEcouteur(this);
        chFile = parFile;
        chChronologie = parChronologie;
        chPanelCreation = parPanelCreation;
        chPanelCreation.enregistreEcouteur(this);
        chPanelDiapo = parPanelDiapo;
        chPanelChrono = parPanelChrono;
    }

    public void actionPerformed(ActionEvent parEvt) {

        if (parEvt.getActionCommand() == "IMG") {
        	panelFormulaire.chooser.setCurrentDirectory(new java.io.File("."));
        	panelFormulaire.chooser.setDialogTitle("Choisir une image");
        	panelFormulaire.chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        	panelFormulaire.chooser.setAcceptAllFileFilterUsed(false);

		    if (panelFormulaire.chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //Parce que le java c'est bien !!! Sans ça cela ne marche pas.
		    } else {
		    }
        }
		if(parEvt.getActionCommand() == "+") {
			Date testdate = new Date();
			testdate.jour = Integer.parseInt(panelFormulaire.chDateJoursJCombobox.getSelectedItem().toString());
			testdate.mois = Integer.parseInt(panelFormulaire.chDateMoisJCombobox.getSelectedItem().toString());
			testdate.annee = Integer.parseInt(panelFormulaire.chDateAnneeJCombobox.getSelectedItem().toString());
			
			
			Evenement testEvt = new Evenement(testdate, panelFormulaire.chTitreJTextArea.getText(), panelFormulaire.chTexteJTextArea.getText(), panelFormulaire.chooser.getSelectedFile().getName().toString(), Integer.parseInt(panelFormulaire.chPoidsJComboBox.getSelectedItem().toString()));
			chChronologie.ajout(testEvt);
			LectureEcriture.ecriture(chFile, chChronologie);
			System.out.print(panelFormulaire.chooser.getSelectedFile().getName().toString());
			chPanelChrono.setModel(chChronologie);
		}
		
		if(parEvt.getActionCommand() == "CreationAjout") {
			chChronologie.chNom = chPanelCreation.chTitreJTextField.getText();
			chChronologie.chDebut = Integer.parseInt(chPanelCreation.chDateDebutJTextField.getText());
			chChronologie.chFin = Integer.parseInt(chPanelCreation.chDateFinJTextField.getText());
			chPanelDiapo.chNomJLabel.setText(chPanelCreation.chTitreJTextField.getText());

			String []anneeStrings = new String[chChronologie.chFin-chChronologie.chDebut+1];

			for(int i = 0; i<chChronologie.chFin-chChronologie.chDebut+1;i++){
				anneeStrings[i] = chChronologie.chDebut+i+"";
			}
			panelFormulaire.setAnneeComboBox(anneeStrings);
			chPanelChrono.setModel(chChronologie);
			LectureEcriture.ecriture(chFile, chChronologie);
		}
    }
}