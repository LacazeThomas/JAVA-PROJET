package Vue;

import java.awt.FlowLayout;
import java.awt.MenuBar;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Model.Chronologie;
import Model.Data;
import Model.LectureEcriture;

public class FenetreMere extends JFrame implements Data {

	private PanelsFils chPanelsFils;
	public JMenuBar chMenuBar;
	
    public FenetreMere() {
    	
    	chMenuBar = new JMenuBar();
        this.setJMenuBar(chMenuBar);	
    	
        File ser = new File("save" + File.separator + "chronologie.ser");
            
    
        	
    	
    	
    	chPanelsFils = new PanelsFils(this,ser);
    	chMenuBar = new JMenuBar();
        this.setJMenuBar(chMenuBar);

        chMenuBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        for (int i = 0; i < NOMMENU.length; i++) {
            JMenuItem menuItem = new JMenuItem(NOMMENU[i]);
            chMenuBar.add(menuItem);
            menuItem.addActionListener(chPanelsFils);
            menuItem.setActionCommand(NOMMENU[i]);
        }

        setContentPane(chPanelsFils);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1350,700);
        setVisible(true);

        if (ser.length() == 0) {
        	chMenuBar.setVisible(false);
        	System.out.print("ghlhsdkl");
        }
        
        setLocation(0, 0);
    }

    public PanelsFils getPanelsFils() {
    	return chPanelsFils;
    }
    
    public static void main(String[] args) {
        new FenetreMere();
    }

}