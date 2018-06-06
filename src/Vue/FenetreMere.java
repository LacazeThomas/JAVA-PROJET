package Vue;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
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
        //On nomme la fenetre
        setTitle("Frise chronologique");
        setResizable(false);
        chMenuBar = new JMenuBar();
        this.setJMenuBar(chMenuBar);

        //Par default on charge la sauvegarde demo
        File ser = new File("save" + File.separator + "demo.ser");

        //On appelle le panelFils avec le fichier de sauvegarde
        chPanelsFils = new PanelsFils(this, ser);
        //On crée le menubar
        chMenuBar = new JMenuBar();
        this.setJMenuBar(chMenuBar);

        //On l'aligne à  gauche
        chMenuBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        //On crée trois menu
        JMenu[] menu = new JMenu[3];

        //On leur donne un nom
        for (int i = 0; i < NOMMENU.length; i++) {
            menu[i] = new JMenu(NOMMENU[i]);
            menu[i].setMnemonic(NOMMENU[i].charAt(0));
            chMenuBar.add(menu[i]);
        }

        //On crée les sous menus
        for (int i = 0; i < NOMSOUSMENU1.length; i++) {
            JMenuItem menuItem = new JMenuItem(NOMSOUSMENU1[i], KeyEvent.VK_T);
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

        //Puis on fait la meme chose avec le dernier menu "quitter"
        JMenuItem menuItem = new JMenuItem(NOMSOUSMENU2[2]);
        menu[2].add(menuItem);
        menuItem.addActionListener(chPanelsFils);
        menuItem.setActionCommand(NOMSOUSMENU2[2]);

        setContentPane(chPanelsFils);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1350, 700);
        setVisible(true);

        //Si le fichier n'existe pas alors on enleve le menu pour facilier la comprehension
        if (ser.length() == 0) {
            chMenuBar.setVisible(false);
        }

        setLocation(100, 100);
    }

    public PanelsFils getPanelsFils() {
        return chPanelsFils;
    }

    public static void main(String[] args) {
        new FenetreMere();
    }

}