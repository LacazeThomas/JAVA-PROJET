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
			/**
			 * Permet de récuperer l'image choisit par l'utilisateur et de mettre l'image et
			 * le titre dans un JLabel pour bien qu'il voit se qu'il a fait
			 **/

			// On deplacer l'utilisateur dans le dossier images pour lui facilier la saisie
			chPanelFormulaire.getChooser().setCurrentDirectory(new java.io.File("images/."));
			// On nomme la fenetre
			chPanelFormulaire.getChooser().setDialogTitle("Choisir une image");
			// Il est obligé de choisir un fichier et pas un dossier
			chPanelFormulaire.getChooser().setFileSelectionMode(JFileChooser.FILES_ONLY);
			chPanelFormulaire.getChooser().setAcceptAllFileFilterUsed(false);

			// Si il y a bien complété tous les champs alors on peut accepter l'image
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
			/**
			 * On ajout d'un evenement dans la chronologie en remplisant tous les champs
			 * qu'il a besoin
			 */
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

			/** On ajout d'evement instancier avant */
			chChronologie.ajout(testEvt);
			/** On save garde la frise */
			LectureEcriture.ecriture(chFile, chChronologie);

			/** On reset le diapo et la chronologie car il y a eu des changements. */
			chPanelChronoDiapo.resetDiapo(chChronologie);
			/** Puis on remet le nom de la frise */
			chPanelChronoDiapo.getPanelDiapo().getChNomJLabel().setText(chChronologie.getNom());
			/**
			 * Puis on le déplace automatiquement sur le menu affichage pour qu'il puisse
			 * observer ses modifications
			 */
			chPanelsFils.getCardLayout().show(chPanelsFils.getFenetreMere().getPanelsFils(), NOMSOUSMENU2[1]);

		}

		if (parEvt.getActionCommand() == "CreationAjout") {
			/**
			 * On crée une frise chronologique en fonction du nom de la date de debut et de
			 * fin
			 */
			chChronologie.setNom(chPanelCreation.getChTitreJTextField().getText());
			chChronologie.setDebut(Integer.parseInt(chPanelCreation.getChDateDebutJTextField().getText()));
			chChronologie.setFin(Integer.parseInt(chPanelCreation.getChDateFinJTextField().getText()));

			/**
			 * On crée un le JComboBox pour que l'utilisateur puisse choisir l'année en
			 * fonction de la date du début et de fin
			 */
			String[] anneeStrings = new String[chChronologie.getFin() - chChronologie.getDebut() + 1];

			for (int i = 0; i < chChronologie.getFin() - chChronologie.getDebut() + 1; i++) {
				anneeStrings[i] = chChronologie.getDebut() + i + "";
			}
			chPanelFormulaire.setAnneeComboBox(anneeStrings);
			/** On save garde la frise */
			LectureEcriture.ecriture(chFile, chChronologie);

			/** On reset le diapo et la chronologie car il y a eu des changements. */
			chPanelChronoDiapo.resetDiapo(chChronologie);

			/** Puis on remet le nom de la frise */
			chPanelChronoDiapo.getPanelDiapo().getChNomJLabel().setText(chChronologie.getNom());
			/** On affiche les menus pour que l'utilisateur puisse se déplacer */
			chPanelsFils.getFenetreMere().chMenuBar.setVisible(true);
			/**
			 * Puis on le déplace automatiquement sur le menu d'ajout d'un evenement pour
			 * faciliter
			 */
			chPanelsFils.getCardLayout().show(chPanelsFils.getFenetreMere().getPanelsFils(), NOMSOUSMENU2[0]);
		}

	}
}