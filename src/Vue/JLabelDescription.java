package Vue;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Model.Evenement;

public class JLabelDescription extends JLabel {
	public JLabelDescription(Evenement parEvt) {

		setIcon(new ImageIcon("images/" + parEvt.getPath()));
		setText("<html><h1>" + parEvt.toString() + "</h1></html>");
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);

	}
}
