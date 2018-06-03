package Vue;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import Controler.Controler;
import Model.Chronologie;
import Model.Data;
import Model.LectureEcriture;

public class PanelsFils extends JPanel implements ActionListener, Data {

    private static CardLayout gestionnaireDesCartes = new CardLayout();

    private FenetreMere chFenetreMere;
    private File chSer;
    private JFileChooser chChooser = new JFileChooser();
    private PanelCreation chPanelCreation;
    private PanelFormulaire chPanelFormulaire;
    private PanelChronoDiapo chPanelChronoDiapo;

    public PanelsFils(FenetreMere parFenetreMere, File parSer) {

        chFenetreMere = parFenetreMere;
        chSer = parSer;

        setLayout(gestionnaireDesCartes);

        chPanelCreation = new PanelCreation();

        Chronologie chronologie;
        if (chSer.length() == 0) {
            add(chPanelCreation, "Creation");
            gestionnaireDesCartes.show(this, "Creation");
            chronologie = new Chronologie();

        } else
            chronologie = (Chronologie) LectureEcriture.lecture(chSer);

        chPanelChronoDiapo = new PanelChronoDiapo(chronologie);
        chPanelFormulaire = new PanelFormulaire(chronologie);

        add(chPanelFormulaire, NOMSOUSMENU2[0]);
        add(chPanelChronoDiapo, NOMSOUSMENU2[1]);

        chPanelChronoDiapo.getPanelDiapo().getChNomJLabel().setText(chronologie.getNom());

        new Controler(this, chPanelChronoDiapo, chPanelFormulaire, chSer, chronologie, chPanelCreation);

    }

    public void actionPerformed(ActionEvent parEvt) {

        if (parEvt.getActionCommand() == NOMSOUSMENU2[2]) {
            System.exit(0);
        }

        if (parEvt.getActionCommand() == NOMSOUSMENU2[0]) {
            gestionnaireDesCartes.show(this, NOMSOUSMENU2[0]);
        }

        if (parEvt.getActionCommand() == NOMSOUSMENU2[1]) {
            gestionnaireDesCartes.show(this, NOMSOUSMENU2[1]);
        }

        if (parEvt.getActionCommand() == NOMSOUSMENU1[0]) {
            chChooser.setCurrentDirectory(new java.io.File("save/."));
            chChooser.setDialogTitle("Choisir une chronologie");
            chChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chChooser.setAcceptAllFileFilterUsed(false);

            if (chChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { // Parce que le java
                System.out.println(chChooser.getSelectedFile().getName().toString());
                chSer = new File("save" + File.separator + chChooser.getSelectedFile().getName().toString());
                reset(chFenetreMere, chSer);
            } else {

            }
        }
    }

    public CardLayout getCardLayout() {
        return gestionnaireDesCartes;

    }

    public FenetreMere getFenetreMere() {
        return chFenetreMere;
    }

    public void reset(FenetreMere parFenetreMere, File parSer) {
        chFenetreMere = parFenetreMere;
        chSer = parSer;

        setLayout(gestionnaireDesCartes);

        chPanelCreation = new PanelCreation();

        Chronologie chronologie;
        if (parSer.length() == 0) {
            getFenetreMere().chMenuBar.setVisible(false);
            add(chPanelCreation, "Creation");
            gestionnaireDesCartes.show(this, "Creation");
            chronologie = new Chronologie();

        } else {
            chronologie = (Chronologie) LectureEcriture.lecture(chSer);
            gestionnaireDesCartes.show(this, NOMSOUSMENU2[0]);
        }

        chPanelChronoDiapo = new PanelChronoDiapo(chronologie);
        chPanelFormulaire = new PanelFormulaire(chronologie);

        add(chPanelFormulaire, NOMSOUSMENU2[0]);
        add(chPanelChronoDiapo, NOMSOUSMENU2[1]);

        chPanelChronoDiapo.getPanelDiapo().getChNomJLabel().setText(chronologie.getNom());
        new Controler(this, chPanelChronoDiapo, chPanelFormulaire, chSer, chronologie, chPanelCreation);

    }
}
