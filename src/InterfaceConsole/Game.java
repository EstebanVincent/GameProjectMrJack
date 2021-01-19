package InterfaceConsole;

import InterfaceUtilisateur.Affichage.*;
import InterfaceUtilisateur.TraitementIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;


public class Game {
    //Attributs
    private int tour = 1;
    //public int[] temps; //jeton temps double face 0 = tour et 1 = sablier
    public Player currentPlayer;
    public JLabel[][] boardGraph = new JLabel[5][5];

    //Constructeurs
    public Game() {
    }


    //Action action = new Action(this);
    //SuspectDistrict sus = new SuspectDistrict(this); //permet de transferé la valeur des atributs de mrjack a suspectDis
    Player player = new Player();
    Alibi alibi = new Alibi();
    Pioche pioche = new Pioche();
    Action action = new Action();
    TraitementIcon tIcon = new TraitementIcon();

    public void play() {
        //débutPartie();
        //b.setupBoard();
        //b.createPanelBoard();
        //b.printBoard();
        FrameGame frameGame = new FrameGame();
        LabelStart labelStart = new LabelStart();
        ToolBar toolBar = new ToolBar();
        PanelBoard panelBoard = new PanelBoard();
        action.initialiseJetons();
        PanelActions panelActions = new PanelActions(action.getJetons());
        LabelNaming labelNaming = new LabelNaming();


        initialise(frameGame, toolBar, panelBoard, panelActions, labelStart, pioche, labelNaming);

        //frameGame.getFrame().add(labelNaming.getBackground());
        frameGame.getFrame().add(labelStart.getGarde());
        frameGame.displayFrameGame();
        //panelBoard.printBoard(); //juste pour vérif


        //printBoard();
        //printBoardGraph();
/*
        for (int i = 1; i < 9; i++ ) {//i est le compteur de tour

            if (i % 2 == 1){ // tour impair, enqueteurs commence
                switchPlayer();

                action.initialisePossibleAction();
                action.printActionPossible();
                String act1 = action.chooseAction(); //ajouter un verif que c possible avec do while
                joueAction(act1);
                action.updateActionPossible(act1);


                switchPlayer();
                action.printActionPossible();
                String act2 = action.chooseAction(); //ajouter un verif que c possible avec do while
                joueAction(act2);
                action.updateActionPossible(act2);

                action.printActionPossible();
                String act3 = action.chooseAction(); //ajouter un verif que c possible avec do while
                joueAction(act3);
                action.updateActionPossible(act3);


                switchPlayer();
                action.printActionPossible();
                String act4 = action.actionsPossible[0]; //ajouter un verif que c possible avec do while
                //joueAction(act4);

                String[] retour = sus.see(district.baseDeDonnee[1][0]);

                //nefonctionnePas
                for (int k = 0; k < retour.length ; k++){
                    System.out.println(retour[k]);
                }

            } else { // tour pair Jack commence

                switchPlayer();
                action.printActionPossibleRetournée();
                String act1 = action.chooseAction(); //ajouter un verif que c possible avec do while
                joueAction(act1);
                action.updateActionPossibleRetournée(act1);


                switchPlayer();
                action.printActionPossibleRetournée();
                String act2 = action.chooseAction(); //ajouter un verif que c possible avec do while
                joueAction(act2);
                action.updateActionPossibleRetournée(act2);

                action.printActionPossibleRetournée();
                String act3 = action.chooseAction(); //ajouter un verif que c possible avec do while
                joueAction(act3);
                action.updateActionPossibleRetournée(act3);


                switchPlayer();
                action.printActionPossibleRetournée();
                String act4 = action.actionsPossibleRetournée[0]; //ajouter un verif que c possible avec do while
                //joueAction(act4);
            }






        }
         */


    }



    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    District district = new District();

    JFrame frame = new JFrame("Mr Jack Pocket");

