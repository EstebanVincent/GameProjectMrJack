package InterfaceUtilisateur.Affichage;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar{
    //Attributs
    private JToolBar toolBar = new JToolBar();

    //Getters and Setters
    public JToolBar getToolBar() { return toolBar; }

    public void setToolBar(JToolBar toolBar) { this.toolBar = toolBar; }

    //Méthodes
    public void initialiseToolBar(){
        JLabel oneUse = new JLabel("Set up : ");
        JButton whoIsWho = new JButton("Choix des roles random");
        JButton whoIsJack = new JButton("Qui est Mr. Jack ?");//Ce bouton initialise qui est Mr. Jack et le dis au joueur, et place la pile de alibi a droite dans cartes

        JLabel eachRound = new JLabel("En fin de tour : ");
        JButton temoin = new JButton("Appel a témoin"); //Ce bouton demande au joueur si Mr. Jack est visible

        JLabel fin = new JLabel("En fin de partie : ");
        JButton win = new JButton("Win ?"); //appuyer si tu pense avoir gagner, l'ordi vérifie

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
}
