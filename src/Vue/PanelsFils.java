package Vue;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JPanel;

import Controler.Controler;
import Model.Chronologie;
import Model.Data;
import Model.LectureEcriture;

public class PanelsFils extends JPanel implements ActionListener, Data {

    private CardLayout gestionnaireDesCartes = new CardLayout();

    public PanelsFils() {
        setLayout(gestionnaireDesCartes);

        PanelCreation panelCreation = new PanelCreation();

        File ser = new File("save" + File.separator + "chronologie.ser");

        Chronologie chronologie;
        if (ser.length() == 0) {

            add(panelCreation, "Creation");
            gestionnaireDesCartes.show(this, "Creation");
            chronologie = new Chronologie();
            // PanelCreationdelaChronologie

        } else
            chronologie = (Chronologie) LectureEcriture.lecture(ser);

        PanelChronoDiapo panelChronoDiapo = new PanelChronoDiapo(chronologie);
        PanelFormulaire panelFormulaire = new PanelFormulaire(chronologie);

        add(panelFormulaire, NOMMENU[0]);
        add(panelChronoDiapo, NOMMENU[1]);

        panelChronoDiapo.getPanelDiapo().getChNomJLabel().setText(chronologie.getNom());

        new Controler(panelChronoDiapo, panelFormulaire, ser, chronologie, panelCreation);

    }

    public void actionPerformed(ActionEvent parEvt) {

        if (parEvt.getActionCommand() == NOMMENU[2]) {
            System.exit(0);
        }

        if (parEvt.getActionCommand() == NOMMENU[0]) {
            gestionnaireDesCartes.show(this, NOMMENU[0]);
        }

        if (parEvt.getActionCommand() == NOMMENU[1]) {
            gestionnaireDesCartes.show(this, NOMMENU[1]);
        }
    }

}
