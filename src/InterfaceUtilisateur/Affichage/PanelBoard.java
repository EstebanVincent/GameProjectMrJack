package InterfaceUtilisateur.Affichage;

import InterfaceConsole.District;
import InterfaceUtilisateur.TraitementIcon;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PanelBoard extends JPanel{
    //Attributs
    private District[][] board = new District[5][5];
    private JLabel[][] labelArrayBoard = new JLabel[5][5];
    private JPanel panelBoard = new JPanel();

    //Getters and Setters
    public District[][] getBoard() { return board; }

    public void setBoard(District[][] board) { this.board = board; }

    public JLabel[][] getLabelArrayBoard() { return labelArrayBoard; }

    public void setLabelArrayBoard(JLabel[][] labelArrayBoard) { this.labelArrayBoard = labelArrayBoard; }

    public JPanel getPanelBoard() { return panelBoard; }

    public void setPanelBoard(JPanel panelBoard) { this.panelBoard = panelBoard; }

    //Nouvelle instance de classe
    District district = new District();
    TraitementIcon tIcon = new TraitementIcon();
    JFrame frame = new JFrame("Mr. Jack Pocket");


    //Méthodes
    public void createPanelBoard(){
        panelBoard.setLayout(new GridLayout(5, 5));
        panelBoard.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        for (int i = 0; i < labelArrayBoard.length; i++) {
            for (int j = 0; j < labelArrayBoard[0].length; j++) {
                panelBoard.add(labelArrayBoard[i][j]);
                panelBoard.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            }
        }
    }

    public void printBoard(){
        createPanelBoard();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panelBoard);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void setupBoard(){
        district.setUp();

        //les cases exterieurs sont vides
        for (int i = 0; i < 5; i++) {//ligne
            board[0][i] = district.getBaseDeDonnee()[2][0]; //exception
            labelArrayBoard[0][i] = new JLabel(board[0][i].getFaceSus());
            labelArrayBoard[0][i].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            for (int j = 0; j < 5; j++) {//colone
                if (j == 0 || j == 4) {
                    board[i][j] = district.getBaseDeDonnee()[2][0]; //Vide
                    labelArrayBoard[i][j] = new JLabel(board[i][j].getFaceSus());
                    labelArrayBoard[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
                }
                if (i == 0 || i == 4){
                    board[i][j] = district.getBaseDeDonnee()[2][0];//Vide
                    labelArrayBoard[i][j] = new JLabel(board[i][j].getFaceSus());
                    labelArrayBoard[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
                }
            }
        }
        //board[0][0] = board[4][0] =board[0][4] = board[4][4] = null;
        board[1][0] = district.getBaseDeDonnee()[1][0]; //Holmes
        labelArrayBoard[1][0] = new JLabel(board[1][0].getFaceSus());
        labelArrayBoard[1][0].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        board[1][4] = district.getBaseDeDonnee()[1][1]; //Watson
        labelArrayBoard[1][4] = new JLabel(board[1][4].getFaceSus());
        labelArrayBoard[1][4].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        board[4][2] = district.getBaseDeDonnee()[1][2]; //Toby
        labelArrayBoard[4][2] = new JLabel(board[4][2].getFaceSus());
        labelArrayBoard[4][2].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        //on schuffle cette liste pour que les districtes soient tjr à des positions différentes
        District[] perso = district.getBaseDeDonnee()[0];
        List<District> list = Arrays.asList(perso);
        Collections.shuffle(list);
        list.toArray(perso);

        int a = 0; //indice pour parcourir perso

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                board[i][j] = perso[a];
                labelArrayBoard[i][j] = new JLabel(board[i][j].getFaceSus());
                labelArrayBoard[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
                a = a+1; //passe au prochain perso
            }
        }
        //on fait en sorte que les inspecteurs soient en face d'un mur
        board[1][1].setOrientation(1);
        board[1][3].setOrientation(3);
        board[3][2].setOrientation(0);
    }
    /*
    public void setUpPanelBoard(){
        JPanel plateau = new JPanel();
        plateau.setLayout(new GridLayout(5,5));
        plateau.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                plateau.add(board[i][j]);
                plateau.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            }
        }
    }

     */
}
