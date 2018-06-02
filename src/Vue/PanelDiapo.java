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

	private JPanel panelCentre = new JPanel();

	private JButton chSuivantJButton = new JButton(BOUTONSDIAPO[1]);
	private JButton chPrecedentJButton = new JButton(BOUTONSDIAPO[0]);
	private Chronologie chChronologie;

	private CardLayout gestionnaireDesCartes = new CardLayout();

	public PanelDiapo(Chronologie parChronologie) {

		chChronologie = parChronologie;

		setLayout(new BorderLayout());
		chNomJLabel = new JLabel("", SwingConstants.CENTER);
		add(chNomJLabel, BorderLayout.NORTH);

		panelCentre.setLayout(gestionnaireDesCartes);

		ArrayList<Evenement> list = chChronologie.getArrayList();

		for (Evenement s : list) {
			JLabelDescription label = new JLabelDescription(s);
			panelCentre.add(label, s.toString());
		}
		add(panelCentre, BorderLayout.CENTER);
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

		chSuivantJButton.addActionListener(this);
		chSuivantJButton.setActionCommand("Suivant");
		chPrecedentJButton.addActionListener(this);
		chPrecedentJButton.setActionCommand("Precedent");

	}

	public void actionPerformed(ActionEvent parEvt) {
		if (parEvt.getActionCommand() == "Suivant") {
			gestionnaireDesCartes.next(panelCentre);
			JLabelDescription card = null;
			for (Component comp : panelCentre.getComponents()) {
				if (comp.isVisible() == true) {
					card = (JLabelDescription) comp;
				}
			}
			PanelChrono.goToCell(card.getEvt().getDate().getAnnee() - chChronologie.getDebut());
		}
		if (parEvt.getActionCommand() == "Precedent") {
			gestionnaireDesCartes.previous(panelCentre);
			JLabelDescription card = null;
			for (Component comp : panelCentre.getComponents()) {
				if (comp.isVisible() == true) {
					card = (JLabelDescription) comp;
				}
			}
			PanelChrono.goToCell(card.getEvt().getDate().getAnnee() - chChronologie.getDebut());
		}
	}

	public CardLayout getCardLayout() {
		return gestionnaireDesCartes;
	}

	public JPanel getPanelCentre() {
		return panelCentre;
	}

	public JLabel getChNomJLabel() {
		return chNomJLabel;
	}
}