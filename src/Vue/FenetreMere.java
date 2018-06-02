package Vue;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Model.Data;

public class FenetreMere extends JFrame implements Data {

	PanelsFils chPanelsFils;
	
    public FenetreMere() {
    	chPanelsFils = new PanelsFils(this);

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        for (int i = 0; i < NOMMENU.length; i++) {
            JMenuItem menuItem = new JMenuItem(NOMMENU[i]);
            menuBar.add(menuItem);
            menuItem.addActionListener(chPanelsFils);
            menuItem.setActionCommand(NOMMENU[i]);
        }

        setContentPane(chPanelsFils);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        setLocation(0, 0);
    }

    public PanelsFils getPanelsFils() {
    	return chPanelsFils;
    }
    
    public static void main(String[] args) {
        new FenetreMere();
    }

}