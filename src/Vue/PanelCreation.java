package Vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controler.Controler;

public class PanelCreation extends JPanel {

    private JTextArea chTitreJTextField = new JTextArea("", 1, 10);
    private JTextArea chDateDebutJTextField = new JTextArea("", 1, 10);
    private JTextArea chDateFinJTextField = new JTextArea("", 1, 10);
    private JButton chAjoutJButton = new JButton("+");

    public PanelCreation() {
        setLayout(new GridBagLayout());
        GridBagConstraints contrainte = new GridBagConstraints();
        contrainte.gridheight = 1;
        contrainte.gridwidth = 1;
        contrainte.gridx = 1;
        contrainte.gridy = 1;
        contrainte.insets = new Insets(10, 0, 0, 0);
        JLabel TitreFriseJLabel = new JLabel("Titre de votre chronologie:");
        TitreFriseJLabel.setDisplayedMnemonic(KeyEvent.VK_T);
        add(TitreFriseJLabel, contrainte);

        contrainte.gridx = 2;
        contrainte.gridy = 1;
        TitreFriseJLabel.setLabelFor(chTitreJTextField);
        add(chTitreJTextField, contrainte);
        contrainte.gridx = 1;
        contrainte.gridy = 2;
        JLabel AnneeDebutJLabel = new JLabel("Année de debut:");
        AnneeDebutJLabel.setDisplayedMnemonic(KeyEvent.VK_D);
        add(AnneeDebutJLabel, contrainte);

        contrainte.gridx = 2;
        contrainte.gridy = 2;
        AnneeDebutJLabel.setLabelFor(chDateDebutJTextField);
        add(chDateDebutJTextField, contrainte);

        contrainte.gridx = 1;
        contrainte.gridy = 3;
        JLabel AnneeFinJLabel = new JLabel("Année de fin:");
        AnneeFinJLabel.setDisplayedMnemonic(KeyEvent.VK_F);
        add(AnneeFinJLabel, contrainte);

        contrainte.gridx = 2;
        contrainte.gridy = 3;
        AnneeFinJLabel.setLabelFor(chDateFinJTextField);
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

    public JTextArea getChTitreJTextField() {
        return chTitreJTextField;
    }

    public JTextArea getChDateDebutJTextField() {
        return chDateDebutJTextField;
    }

    public JTextArea getChDateFinJTextField() {
        return chDateFinJTextField;
    }

}