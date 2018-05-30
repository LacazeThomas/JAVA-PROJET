package Vue;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Model.Evenement;

public class JLabelDescription extends JLabel {

	public Evenement chEvenement;

	public JLabelDescription(Evenement parEvt) {

		chEvenement = parEvt;
		setIcon(new ImageIcon("images/" + parEvt.getPath()));
		setText("<html><h1>" + parEvt.toString() + "</h1></html>");
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);

	}
}
