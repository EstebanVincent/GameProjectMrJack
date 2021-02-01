package InterfaceUtilisateur.Affichage;

import InterfaceConsole.Player;
import sun.misc.JavaLangAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelNaming {
    //Attributs
    public Player jack = new Player("Jack",1);
    public Player detective = new Player("Detective",0);
    private JPanel background = new JPanel();
    private JButton start = new JButton("Start");;
    private JTextField jackTxt = new JTextField(20);
    private JTextField detectiveTxt = new JTextField(20);
    private JLabel wJ = new JLabel("Who is playing Jack?");
    private JLabel wD = new JLabel("Who is playing Detective?");

    public void setJack(Player jack) {
        this.jack = jack;
    }

    public void setDetective(Player detective) {
        this.detective = detective;
    }

    public Player getJack() {
        return jack;
    }

    public Player getDetective() {
        return detective;
    }

    public JPanel getBackground() {
        return background;
    }

    public void setBackground(JPanel background) {
        this.background = background;
    }

    public JButton getStart() {
        return start;
    }

    public void setStart(JButton start) {
        this.start = start;
    }

    public JTextField getJackTxt() {
        return jackTxt;
    }

    public void setJackTxt(JTextField jackTxt) {
        this.jackTxt = jackTxt;
    }

    public JTextField getDetectiveTxt() {
        return detectiveTxt;
    }

    public void setDetectiveTxt(JTextField detective) {
        this.detectiveTxt = detectiveTxt;
    }

    public JLabel getwJ() {
        return wJ;
    }

    public void setwJ(JLabel wJ) {
        this.wJ = wJ;
    }

    public JLabel getwD() {
        return wD;
    }

    public void setwD(JLabel wD) {
        this.wD = wD;
    }

    public void setUp(FrameGame frameGame,ToolBar bar, PanelBoard panelBoard, PanelActions panelActions) {

        //frameGame.getFrame().setSize(540, 540);
        background.setLayout(null);

        final Font font = start.getFont().deriveFont(40f);

        start.setBounds(150, 400, 200, 50);
        start.setFont(font);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameJack = jackTxt.getText();
                String nameDetective = detectiveTxt.getText();

                if (!nameJack.equals("")) {
                    jack.setName(nameJack);
                }
                if (!nameDetective.equals("")) {
                    detective.setName(nameDetective);
                }
                panelActions.initialisePanelActions(frameGame,panelBoard,LabelNaming.this);
                frameGame.getFrame().remove(background);
                frameGame.getFrame().add(bar.getToolBar(), BorderLayout.NORTH);
                //frameGame.getFrame().add(panelBoard.getPanelBoard(), BorderLayout.CENTER);
                frameGame.getFrame().add(panelBoard.getPanelBoard(), BorderLayout.CENTER);
                frameGame.getFrame().add(panelActions.getPanelActions(), BorderLayout.EAST);
                //frameGame.getFrame().add(tourDeJeu,BorderLayout.WEST);
                frameGame.updateFrame();
            }
        });

        jackTxt.setBounds(10, 100, 500, 50);
        jackTxt.setFont(font);

        detectiveTxt.setBounds(10, 280, 500, 50);
        detectiveTxt.setFont(font);

        wJ.setBounds(10, 20, 500, 50);
        wJ.setFont(font);
        wJ.setForeground(Color.RED);

        wD.setBounds(10, 200, 500, 50);
        wD.setFont(font);
        wD.setForeground(Color.BLUE);

        background.add(wJ);
        background.add(jackTxt);
        background.add(wD);
        background.add(detectiveTxt);
        background.add(start);
    }
}
