package Vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import Model.Chronologie;

public class PanelChronoDiapo extends JPanel{
	
	
	public PanelDiapo chpanelDiapo;
	public PanelChrono chpanelChrono;
	
	
	public PanelChronoDiapo(Chronologie parchronologie) {
		setLayout(new BorderLayout());
		
		chpanelDiapo = new PanelDiapo(parchronologie);
		chpanelChrono = new PanelChrono(parchronologie);
		add(chpanelChrono, BorderLayout.SOUTH);
		add(chpanelDiapo, BorderLayout.NORTH);
	}
	
	public void resetDiapo(Chronologie parchronologie) {
		
		remove(chpanelDiapo);
		chpanelDiapo = new PanelDiapo(parchronologie);
		add(chpanelDiapo);
	}
}
