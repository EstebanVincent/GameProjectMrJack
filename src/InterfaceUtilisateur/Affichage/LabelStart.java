package InterfaceUtilisateur.Affichage;

import InterfaceUtilisateur.TraitementIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelStart{
    //Attributs
    private JLabel garde;
    private JButton start;

    //Getters and Setters
    public JLabel getGarde() { return garde; }

    public void setGarde(JLabel garde) { this.garde = garde; }

    public JButton getStart() { return start; }

    public void setStart(JButton start) { this.start = start; }

    //Nouvelles instances de classes
    TraitementIcon tIcon = new TraitementIcon();

    //Méthodes
    public void initialiseGarde(FrameGame frameGame,ToolBar bar){
        setGarde(new JLabel(tIcon.changeSize("image/garde_4x.png", 600, 600)));

        garde.setLayout(new GridBagLayout());

        initialiseButtonStart(frameGame, bar);

        garde.add(start, new GridBagConstraints());
    }

    public void initialiseButtonStart(FrameGame frameGame,ToolBar bar){
        setStart(new JButton("Start Game"));
        start.setPreferredSize(new Dimension(550, 100));
        start.setFont(start.getFont().deriveFont(100f));
        start.setContentAreaFilled(false);//maybe ajouter une fleche qui s'ffiche qd tu le selectione

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("fck u"); //fonctionne donc le probleme est dans qui est qui
                frameGame.getFrame().remove(garde);
                frameGame.getFrame().add(bar.getToolBar(), BorderLayout.NORTH);
                //frameGame.getFrame().add(plateau, BorderLayout.CENTER);
                //frameGame.getFrame().add(cartes, BorderLayout.EAST);
                //frameGame.getFrame().add(tourDeJeu,BorderLayout.WEST);
                frameGame.updateFrame();
            }
        });

    }

}
