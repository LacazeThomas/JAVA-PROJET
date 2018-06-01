package Vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import Model.Chronologie;

public class PanelChronoDiapo extends JPanel {

	private PanelDiapo chpanelDiapo;
	private PanelChrono chpanelChrono;
	private BorderLayout chBorderLayout = new BorderLayout();

	public PanelChronoDiapo(Chronologie parchronologie) {
		setLayout(chBorderLayout);
		chpanelDiapo = new PanelDiapo(parchronologie);
		chpanelChrono = new PanelChrono(parchronologie, chpanelDiapo);
		add(chpanelChrono, BorderLayout.SOUTH);
		add(chpanelDiapo, BorderLayout.NORTH);
	}

	public void resetDiapo(Chronologie parchronologie) {
		remove(chpanelDiapo);
		remove(chpanelChrono);
		setLayout(chBorderLayout);
		chpanelDiapo = new PanelDiapo(parchronologie);
		chpanelChrono = new PanelChrono(parchronologie, chpanelDiapo);
		add(chpanelChrono, BorderLayout.SOUTH);
		add(chpanelDiapo, BorderLayout.NORTH);
	}

	public PanelDiapo getPanelDiapo() {
		return chpanelDiapo;
	}

	public PanelChrono getPanelChrono() {
		return chpanelChrono;
	}
}
