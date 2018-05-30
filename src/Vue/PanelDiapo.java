package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Model.Chronologie;
import Model.Data;
import Model.Date;
import Model.Evenement;

public class PanelDiapo extends JPanel implements Data, ActionListener{
	
	public JLabel chNomJLabel;
	public JLabel chCenterJLabel;
	
	public JPanel panelCentre = new JPanel();
	
	public JButton chSuivantJButton = new JButton(BOUTONSDIAPO[1]);
	public JButton chPrecedentJButton = new JButton(BOUTONSDIAPO[0]);
	public Chronologie chChronologie;
	
	private CardLayout gestionnaireDesCartes = new CardLayout();
	
	public PanelDiapo(Chronologie parChronologie) {
		
		chChronologie = parChronologie;
		
		setLayout(new BorderLayout());
		chNomJLabel = new JLabel("", SwingConstants.CENTER);
		add(chNomJLabel, BorderLayout.NORTH);
        
		panelCentre.setLayout(gestionnaireDesCartes);
		
        ArrayList<Evenement> list = chChronologie.chListe;
        
        for (Evenement s : list) {
	    	JLabelDescription label = new JLabelDescription(s); 	
	        panelCentre.add(label, s.toString());
        }
        
        
        chSuivantJButton.addActionListener(this);
        chPrecedentJButton.addActionListener(this);
        add(panelCentre, BorderLayout.CENTER);
		
		
		add(chSuivantJButton, BorderLayout.EAST);
		add(chPrecedentJButton, BorderLayout.WEST);
	}
	
	public void actionPerformed(ActionEvent parEvt)  {
		if(parEvt.getSource() == chSuivantJButton) {
			gestionnaireDesCartes.next(panelCentre);
		}
		if(parEvt.getSource() == chPrecedentJButton) {
			gestionnaireDesCartes.previous(panelCentre);
		}
	}
}