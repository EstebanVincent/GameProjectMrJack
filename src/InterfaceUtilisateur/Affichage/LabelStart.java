package InterfaceUtilisateur.Affichage;

import InterfaceUtilisateur.TraitementIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LabelStart{
    //Attributs
    private JLabel garde;
    private JButton start;
    private JButton fleche;

    //Getters and Setters
    public JLabel getGarde() { return garde; }

    public void setGarde(JLabel garde) { this.garde = garde; }

    public JButton getStart() { return start; }

    public void setStart(JButton start) { this.start = start; }

    public JButton getFleche() { return fleche; }

    public void setFleche(JButton fleche) { this.fleche = fleche; }

    //Nouvelles instances de classes
    TraitementIcon tIcon = new TraitementIcon();

    //Méthodes
    public void initialiseGarde(FrameGame frameGame, LabelNaming labelNaming){
        setGarde(new JLabel(tIcon.changeSize("image/garde_4x.png", 700, 700)));

        garde.setLayout(new GridBagLayout());

        initialiseButtonStart(frameGame, labelNaming);

        initialiseFleche();

        garde.add(fleche, new GridBagConstraints());
        garde.add(start, new GridBagConstraints());
    }

    public void initialiseButtonStart(FrameGame frameGame,LabelNaming labelNaming){
        setStart(new JButton("Start Game"));
        start.setPreferredSize(new Dimension(550, 100));
        start.setFont(start.getFont().deriveFont(100f));
        start.setContentAreaFilled(false);//maybe ajouter une fleche qui s'ffiche qd tu le selectione, addMouseListener (MouseAdapteur), mouseEntered and mouseExited

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameGame.getFrame().remove(garde);
                frameGame.getFrame().add(labelNaming.getBackground());
                frameGame.getFrame().setSize(540, 540);
                frameGame.getFrame().setLocationRelativeTo(null);
                SwingUtilities.updateComponentTreeUI(frameGame.getFrame());
            }
        });
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                fleche.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                fleche.setVisible(false);
            }
        });


    }
    public void initialiseFleche(){
        setFleche(new JButton(">"));
        fleche.setFont(start.getFont().deriveFont(100f));
        fleche.setContentAreaFilled(false);
        fleche.setVisible(false);
    }

}
