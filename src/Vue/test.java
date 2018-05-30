package Vue;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class test extends JFrame {

  public static void main(String[] args) {
	  JLabel label = new JLabel();
	  label.setIcon(UIManager.getIcon("OptionPane.errorIcon"));
	  label.setText("My Text");
	  label.setHorizontalTextPosition(JLabel.CENTER);
	  label.setVerticalTextPosition(JLabel.CENTER);
  }
}