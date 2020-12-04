package InterfaceUtilisateur.Affichage;

import javax.swing.*;
import java.awt.*;

public class PanelActions {
    //Attributs
    private JPanel panelActions = new JPanel();
    private JPanel quatreActions = new JPanel();

    private JButton draw = new JButton(new ImageIcon("image/piocheAlibi.png"));

    private JButton action1 = new JButton("action1");
    private JButton action2 = new JButton("action2");
    private JButton action3 = new JButton("action3");
    private JButton action4 = new JButton("action4");

    //Getters and Setters


    public JPanel getPanelActions() { return panelActions; }

    public void setPanelActions(JPanel panelActions) { this.panelActions = panelActions; }

    public JPanel getQuatreActions() { return quatreActions; }

    public void setQuatreActions(JPanel quatreActions) { this.quatreActions = quatreActions; }

    //Méthodes
    public void initialisePanelActions(){
        panelActions.setLayout(new GridLayout(2,1));
        panelActions.add(draw);

        quatreActions.setLayout(new GridLayout(4,1));
        quatreActions.add(action1);    quatreActions.add(action2);
        quatreActions.add(action3);    quatreActions.add(action4);

        panelActions.add(quatreActions);
    }
}