    public void initialise(FrameGame frameGame,ToolBar toolBar, PanelBoard panelBoard, PanelActions panelActions, LabelStart labelStart, Pioche pioche,LabelNaming labelNaming){
        toolBar.initialiseToolBar(frameGame, pioche);
        panelBoard.initialisePanelBoard();
        //panelActions.initialisePanelActions(frameGame, panelBoard, labelNaming);
        labelStart.initialiseGarde(frameGame, labelNaming);
        labelNaming.setUp(frameGame,toolBar,panelBoard,panelActions);
    }
    /*
    public void printBoardGraph() {

        //on initialise la JFrame

        //On initialise le plateau
        JPanel plateau = new JPanel();


        //On initialise la toolBar
        JToolBar toolBar = new JToolBar();

        //on initialise les bails a droite du plateau, cad pioche alibi et actions possible
        JPanel cartes = new JPanel();
        cartes.setLayout(new GridLayout(2, 1));
        JButton piocheAlibi = new JButton(new ImageIcon("image/piocheAlibi.png")); //appuyer sur ce bouton pioche une carte alibi
        cartes.add(piocheAlibi);

        //On initialise le panel avec 4 bouton
        JPanel action = new JPanel();
        action.setLayout(new GridLayout(4, 1));
        JButton action1 = new JButton("action1");
        JButton action2 = new JButton("action2");
        JButton action3 = new JButton("action3");
        JButton action4 = new JButton("action4");
        action.add(action1);
        action.add(action2);
        action.add(action3);
        action.add(action4);

        cartes.add(action);


        //on initialise les bails a gauche du plateau
        JPanel tourDeJeu = new JPanel();
        tourDeJeu.setLayout(new GridLayout(9, 1));
        tourDeJeu.setPreferredSize(new Dimension(120, 0));
        JLabel carteJack = new JLabel(new ImageIcon("image/carteJack.png"));
        JLabel tour1 = new JLabel("tour1");
        JLabel tour2 = new JLabel("tour2");
        JLabel tour3 = new JLabel("tour3");
        JLabel tour4 = new JLabel("tour4");
        JLabel tour5 = new JLabel("tour5");
        JLabel tour6 = new JLabel("tour6");
        JLabel tour7 = new JLabel("tour7");
        JLabel tour8 = new JLabel("tour8");

        tourDeJeu.add(carteJack);
        tourDeJeu.add(tour8);
        tourDeJeu.add(tour7);
        tourDeJeu.add(tour6);
        tourDeJeu.add(tour5);
        tourDeJeu.add(tour4);
        tourDeJeu.add(tour3);
        tourDeJeu.add(tour2);
        tourDeJeu.add(tour1);
        //rajouter les jetons avec les tour dessus a l'aide d'une methode



        JButton credit = new JButton("crédits");
        //imgGarde.add(credit);


        frame.add(imgGarde);
        frame.pack();
        frame.setLocationRelativeTo(null); //centre la fenetre, tjr le metre en dernier sinon marche ap


        whoIsJack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Alibi name = alibi.choixJack();
                System.out.println("fuck u");
                //toolBar.remove(oneUse);
                toolBar.remove(whoIsJack);
                updateFrame();
            }
        });
        whoIsWho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rd = new Random();
                boolean choix = rd.nextBoolean();
                //faire un popup et demander au joueur de choisir 1 ou 2
                if (choix) {
                    System.out.println("The one who just pressed this button is Mr. Jack");
                } else {
                    System.out.println("The one who just pressed this button is Detective");
                }
                toolBar.remove(whoIsWho);
                updateFrame();
            }
        });
    }

     */

    public void transparent(JButton button) { //Rend le bouton transparent, on voit juste le text et la bordure
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
    }

    public void débutPartie() {
        //lance la game behind the scene, initialise le game, les joueurs, choisi Jack

        //b.initialisePanelBoard();
/*
        player.initialiseName();
        setCurrentPlayer(player.getPlayers()[0]); //enqueteur commence
        pioche.initialisePioche();//on crée la pioche


        Alibi alibiJack = alibi.choixJack(); //alibiJack est la carte alibi de Jack, et la pioche est update
        String jack = alibiJack.getNom(); //jack est le nom en string de son perso
        alibi.initialiseAlibiJack(alibiJack); //on initialise les carte alibi en possession de Jack

        action.initialiseJetons();
        */


    }

    public void switchPlayer(PanelActions panelActions, FrameGame frameGame) {
        if (currentPlayer == player.getPlayers()[1]) {//detective
            setCurrentPlayer(player.getPlayers()[0]);
            panelActions.changePlayerD2J();
        } else { //jack
            setCurrentPlayer(player.getPlayers()[1]);
            panelActions.changePlayerJ2D();
        }
        frameGame.updateFrame();
    }
    /*


    private void printBoard() {// faire un truc graphique
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print([i][j].getNom() + " " + board[i][j].getOrientation() + "\t");
            }
            System.out.println();
        }
    }

    public void joueAction(String actionChoisie) {
        if (Objects.equals(actionChoisie, new String("rotation1")) || Objects.equals(actionChoisie, new String("rotation2"))) {
            action.rotation();
            printBoard();
        } else if (Objects.equals(actionChoisie, new String("échange"))) {
            action.échange();
            printBoard();
        } else if (Objects.equals(actionChoisie, new String("getAlibi"))) {
            action.alibi(); //alibi est null??
        } else if (Objects.equals(actionChoisie, new String("holmes"))) {
            action.deplacementDetective(district.baseDeDonnee[1][0]);
            printBoard();
        } else if (Objects.equals(actionChoisie, new String("watson"))) {
            action.deplacementDetective(district.baseDeDonnee[1][1]);
            printBoard();
        } else if (Objects.equals(actionChoisie, new String("toby"))) {
            action.deplacementDetective(district.baseDeDonnee[1][2]);
            printBoard();
        } else if (Objects.equals(actionChoisie, new String("joker"))) {
            System.out.println("Quel Detective veux-tu déplacer ?");
            Scanner scanner = new Scanner(System.in);
            String detective = scanner.nextLine();
            if (Objects.equals(detective, new String("holmes"))) {
                action.deplacementDetective(district.baseDeDonnee[1][0], 1);
            } else if (Objects.equals(actionChoisie, new String("watson"))) {
                action.deplacementDetective(district.baseDeDonnee[1][1], 1);
            } else if (Objects.equals(actionChoisie, new String("toby"))) {
                action.deplacementDetective(district.baseDeDonnee[1][2], 1);
            }
            printBoard();
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
    */
}
