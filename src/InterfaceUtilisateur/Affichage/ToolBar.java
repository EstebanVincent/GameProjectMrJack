package InterfaceUtilisateur.Affichage;

import InterfaceConsole.Alibi;
import InterfaceConsole.Pioche;
import InterfaceUtilisateur.TraitementIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ToolBar{
    //Attributs
    private JToolBar toolBar = new JToolBar();

    private JButton whoIsWho = new JButton("Choix des roles");
    //private JOptionPane JackIs =new JOptionPane();

    private JButton whoIsJack = new JButton("Qui est Mr. Jack ?");//Ce bouton initialise qui est Mr. Jack et le dis au joueur, et place la pile de alibi a droite dans cartes

    private JButton temoin = new JButton("Appel a témoin"); //Ce bouton demande au joueur si Mr. Jack est visible

    private JButton win = new JButton("Win ?"); //appuyer si tu pense avoir gagner, l'ordi vérifie

    //Getters and Setters
    public JToolBar getToolBar() { return toolBar; }

    public void setToolBar(JToolBar toolBar) { this.toolBar = toolBar; }

    //Méthodes
    public void initialiseToolBar(FrameGame frameGame, Pioche pioche){
        JLabel oneUse = new JLabel("Set up : ");
        initialiseWhoIsWho(frameGame);
        initialiseWhoIsJack(frameGame, pioche);

        JLabel eachRound = new JLabel("En fin de tour : ");

        JLabel fin = new JLabel("En fin de partie : ");

        toolBar.add(oneUse);
        toolBar.add(whoIsWho);
        toolBar.add(whoIsJack);
        toolBar.addSeparator(new Dimension(40, 0));

        toolBar.add(eachRound);
        toolBar.add(temoin);
        toolBar.addSeparator(new Dimension(40, 0));

        toolBar.add(fin);
        toolBar.add(win);


    }
    public void initialiseWhoIsWho(FrameGame frameGame){
        whoIsWho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rd = new Random();
                boolean choix = rd.nextBoolean();
                //faire un popup et demander au joueur de choisir 1 ou 2
                if (choix){
                    JOptionPane.showMessageDialog(frameGame.getFrame(),"The player who pushed this button is Mr. Jack");
                } else {
                    JOptionPane.showMessageDialog(frameGame.getFrame(),"The player who pushed this button is Detective");
                }
                toolBar.remove(whoIsWho);
                frameGame.updateFrame();
            }
        });
    }
    public void initialiseWhoIsJack(FrameGame frameGame, Pioche pioche){
        whoIsJack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TraitementIcon tIcon = new TraitementIcon();
                pioche.initialisePioche();
                Alibi Jack = pioche.draw1Carte();
                System.out.println(Jack.getName());
                JOptionPane.showMessageDialog(null,null,"Mr. Jack is",JOptionPane.INFORMATION_MESSAGE,tIcon.changeSize("image/alibis/" + Jack.getName() + ".png",200,300));
                toolBar.remove(whoIsJack);
                frameGame.updateFrame();
            }
        });
    }

}
