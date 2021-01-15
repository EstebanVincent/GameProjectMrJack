package InterfaceUtilisateur.Affichage;

import sun.misc.JavaLangAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelNaming {
    //Attributs
    private String nameDetective;
    private String nameJack;
    private JPanel background = new JPanel();
    private JButton start = new JButton("Start");;
    private JTextField jack = new JTextField(20);
    private JTextField detective = new JTextField(20);
    private JLabel wJ = new JLabel("Who is playing Jack?");
    private JLabel wD = new JLabel("Who is playing Detective?");

    public String getNameDetective() {
        return nameDetective;
    }

    public void setNameDetective(String nameDetective) {
        this.nameDetective = nameDetective;
    }

    public String getNameJack() {
        return nameJack;
    }

    public void setNameJack(String nameJack) {
        this.nameJack = nameJack;
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

    public JTextField getJack() {
        return jack;
    }

    public void setJack(JTextField jack) {
        this.jack = jack;
    }

    public JTextField getDetective() {
        return detective;
    }

    public void setDetective(JTextField detective) {
        this.detective = detective;
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
                frameGame.getFrame().remove(background);
                frameGame.getFrame().add(bar.getToolBar(), BorderLayout.NORTH);
                frameGame.getFrame().add(panelBoard.getPanelBoard(), BorderLayout.CENTER);
                frameGame.getFrame().add(panelActions.getPanelActions(), BorderLayout.EAST);
                //frameGame.getFrame().add(tourDeJeu,BorderLayout.WEST);
                frameGame.updateFrame();
            }
        });

        jack.setBounds(10, 100, 500, 50);
        jack.setFont(font);
        jack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameJack = jack.getText();
                if (nameJack == null) {
                    nameJack = "Jack";
                }
            }
        });



        detective.setBounds(10, 280, 500, 50);
        detective.setFont(font);
        detective.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameDetective = detective.getText();
                if (nameDetective == null) {
                    nameDetective = "Detective";
                }
            }
        });


        wJ.setBounds(10, 20, 500, 50);
        wJ.setFont(font);
        wJ.setForeground(Color.RED);


        wD.setBounds(10, 200, 500, 50);
        wD.setFont(font);
        wD.setForeground(Color.BLUE);

        background.add(wJ);
        background.add(jack);
        background.add(wD);
        background.add(detective);
        background.add(start);
    }
}
