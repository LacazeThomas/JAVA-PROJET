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
	
	public JLabel chTitreFormulaireJLabel = new JLabel("Formulaire d'ajout:");
	public JButton chAjoutJButton = new JButton("+");
	
	public Chronologie chChronologie = new Chronologie();
	
	public JLabel chTitreJLabel = new JLabel("Titre:");
	public JTextArea chTitreJTextArea = new JTextArea("", 1, 10);
	
	public JLabel chTexteJLabel = new JLabel("Texte:");
	public JTextArea chTexteJTextArea = new JTextArea("", 1, 10);
	
	public JLabel chDateJLabel = new JLabel("Date:");
	public JComboBox chDateAnneeJCombobox;
    
    public JComboBox chDateMoisJCombobox;

    public JComboBox chDateJoursJCombobox;

	public JLabel chPoidsJLabel = new JLabel("Poids:");
	public JComboBox chPoidsJComboBox = new JComboBox(POIDS);
	
	public JLabel chImageJLabel = new JLabel("Image");
	public JButton chImageJButton = new JButton("Parcourir...");
	public JFileChooser chooser = new JFileChooser();
	
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
        this.add(chTitreFormulaireJLabel, contrainte);
      
        
        contrainte.gridx = 2;
        contrainte.gridy = 1;
        this.add(chAjoutJButton, contrainte);

        contrainte.gridx = 1;
        contrainte.gridy = 2;
        this.add(chTitreJLabel, contrainte);
        
        contrainte.gridx = 2;
        contrainte.gridy = 2;
        this.add(chTitreJTextArea, contrainte);
        
        contrainte.gridx = 1;
        contrainte.gridy = 3;
        this.add(chTexteJLabel, contrainte);
        
        contrainte.gridx = 2;
        contrainte.gridy = 3;
        this.add(chTexteJTextArea, contrainte);
        
        contrainte.gridx = 1;
        contrainte.gridy = 4;
        this.add(chDateJLabel, contrainte);
        
        contrainte.gridx = 2;
        contrainte.gridy = 4;
        

        if(chChronologie.chFin!=0){
            String []anneeStrings = new String[chChronologie.chFin-chChronologie.chDebut+1];

            for(int i = 0; i<chChronologie.chFin-chChronologie.chDebut+1;i++){
                anneeStrings[i] = chChronologie.chDebut+i+"";
                chDateAnneeJCombobox  = new JComboBox(anneeStrings);
            }
        }
        else{
                chDateAnneeJCombobox  = new JComboBox();
        }
            
        
        this.add(chDateAnneeJCombobox, contrainte);


        String []moisStrings = new String[12];
        for(int i = 0; i<12;i++){
            moisStrings[i] = i+1+"";
        }
        chDateMoisJCombobox  = new JComboBox(moisStrings);
        contrainte.gridx = 3;
        contrainte.gridy = 4;
        this.add(chDateMoisJCombobox, contrainte);       


        String []joursStrings = new String[31];
        for(int i = 0; i<31;i++){
            joursStrings[i] = i+1+"";
        }
        chDateJoursJCombobox  = new JComboBox(joursStrings);
        contrainte.gridx = 4;
        contrainte.gridy = 4;
        this.add(chDateJoursJCombobox, contrainte);   


        
        contrainte.gridx = 1;
        contrainte.gridy = 5;
        this.add(chPoidsJLabel, contrainte);
        
        
        contrainte.gridx = 2;
        contrainte.gridy = 5;
        this.add(chPoidsJComboBox, contrainte);
        
        contrainte.gridx = 1;
        contrainte.gridy = 6;
        this.add(chImageJLabel, contrainte);
        
        
        contrainte.gridx = 2;
        contrainte.gridy = 6;
        this.add(chImageJButton, contrainte);
        
	}
	
	public void enregistreEcouteur(Controler parControler) {
		chImageJButton.addActionListener(parControler);
		chImageJButton.setActionCommand("IMG");
		
        chAjoutJButton.addActionListener(parControler);
        chAjoutJButton.setActionCommand("+");
        
    }
    
    public void setAnneeComboBox(String[] parString){
        for (String s : parString) {
            chDateAnneeJCombobox.addItem(s);
        }
        
    }
}
