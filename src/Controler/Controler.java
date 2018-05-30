package Controler;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import Model.Chronologie;
import Model.Data;
import Model.Date;
import Model.Evenement;
import Model.LectureEcriture;
import Vue.PanelChrono;
import Vue.PanelChronoDiapo;
import Vue.PanelCreation;
import Vue.PanelDiapo;
import Vue.PanelFormulaire;

public class Controler implements ActionListener, Data {

    private PanelFormulaire panelFormulaire;
    private File chFile;
    private Chronologie chChronologie;
    private PanelCreation chPanelCreation;
    private PanelDiapo chPanelDiapo;
    private PanelChrono chPanelChrono;
    private PanelChronoDiapo chPanelChronoDiapo;
    
    public Controler(PanelChronoDiapo parPanelChronoDiapo,PanelFormulaire parPanelFormulaire, File parFile, Chronologie parChronologie, PanelCreation parPanelCreation,PanelDiapo parPanelDiapo, PanelChrono parPanelChrono) {
        panelFormulaire = parPanelFormulaire;
        panelFormulaire.enregistreEcouteur(this);
        chFile = parFile;
        chChronologie = parChronologie;
        chPanelCreation = parPanelCreation;
        chPanelCreation.enregistreEcouteur(this);
        chPanelDiapo = parPanelDiapo;
        chPanelChrono = parPanelChrono;
        chPanelChronoDiapo = parPanelChronoDiapo;
    }

    public void actionPerformed(ActionEvent parEvt) {

        if (parEvt.getActionCommand() == "IMG") {
        	panelFormulaire.chooser.setCurrentDirectory(new java.io.File("images/."));
        	panelFormulaire.chooser.setDialogTitle("Choisir une image");
        	panelFormulaire.chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        	panelFormulaire.chooser.setAcceptAllFileFilterUsed(false);

		    if (panelFormulaire.chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //Parce que le java c'est bien !!! Sans ça cela ne marche pas.
				panelFormulaire.chImageConfirmationJLabel.setText(panelFormulaire.chooser.getSelectedFile().getName().toString());
				panelFormulaire.chImageConfirmationVueJLabel.setIcon(new ImageIcon(new ImageIcon("images/"+panelFormulaire.chooser.getSelectedFile().getName().toString()).getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT)));
		    } else {
		    }
        }
		if(parEvt.getActionCommand() == "+") {
			Date testdate = new Date();
			testdate.setJour(Integer.parseInt(panelFormulaire.chDateJoursJCombobox.getSelectedItem().toString()));
			testdate.setMois(Integer.parseInt(panelFormulaire.chDateMoisJCombobox.getSelectedItem().toString()));
			testdate.setAnnee(Integer.parseInt(panelFormulaire.chDateAnneeJCombobox.getSelectedItem().toString()));
			
			
			Evenement testEvt = new Evenement(testdate, panelFormulaire.chTitreJTextArea.getText(), panelFormulaire.chTexteJTextArea.getText(), panelFormulaire.chooser.getSelectedFile().getName().toString(), Integer.parseInt(panelFormulaire.chPoidsJComboBox.getSelectedItem().toString()));
			chChronologie.ajout(testEvt);
			LectureEcriture.ecriture(chFile, chChronologie);

			chPanelChronoDiapo.resetDiapo(chChronologie);
	        
			
		}
		
		if(parEvt.getActionCommand() == "CreationAjout") {
			chChronologie.setNom(chPanelCreation.chTitreJTextField.getText());
			chChronologie.setDebut(Integer.parseInt(chPanelCreation.chDateDebutJTextField.getText()));
			chChronologie.setFin(Integer.parseInt(chPanelCreation.chDateFinJTextField.getText()));
			chPanelDiapo.chNomJLabel.setText(chPanelCreation.chTitreJTextField.getText());

			String []anneeStrings = new String[chChronologie.getFin()-chChronologie.getDebut()+1];

			for(int i = 0; i<chChronologie.getFin()-chChronologie.getDebut()+1;i++){
				anneeStrings[i] = chChronologie.getDebut()+i+"";
			}
			panelFormulaire.setAnneeComboBox(anneeStrings);
			LectureEcriture.ecriture(chFile, chChronologie);
			chPanelChronoDiapo.resetDiapo(chChronologie);
		}
    }
}