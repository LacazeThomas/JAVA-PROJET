package Controler;

import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
import Vue.PanelsFils;

public class Controler implements ActionListener, Data {

	private PanelFormulaire panelFormulaire;
	private File chFile;
	private Chronologie chChronologie;
	private PanelCreation chPanelCreation;
	private PanelChronoDiapo chPanelChronoDiapo;
	private PanelsFils chPanelsFils;

	public Controler(PanelsFils parPanelsFils, PanelChronoDiapo parPanelChronoDiapo, PanelFormulaire parPanelFormulaire, File parFile,
			Chronologie parChronologie, PanelCreation parPanelCreation) {
		panelFormulaire = parPanelFormulaire;
		
		chPanelsFils = parPanelsFils;
		panelFormulaire.enregistreEcouteur(this);
		chFile = parFile;
		chChronologie = parChronologie;
		chPanelCreation = parPanelCreation;
		chPanelCreation.enregistreEcouteur(this);
		chPanelChronoDiapo = parPanelChronoDiapo;
	}

	public void actionPerformed(ActionEvent parEvt) {

		if (parEvt.getActionCommand() == "IMG") {
			panelFormulaire.getChooser().setCurrentDirectory(new java.io.File("images/."));
			panelFormulaire.getChooser().setDialogTitle("Choisir une image");
			panelFormulaire.getChooser().setFileSelectionMode(JFileChooser.FILES_ONLY);
			panelFormulaire.getChooser().setAcceptAllFileFilterUsed(false);

			if (panelFormulaire.getChooser().showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { // Parce que le java
																									// c'est bien !!!
																									// Sans ça cela ne
																									// marche pas.
				panelFormulaire.getChImageConfirmationJLabel()
						.setText(panelFormulaire.getChooser().getSelectedFile().getName().toString());
				panelFormulaire.getChImageConfirmationVueJLabel().setIcon(new ImageIcon(
						new ImageIcon("images/" + panelFormulaire.getChooser().getSelectedFile().getName().toString())
								.getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT)));
			} else {
			}
		}
		if (parEvt.getActionCommand() == "+") {
			Date testdate = new Date();
			testdate.setJour(Integer.parseInt(panelFormulaire.getChDateJoursJCombobox().getSelectedItem().toString()));
			testdate.setMois(Integer.parseInt(panelFormulaire.getChDateMoisJCombobox().getSelectedItem().toString()));
			testdate.setAnnee(Integer.parseInt(panelFormulaire.getChDateAnneeJCombobox().getSelectedItem().toString()));

			Evenement testEvt = new Evenement(testdate, panelFormulaire.getChTitreJTextArea().getText(),
					panelFormulaire.getChTexteJTextArea().getText(),
					panelFormulaire.getChooser().getSelectedFile().getName().toString(),
					Integer.parseInt(panelFormulaire.getChPoidsJComboBox().getSelectedItem().toString()));
			chChronologie.ajout(testEvt);
			LectureEcriture.ecriture(chFile, chChronologie);

			chPanelChronoDiapo.resetDiapo(chChronologie);
			chPanelChronoDiapo.getPanelDiapo().getChNomJLabel().setText(chChronologie.getNom());
			
			chPanelsFils.getCardLayout().show(chPanelsFils.getFenetreMere().getPanelsFils(),  NOMSOUSMENU2[1]);
			
		}

		if (parEvt.getActionCommand() == "CreationAjout") {
			chChronologie.setNom(chPanelCreation.getChTitreJTextField().getText());
			chChronologie.setDebut(Integer.parseInt(chPanelCreation.getChDateDebutJTextField().getText()));
			chChronologie.setFin(Integer.parseInt(chPanelCreation.getChDateFinJTextField().getText()));

			String[] anneeStrings = new String[chChronologie.getFin() - chChronologie.getDebut() + 1];

			for (int i = 0; i < chChronologie.getFin() - chChronologie.getDebut() + 1; i++) {
				anneeStrings[i] = chChronologie.getDebut() + i + "";
			}
			panelFormulaire.setAnneeComboBox(anneeStrings);
			LectureEcriture.ecriture(chFile, chChronologie);
			chPanelChronoDiapo.resetDiapo(chChronologie);
			chPanelChronoDiapo.getPanelDiapo().getChNomJLabel().setText(chChronologie.getNom());
			chPanelsFils.getFenetreMere().chMenuBar.setVisible(true);
			chPanelsFils.getCardLayout().show(chPanelsFils.getFenetreMere().getPanelsFils(),  NOMSOUSMENU2[0]);
		}

	}
}