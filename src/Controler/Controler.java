package Controler;

import java.awt.Image;
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
import Vue.PanelChronoDiapo;
import Vue.PanelCreation;
import Vue.PanelFormulaire;
import Vue.PanelsFils;

public class Controler implements ActionListener, Data {

	private PanelFormulaire chPanelFormulaire;
	private File chFile;
	private Chronologie chChronologie;
	private PanelCreation chPanelCreation;
	private PanelChronoDiapo chPanelChronoDiapo;
	private PanelsFils chPanelsFils;

	public Controler(PanelsFils parPanelsFils, PanelChronoDiapo parPanelChronoDiapo,
			PanelFormulaire parchPanelFormulaire, File parFile, Chronologie parChronologie,
			PanelCreation parPanelCreation) {
		chPanelFormulaire = parchPanelFormulaire;

		chPanelsFils = parPanelsFils;
		chPanelFormulaire.enregistreEcouteur(this);
		chFile = parFile;
		chChronologie = parChronologie;
		chPanelCreation = parPanelCreation;
		chPanelCreation.enregistreEcouteur(this);
		chPanelChronoDiapo = parPanelChronoDiapo;
	}

	public void actionPerformed(ActionEvent parEvt) {

		if (parEvt.getActionCommand() == "IMG") {
			chPanelFormulaire.getChooser().setCurrentDirectory(new java.io.File("images/."));
			chPanelFormulaire.getChooser().setDialogTitle("Choisir une image");
			chPanelFormulaire.getChooser().setFileSelectionMode(JFileChooser.FILES_ONLY);
			chPanelFormulaire.getChooser().setAcceptAllFileFilterUsed(false);

			if (chPanelFormulaire.getChooser().showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				chPanelFormulaire.getChImageConfirmationJLabel()
						.setText(chPanelFormulaire.getChooser().getSelectedFile().getName().toString());
				chPanelFormulaire.getChImageConfirmationVueJLabel().setIcon(new ImageIcon(
						new ImageIcon("images/" + chPanelFormulaire.getChooser().getSelectedFile().getName().toString())
								.getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT)));
			} else {
			}
		}
		if (parEvt.getActionCommand() == "+") {
			Date testdate = new Date();
			testdate.setJour(
					Integer.parseInt(chPanelFormulaire.getChDateJoursJCombobox().getSelectedItem().toString()));
			testdate.setMois(Integer.parseInt(chPanelFormulaire.getChDateMoisJCombobox().getSelectedItem().toString()));
			testdate.setAnnee(
					Integer.parseInt(chPanelFormulaire.getChDateAnneeJCombobox().getSelectedItem().toString()));

			Evenement testEvt = new Evenement(testdate, chPanelFormulaire.getChTitreJTextArea().getText(),
					chPanelFormulaire.getChTexteJTextArea().getText(),
					chPanelFormulaire.getChooser().getSelectedFile().getName().toString(),
					Integer.parseInt(chPanelFormulaire.getChPoidsJComboBox().getSelectedItem().toString()));
			chChronologie.ajout(testEvt);
			LectureEcriture.ecriture(chFile, chChronologie);

			chPanelChronoDiapo.resetDiapo(chChronologie);
			chPanelChronoDiapo.getPanelDiapo().getChNomJLabel().setText(chChronologie.getNom());

			chPanelsFils.getCardLayout().show(chPanelsFils.getFenetreMere().getPanelsFils(), NOMSOUSMENU2[1]);

		}

		if (parEvt.getActionCommand() == "CreationAjout") {
			chChronologie.setNom(chPanelCreation.getChTitreJTextField().getText());
			chChronologie.setDebut(Integer.parseInt(chPanelCreation.getChDateDebutJTextField().getText()));
			chChronologie.setFin(Integer.parseInt(chPanelCreation.getChDateFinJTextField().getText()));

			String[] anneeStrings = new String[chChronologie.getFin() - chChronologie.getDebut() + 1];

			for (int i = 0; i < chChronologie.getFin() - chChronologie.getDebut() + 1; i++) {
				anneeStrings[i] = chChronologie.getDebut() + i + "";
			}
			chPanelFormulaire.setAnneeComboBox(anneeStrings);
			LectureEcriture.ecriture(chFile, chChronologie);
			chPanelChronoDiapo.resetDiapo(chChronologie);
			chPanelChronoDiapo.getPanelDiapo().getChNomJLabel().setText(chChronologie.getNom());
			chPanelsFils.getFenetreMere().chMenuBar.setVisible(true);
			chPanelsFils.getCardLayout().show(chPanelsFils.getFenetreMere().getPanelsFils(), NOMSOUSMENU2[0]);
		}

	}
}