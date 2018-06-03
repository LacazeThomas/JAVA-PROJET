package Vue;

import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Model.Data;

public class FenetreMere extends JFrame implements Data {

    private PanelsFils chPanelsFils;
    public JMenuBar chMenuBar;

    public FenetreMere() {
        setTitle("Frise chronologique");
        chMenuBar = new JMenuBar();
        this.setJMenuBar(chMenuBar);

        File ser = new File("save" + File.separator + "chronologie.ser");

        chPanelsFils = new PanelsFils(this, ser);
        chMenuBar = new JMenuBar();
        this.setJMenuBar(chMenuBar);

        chMenuBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        JMenu[] menu = new JMenu[3];

        for (int i = 0; i < NOMMENU.length; i++) {
            menu[i] = new JMenu(NOMMENU[i]);
            chMenuBar.add(menu[i]);
        }

        for (int i = 0; i < NOMSOUSMENU1.length; i++) {
            JMenuItem menuItem = new JMenuItem(NOMSOUSMENU1[i]);
            menu[0].add(menuItem);
            menuItem.addActionListener(chPanelsFils);
            menuItem.setActionCommand(NOMSOUSMENU1[i]);
        }

        for (int i = 0; i < NOMSOUSMENU2.length - 1; i++) {
            JMenuItem menuItem = new JMenuItem(NOMSOUSMENU2[i]);
            menu[1].add(menuItem);
            menuItem.addActionListener(chPanelsFils);
            menuItem.setActionCommand(NOMSOUSMENU2[i]);
        }

        JMenuItem menuItem = new JMenuItem(NOMSOUSMENU2[2]);
        menu[2].add(menuItem);
        menuItem.addActionListener(chPanelsFils);
        menuItem.setActionCommand(NOMSOUSMENU2[2]);

        setContentPane(chPanelsFils);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1350, 700);
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