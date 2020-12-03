package InterfaceUtilisateur;

import javax.swing.*;
import java.awt.*;

public class TraitementIcon {
    //Constructeur
    public TraitementIcon() { }

    //Méthodes
    public ImageIcon changeSize(String picture, int width, int height){
        ImageIcon imageIcon = new ImageIcon(picture); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
}
