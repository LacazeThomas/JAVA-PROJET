package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Model.Chronologie;
import Model.Data;
import Model.Evenement;

public class PanelDiapo extends JPanel implements Data, ActionListener {

	private JLabel chNomJLabel;

	private JPanel chPanelCentre = new JPanel();

	private JButton chSuivantJButton = new JButton(BOUTONSDIAPO[1]);
	private JButton chPrecedentJButton = new JButton(BOUTONSDIAPO[0]);
	private Chronologie chChronologie;

	private CardLayout chGestionnaireDesCartes = new CardLayout();

	public PanelDiapo(Chronologie parChronologie) {

		chChronologie = parChronologie;

		setLayout(new BorderLayout());
		chNomJLabel = new JLabel("", SwingConstants.CENTER);
		chNomJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(chNomJLabel, BorderLayout.NORTH);

		chPanelCentre.setLayout(chGestionnaireDesCartes);

		ArrayList<Evenement> list = chChronologie.getArrayList();

		for (Evenement s : list) {
			JLabelDescription label = new JLabelDescription(s);
			chPanelCentre.add(label, s.toString());
		}
		add(chPanelCentre, BorderLayout.CENTER);
		//On modifie les boutons en affichant uniquement les fleches et rien d'autre
		chSuivantJButton.setBorderPainted(false);
		chSuivantJButton.setOpaque(false);
		chSuivantJButton.setContentAreaFilled(false);
		chSuivantJButton.setBorderPainted(false);

		chPrecedentJButton.setBorderPainted(false);
		chPrecedentJButton.setOpaque(false);
		chPrecedentJButton.setContentAreaFilled(false);
		chPrecedentJButton.setBorderPainted(false);

		chPrecedentJButton.setFont(new Font("Arial", Font.PLAIN, 40));
		chSuivantJButton.setFont(new Font("Arial", Font.PLAIN, 40));

		add(chSuivantJButton, BorderLayout.EAST);
		add(chPrecedentJButton, BorderLayout.WEST);

		//On affecte des actions aux boutons
		chSuivantJButton.addActionListener(this);
		chSuivantJButton.setActionCommand("Suivant");
		chPrecedentJButton.addActionListener(this);
		chPrecedentJButton.setActionCommand("Precedent");

	}

	public void actionPerformed(ActionEvent parEvt) {
		if (parEvt.getActionCommand() == "Suivant") {
			chGestionnaireDesCartes.next(chPanelCentre);

			//on récupere le diapo courant
			JLabelDescription card = null;
			for (Component comp : chPanelCentre.getComponents()) {
				if (comp.isVisible() == true) {
					card = (JLabelDescription) comp;
				}
			}
			//Puis on deplace la scrollbar juste le bon identificateur
			PanelChrono.goToCell(card.getEvt().getDate().getAnnee() - chChronologie.getDebut());
		}
		if (parEvt.getActionCommand() == "Precedent") {
			chGestionnaireDesCartes.previous(chPanelCentre);
			JLabelDescription card = null;
			for (Component comp : chPanelCentre.getComponents()) {
				if (comp.isVisible() == true) {
					card = (JLabelDescription) comp;
				}
			}
			PanelChrono.goToCell(card.getEvt().getDate().getAnnee() - chChronologie.getDebut());
		}
	}

	public CardLayout getCardLayout() {
		return chGestionnaireDesCartes;
	}

	public JPanel getPanelCentre() {
		return chPanelCentre;
	}

	public JLabel getChNomJLabel() {
		return chNomJLabel;
	}
}