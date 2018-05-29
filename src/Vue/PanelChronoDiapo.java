package Vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import Model.Chronologie;

public class PanelChronoDiapo extends JPanel{
	
	
	public PanelDiapo chpanelDiapo = new PanelDiapo();
	PanelChrono chpanelChrono = new PanelChrono(new Chronologie());
	
	
	public PanelChronoDiapo(Chronologie parchronologie) {
		setLayout(new BorderLayout());
		
		chpanelChrono = new PanelChrono(parchronologie);
		add(chpanelChrono, BorderLayout.SOUTH);
		add(chpanelDiapo, BorderLayout.NORTH);
	}
}
