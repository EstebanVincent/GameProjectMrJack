package InterfaceUtilisateur.Affichage;

import InterfaceConsole.District;
import InterfaceUtilisateur.RotatedIcon;
import InterfaceUtilisateur.TraitementIcon;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PanelBoard{
    //Attributs
    private District[][] board = new District[5][5];
    private JLabel[][] labelArrayBoard = new JLabel[5][5];
    private JPanel panelBoard = new JPanel();
    public JPanel test = new JPanel();
    private List<Images> districts = new ArrayList<Images>(9);

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

    //Méthodes
    public void initialiseD(){
        districts.add(Images.Madame);
        districts.add(Images.SGT_Goodley);
        districts.add(Images.Jeremy_Bert);
        districts.add(Images.William_Gull);
        districts.add(Images.Miss_Stealthy);
        districts.add(Images.John_Smith);
        districts.add(Images.Insp_Lestrade);
        districts.add(Images.Insp_Lestrade);
        districts.add(Images.John_Pizer);
        districts.add(Images.Joseph_Lane);
        Collections.shuffle(districts);
    }

    public void initialisePanelBoard(){
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

        setUpPanelBoard();
    }

    public void setUpPanelBoard(){

        panelBoard.setLayout(new GridLayout(5,5));
        panelBoard.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        for (int i = 0; i < labelArrayBoard.length; i++){
            for (int j = 0; j < labelArrayBoard[0].length; j++){
                if (i == 1 && j == 1){
                    RotatedIcon holmes = new RotatedIcon(labelArrayBoard[i][j].getIcon(), RotatedIcon.Rotate.DOWN);
                    labelArrayBoard[i][j].setIcon(holmes);
                    panelBoard.add(labelArrayBoard[i][j]);
                } else if (i == 1 && j == 3) {
                    RotatedIcon watson = new RotatedIcon(labelArrayBoard[i][j].getIcon(), RotatedIcon.Rotate.UP);
                    labelArrayBoard[i][j].setIcon(watson);
                    panelBoard.add(labelArrayBoard[i][j]);
                } else {
                    if (board[i][j].getOrientation() == 0){
                        panelBoard.add(labelArrayBoard[i][j]);
                        panelBoard.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
                    } else if (board[i][j].getOrientation() == 1){
                        RotatedIcon EAST = new RotatedIcon(labelArrayBoard[i][j].getIcon(), RotatedIcon.Rotate.DOWN);
                        labelArrayBoard[i][j].setIcon(EAST);
                        panelBoard.add(labelArrayBoard[i][j]);
                    } else if (board[i][j].getOrientation() == 2){
                        RotatedIcon SOUTH = new RotatedIcon(labelArrayBoard[i][j].getIcon(), RotatedIcon.Rotate.UPSIDE_DOWN);
                        labelArrayBoard[i][j].setIcon(SOUTH);
                        panelBoard.add(labelArrayBoard[i][j]);
                    } else {
                        RotatedIcon WEST = new RotatedIcon(labelArrayBoard[i][j].getIcon(), RotatedIcon.Rotate.UP);
                        labelArrayBoard[i][j].setIcon(WEST);
                        panelBoard.add(labelArrayBoard[i][j]);
                    }
                }
            }
        }

         /*
        test.setPreferredSize(new Dimension(1000,1000));
        test.setLayout(null);
        test.setBackground(Color.BLACK);
        labelArrayBoard[2][2].setBounds(200, 200, 160,160);
        test.add(labelArrayBoard[2][2]);
*/
    }
    public void printBoard(){// faire un truc graphique
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j].getNom() + " " +board[i][j].getOrientation() + "\t");
            }
            System.out.println();
        }
    }
    public int[] findPosition(District district) {
        int[] defaut = {0, 0};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].getNom() == district.getNom()) {
                    int[] a = {i, j};
                    return a;
                }
            }
        }
        return defaut;
    }

}
