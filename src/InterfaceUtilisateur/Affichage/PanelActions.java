package InterfaceUtilisateur.Affichage;

import InterfaceUtilisateur.TraitementIcon;
import InterfaceConsole.Action;
import com.sun.deploy.net.proxy.pac.PACFunctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PanelActions extends Action{

    public PanelActions(Action[] jetons){
        super(jetons);
    }
    //Nouvelles instances de classes
    Random rd = new Random();
    //Action action = new Action();

    //Attributs
    private List<Integer> actionsRd = new ArrayList<Integer>();
    private JPanel panelActions = new JPanel();

    private JButton action1recto = new JButton(Images.Action1.getRecto());
    private JButton action1verso = new JButton(Images.Action1.getVerso());

    private JButton action2recto = new JButton(Images.Action2.getRecto());
    private JButton action2verso = new JButton(Images.Action2.getVerso());

    private JButton action3recto = new JButton(Images.Action3.getRecto());
    private JButton action3verso = new JButton(Images.Action3.getVerso());

    private JButton action4recto = new JButton(Images.Action4.getRecto());
    private JButton action4verso = new JButton(Images.Action4.getVerso());

    private final JButton[][] actions = new JButton[][]{{action1recto, action1verso}, {action2recto, action2verso}, {action3recto, action3verso}, {action4recto, action4verso}};

    private LabelNaming labelNaming = new LabelNaming(); //nan je veux conserver les valeurs de l'autre pas en crée une nouvelle instance
    private JLabel turnJ = new JLabel();
    private JLabel turnD = new JLabel();

    //Getters and Setters
    public JPanel getPanelActions() { return panelActions; }

    public void setPanelActions(JPanel panelActions) { this.panelActions = panelActions; }

    //Méthodes
    public void initialisePanelActions(FrameGame frameGame, PanelBoard panelBoard,LabelNaming labelNaming){
        turnD.setText(labelNaming.getDetective().getName() + "'s turn");
        turnD.setFont(new Font("Serif", Font.PLAIN, 35));
        turnD.setForeground(Color.BLUE);
        turnD.setVerticalTextPosition(JLabel.CENTER);
        turnD.setHorizontalTextPosition(JLabel.CENTER);

        turnJ.setText(labelNaming.getJack().getName() + "'s turn");
        turnJ.setFont(new Font("Serif", Font.PLAIN, 35));
        turnJ.setForeground(Color.RED);
        turnJ.setVerticalTextPosition(JLabel.CENTER);
        turnJ.setHorizontalTextPosition(JLabel.CENTER);


        panelActions.setLayout(new GridLayout(5,1));
        panelActions.add(turnD);

        for (int i = 0; i < 4; i++){
            int rand = rd.nextInt(1 - 0 + 1);
            actionsRd.add(rand);
            panelActions.add(actions[i][rand]);
        }

        initialiseAction1Recto(frameGame);
        initialiseAction3Recto(frameGame, panelBoard);
    }
    public void changePlayerD2J(){
        panelActions.remove(turnD);
        panelActions.add(turnJ,0);
    }
    public void changePlayerJ2D(){
        panelActions.remove(turnJ);
        panelActions.add(turnD,0);
    }

    public void test(){ //donne les actions du tour d'après
        for ( int i = 0; i < actionsRd.size(); i++){
            panelActions.remove(actions[i][actionsRd.get(i)]);
            panelActions.add(actions[i][(actionsRd.get(i)+1)%2],i+1);//index + 1 car le 0 dit c'est le tour de qui, le %2 permet de changer 1 en 0 en inversement
        }
    }

    public void initialiseAction1Recto(FrameGame frameGame){
        action1recto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test();
                frameGame.updateFrame();
            }
        });
    }
    public void initialiseAction2Recto(FrameGame frameGame){
        action2recto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameGame.updateFrame();
            }
        });
    }
    public void initialiseAction3Recto(FrameGame frameGame, PanelBoard panelBoard){
        action3recto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //panelBoard.getPanelBoard().get
                panelBoard.getPanelBoard().remove(5);

                frameGame.updateFrame();
            }
        });
    }
    public void initialiseAction4Recto(FrameGame frameGame){
        action4recto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameGame.updateFrame();
            }
        });
    }
    public void initialiseAction1Verso(FrameGame frameGame){
        action1verso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameGame.updateFrame();
            }
        });
    }
    public void initialiseAction2Verso(FrameGame frameGame){
        action2verso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameGame.updateFrame();
            }
        });
    }
    public void initialiseAction3Verso(FrameGame frameGame){
        action3verso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameGame.updateFrame();
            }
        });
    }
    public void initialiseAction4Verso(FrameGame frameGame){
        action4verso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameGame.updateFrame();
            }
        });
    }
}
