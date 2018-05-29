package Vue;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controler.Controler;
public class PanelCreation extends JPanel{
	
	public JTextArea chTitreJTextField = new JTextArea("", 1, 10);
	public JTextArea chDateDebutJTextField = new JTextArea("", 1, 10);
	public JTextArea chDateFinJTextField = new JTextArea("", 1, 10);
	public JButton chAjoutJButton = new JButton("+");
	
	public PanelCreation() {
		setLayout(new GridBagLayout());
		GridBagConstraints contrainte = new GridBagConstraints();
        contrainte.gridheight = 1;
        contrainte.gridwidth = 1;
        contrainte.gridx = 1;
        contrainte.gridy = 1;
        contrainte.insets = new Insets(10, 0, 0, 0);
        contrainte.anchor = GridBagConstraints.WEST;
		add(new JLabel("Titre de votre chronologie:"), contrainte);
		
        contrainte.gridx = 2;
        contrainte.gridy = 1;
		add(chTitreJTextField, contrainte);
		
        contrainte.gridx = 1;
        contrainte.gridy = 2;
		add(new JLabel("Année de debut:"), contrainte);
		
        contrainte.gridx = 2;
        contrainte.gridy = 2;
		add(chDateDebutJTextField, contrainte);
		
        contrainte.gridx = 1;
        contrainte.gridy = 3;
		add(new JLabel("Année de fin:"), contrainte);
		
        contrainte.gridx = 2;
        contrainte.gridy = 3;
		add(chDateFinJTextField, contrainte);
		
		
		contrainte.gridy = 4;
        contrainte.gridheight = 1;
        contrainte.gridwidth = 2;
        add(chAjoutJButton, contrainte);
       
	}
	
	public void enregistreEcouteur(Controler parControler) {
        chAjoutJButton.addActionListener(parControler);
        chAjoutJButton.setActionCommand("CreationAjout");
        
	}
	
}
