package InterfaceUtilisateur.Affichage;

import javax.swing.*;
import java.awt.*;

public class FrameGame{
    //Attributs
    private JFrame frame = new JFrame();

    //Getters and Setters
    public JFrame getFrame() { return frame; }

    public void setFrame(JFrame frame) { this.frame = frame; }

    //Méthodes
    public void displayFrameGame(){
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void updateFrame() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        SwingUtilities.updateComponentTreeUI(frame);
    }


}
