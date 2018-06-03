package Vue;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import Model.Evenement;

public class CelluleRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        //Si la case est de la classe Evenement alors il y a bien un evenement présent 
        if (value instanceof Evenement) {
            //Donc on recupere l'evenement en question
            Evenement testEvt = (Evenement) value;

            //Puis on récupere sa variable path qui est le nom de l'image de celui-ci et on la redimensionne
            setIcon(new ImageIcon(new ImageIcon("images/" + testEvt.getPath()).getImage().getScaledInstance(70, 50,
                    Image.SCALE_DEFAULT)));
        } else {
            //Si on mets une image qui n'existe pour pas réinitialiser l'image et éviter la duplications
            setIcon(new ImageIcon("dffd"));
        }


        //On finit par rendre la cellule une fois composée
        return cell;
    }
}
