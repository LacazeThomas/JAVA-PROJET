package Vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controler.Controler;
import Model.Chronologie;
import Model.Data;

public class PanelFormulaire extends JPanel implements Data {

    private JButton chAjoutJButton = new JButton("+");
    private Chronologie chChronologie = new Chronologie();
    private JTextArea chTitreJTextArea = new JTextArea("", 1, 10);
    private JTextArea chTexteJTextArea = new JTextArea("", 1, 10);
    private JComboBox chDateAnneeJCombobox;
    private JComboBox chDateMoisJCombobox;
    private JComboBox chDateJoursJCombobox;
    private JComboBox chPoidsJComboBox = new JComboBox(POIDS);
    private JButton chImageJButton = new JButton("Parcourir...");
    private JFileChooser chooser = new JFileChooser();
    private JLabel chImageConfirmationJLabel = new JLabel("");
    private JLabel chImageConfirmationVueJLabel = new JLabel("");

    public PanelFormulaire(Chronologie parChronologie) {
        chChronologie = parChronologie;

        setLayout(new GridBagLayout());
        GridBagConstraints contrainte = new GridBagConstraints();
        contrainte.gridheight = 1;
        contrainte.gridwidth = 1;
        contrainte.gridx = 1;
        contrainte.gridy = 1;
        contrainte.insets = new Insets(10, 0, 0, 0);
        contrainte.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("Formulaire d'ajout:"), contrainte);

        contrainte.gridx = 2;
        contrainte.gridy = 1;
        this.add(chAjoutJButton, contrainte);

        contrainte.gridx = 1;
        contrainte.gridy = 2;
        this.add(new JLabel("Titre:"), contrainte);

        contrainte.gridx = 2;
        contrainte.gridy = 2;
        this.add(chTitreJTextArea, contrainte);

        contrainte.gridx = 1;
        contrainte.gridy = 3;
        this.add(new JLabel("Texte:"), contrainte);

        contrainte.gridx = 2;
        contrainte.gridy = 3;
        this.add(chTexteJTextArea, contrainte);

        contrainte.gridx = 1;
        contrainte.gridy = 4;
        this.add(new JLabel("Date:"), contrainte);

        contrainte.gridx = 2;
        contrainte.gridy = 4;

        if (chChronologie.getFin() != 0) {
            String[] anneeStrings = new String[chChronologie.getFin() - chChronologie.getDebut() + 1];

            for (int i = 0; i < chChronologie.getFin() - chChronologie.getDebut() + 1; i++) {
                anneeStrings[i] = chChronologie.getDebut() + i + "";
                chDateAnneeJCombobox = new JComboBox(anneeStrings);
            }
        } else {
            chDateAnneeJCombobox = new JComboBox();
        }

        this.add(chDateAnneeJCombobox, contrainte);

        String[] moisStrings = new String[12];
        for (int i = 0; i < 12; i++) {
            moisStrings[i] = i + 1 + "";
        }
        chDateMoisJCombobox = new JComboBox(moisStrings);
        contrainte.gridx = 3;
        contrainte.gridy = 4;
        this.add(chDateMoisJCombobox, contrainte);

        String[] joursStrings = new String[31];
        for (int i = 0; i < 31; i++) {
            joursStrings[i] = i + 1 + "";
        }
        chDateJoursJCombobox = new JComboBox(joursStrings);
        contrainte.gridx = 4;
        contrainte.gridy = 4;
        this.add(chDateJoursJCombobox, contrainte);

        contrainte.gridx = 1;
        contrainte.gridy = 5;
        this.add(new JLabel("Poids:"), contrainte);

        contrainte.gridx = 2;
        contrainte.gridy = 5;
        this.add(chPoidsJComboBox, contrainte);

        contrainte.gridx = 1;
        contrainte.gridy = 6;
        this.add(new JLabel("Image"), contrainte);

        contrainte.gridx = 2;
        contrainte.gridy = 6;
        this.add(chImageJButton, contrainte);

        contrainte.gridx = 1;
        contrainte.gridy = 7;
        this.add(chImageConfirmationJLabel, contrainte);

        contrainte.gridx = 2;
        contrainte.gridy = 7;
        this.add(chImageConfirmationVueJLabel, contrainte);

    }

    public void enregistreEcouteur(Controler parControler) {
        chImageJButton.addActionListener(parControler);
        chImageJButton.setActionCommand("IMG");

        chAjoutJButton.addActionListener(parControler);
        chAjoutJButton.setActionCommand("+");

    }

    public void setAnneeComboBox(String[] parString) {
        for (String s : parString) {
            chDateAnneeJCombobox.addItem(s);
        }

    }

    public JTextArea getChTitreJTextArea() {
        return chTitreJTextArea;
    }

    public JTextArea getChTexteJTextArea() {
        return chTexteJTextArea;
    }

    public JComboBox getChDateAnneeJCombobox() {
        return chDateAnneeJCombobox;
    }

    public JComboBox getChDateMoisJCombobox() {
        return chDateMoisJCombobox;
    }

    public JComboBox getChDateJoursJCombobox() {
        return chDateJoursJCombobox;
    }

    public JComboBox getChPoidsJComboBox() {
        return chPoidsJComboBox;
    }

    public JButton getChImageJButton() {
        return chImageJButton;
    }

    public JFileChooser getChooser() {
        return chooser;
    }

    public JLabel getChImageConfirmationJLabel() {
        return chImageConfirmationJLabel;
    }

    public JLabel getChImageConfirmationVueJLabel() {
        return chImageConfirmationVueJLabel;
    }
}
