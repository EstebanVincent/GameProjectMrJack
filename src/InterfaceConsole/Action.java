package InterfaceConsole;

import InterfaceUtilisateur.Affichage.Images;
import InterfaceUtilisateur.Affichage.PanelBoard;
import InterfaceUtilisateur.TraitementIcon;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Action {
    //Attributs
    private String recto;
    private ImageIcon imgRecto;

    private String verso;
    private ImageIcon imgVerso;

    private Action[] jetons; // les jetons de 1 à 4 avec leur faces
    private String[] actionsPossible;
    private String[] actionsPossibleRetournée;

    private final int[][] positionDetectiveList = { {0,1}, {0,2}, {0,3}, {1,4}, {2,4}, {3,4}, {4,3}, {4,2}, {4,1}, {3,0}, {2,0}, {1,0}, {0,1}, {0,2} };

    //Constructeurs
    public Action(String recto, ImageIcon imgRecto, String verso, ImageIcon imgVerso) {
        setRecto(recto);
        setImgRecto(imgRecto);
        setVerso(verso);
        setImgVerso(imgVerso);
    }
    public Action(Action[] jetons){
        setJetons(jetons);
    }

    public Action() { }

    //Getters and Setters
    public String getRecto() {
        return recto;
    }

    public void setRecto(String recto) {
        this.recto = recto;
    }

    public ImageIcon getImgRecto() { return imgRecto; }

    public void setImgRecto(ImageIcon imgRecto) { this.imgRecto = imgRecto; }

    public String getVerso() {
        return verso;
    }

    public void setVerso(String verso) {
        this.verso = verso;
    }

    public ImageIcon getImgVerso() { return imgVerso; }

    public void setImgVerso(ImageIcon imgVerso) { this.imgVerso = imgVerso; }

    public Action[] getJetons() {
        return jetons;
    }

    public void setJetons(Action[] jetons) {
        this.jetons = jetons;
    }

    public String[] getActionsPossible() {
        return actionsPossible;
    }

    public void setActionsPossible(String[] actionsPossible) {
        this.actionsPossible = actionsPossible;
    }

    public String[] getActionsPossibleRetournée() {
        return actionsPossibleRetournée;
    }

    public void setActionsPossibleRetournée(String[] actionsPossibleRetournée) { this.actionsPossibleRetournée = actionsPossibleRetournée; }


    //Nouvelle instance de classe
    TraitementIcon tIcon = new TraitementIcon();
    Random random = new Random();
    //permet de transferé la valeur des atributs de mrjack a action
    private Game game;
    public Action(Game game) {
        this.game = game;
    }

    //permet de transferé la valeur des atributs de alibi a action
    private Alibi alibi;
    public Action(Alibi alibi) {
        this.alibi = alibi;
    }


    public void initialiseJetons(){ //FINI
        Action jeton1 = new Action("getAlibi", tIcon.changeSize("image/actions/1recto.png",160,160),"holmes", tIcon.changeSize("image/actions/1verso.png",160,160));
        Action jeton2 = new Action("toby", tIcon.changeSize("image/actions/2recto.png",160,160), "watson",tIcon.changeSize("image/actions/2verso.png",160,160));
        Action jeton3 = new Action("rotation1",tIcon.changeSize("image/actions/3recto.png",160,160), "échange",tIcon.changeSize("image/actions/3verso.png",160,160));
        Action jeton4 = new Action("rotation2",tIcon.changeSize("image/actions/4recto.png",160,160), "joker",tIcon.changeSize("image/actions/4verso.png",160,160));
        setJetons(new Action[]{jeton1, jeton2, jeton3, jeton4});
    }


    public void échange(PanelBoard panelBoard){ //echange 2 district de place sans changer l'orientation FINI

        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelles districts veux tu échanger? (donner ses coordonnées ex: 12)");//rentrer le premier enter puis le deuxieme
        String districtChoisie1 = scanner.nextLine();
        int[] coordo1;
        coordo1 = new int[]{Integer.valueOf(districtChoisie1.substring(0, 1)), Integer.valueOf(districtChoisie1.substring(1, 2))};

        String districtChoisie2 = scanner.nextLine();
        int[] coordo2;
        coordo2 = new int[]{Integer.valueOf(districtChoisie2.substring(0, 1)), Integer.valueOf(districtChoisie2.substring(1, 2))};


        District tempo = panelBoard.getBoard()[coordo1[0]][coordo1[1]];

        panelBoard.getBoard()[coordo1[0]][coordo1[1]] = panelBoard.getBoard()[coordo2[0]][coordo2[1]];
        panelBoard.getBoard()[coordo2[0]][coordo2[1]] = tempo;
    }

    public void rotation(PanelBoard panelBoard){//rotate un district FINI
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle district veux tu tourner? (donner ses coordonnées ex: 12)");
        String districtChoisie = scanner.nextLine();
        int[] coordo1;
        coordo1 = new int[]{Integer.valueOf(districtChoisie.substring(0, 1)), Integer.valueOf(districtChoisie.substring(1, 2))};

        System.out.println("Dans quelle direction veux tu que la pointe du T soit? (donner un char de type N E S O)");
        String direction = scanner.nextLine();
        char dir = direction.charAt(0);

        int a; //converti la direction en int, N = 0, E = 1, S = 2, Ouest = 3, c'est le bout du T dans cette direction
        switch (dir) {
            case 'N':
                a = 0;
                break;
            case 'E':
                a = 1;
                break;
            case 'S':
                a = 2;
                break;
            case 'O':
                a = 3;
                break;
            default:
                a = 4;
        }
        panelBoard.getBoard()[coordo1[0]][coordo1[1]].setOrientation(a);
    }
/*
    public void alibi(Pioche pioche){ //pioche 1 carte alibi et fait l'action necessaire
        Alibi cartePioché = pioche.draw1Carte();
        if (game.currentPlayer.getName() == "Enqueteur"){
            System.out.println(cartePioché.getName());
        } else if (game.currentPlayer.getName() == "Mr. Jack"){
            System.out.println(cartePioché.getName());
            alibi.updateAlibiJack(cartePioché);
            System.out.println(alibi.nbSablierAlibi());
        }
    }
    */


    public void deplacementDetective(District detective, PanelBoard panelBoard){
        //bouge dans le sens des aiguille d'une montre de 1 ou 2 case
        int[] oldCoordDetective;
        int[] newCoordDetective = new int[2];
        oldCoordDetective = panelBoard.findPosition(detective);
        System.out.println("Veux-tu avancer de 1 ou 2 espaces dans le sens des aiguilles d'une montre ?"); // rentrer 1 ou 2
        Scanner scanner = new Scanner(System.in);
        String deplacement = scanner.nextLine();
        int a = Integer.valueOf(deplacement);
        for (int i = 0; i < positionDetectiveList.length; i++ ) {
            if (positionDetectiveList[i][0] == oldCoordDetective[0] && positionDetectiveList[i][1] == oldCoordDetective[1]){
                newCoordDetective = positionDetectiveList[i + a];
            }
        }
        panelBoard.getBoard()[oldCoordDetective[0]][oldCoordDetective[1]] = panelBoard.getBoard()[0][0];
        panelBoard.getBoard()[newCoordDetective[0]][newCoordDetective[1]] = detective;
    }

    public void deplacementDetective(District detective, int a, PanelBoard panelBoard){
        //bouge dans le sens des aiguille d'une montre de 1 ou 2 case
        int[] oldCoordDetective;
        int[] newCoordDetective = new int[2];
        oldCoordDetective = panelBoard.findPosition(detective);
        for (int i = 0; i < positionDetectiveList.length; i++ ) {
            if (positionDetectiveList[i][0] == oldCoordDetective[0] && positionDetectiveList[i][1] == oldCoordDetective[1]){
                newCoordDetective = positionDetectiveList[i + a];
            }
        }
        panelBoard.getBoard()[oldCoordDetective[0]][oldCoordDetective[1]] = panelBoard.getBoard()[0][0];
        panelBoard.getBoard()[newCoordDetective[0]][newCoordDetective[1]] = detective;
    }

    public void initialisePossibleAction(){// initialise les action possible aux 2 prochains tours FINI
        Random rd = new Random();
        boolean[] faceAction= new boolean[4];
        String[] sortieEnqueteur = new String[0];
        String[] sortieJack = new String[0];
        for (int i = 0; i < faceAction.length; i++) {
            faceAction[i] = rd.nextBoolean();
            sortieEnqueteur = Arrays.copyOf(sortieEnqueteur, sortieEnqueteur.length + 1);// on crée une copie qui ecrase l'originale et qui est plus longue de 1 (append en python)
            sortieJack = Arrays.copyOf(sortieJack, sortieJack.length + 1);
            if (faceAction[i]){
                sortieEnqueteur[sortieEnqueteur.length - 1] =jetons[i].getRecto();
                sortieJack[sortieJack.length - 1] =jetons[i].getVerso();
            } else {
                sortieEnqueteur[sortieEnqueteur.length - 1] =jetons[i].getVerso();
                sortieJack[sortieJack.length - 1] =jetons[i].getRecto();
            }
        }
        actionsPossible = sortieEnqueteur;
        actionsPossibleRetournée = sortieJack;
    }

    public void printActionPossible(){ //print les actions possible au tour impair FINI
        System.out.println();
        for (int i = 0; i < actionsPossible.length-1; i++){
            System.out.print(actionsPossible[i] + "\t");
        }
        System.out.println(actionsPossible[actionsPossible.length-1]);
    }

    public void printActionPossibleRetournée(){ //print les actions possible au tour pair FINI
        System.out.println();
        for (int i = 0; i < actionsPossibleRetournée.length-1; i++){
            System.out.print(actionsPossibleRetournée[i] + "\t");
        }
        System.out.println(actionsPossibleRetournée[actionsPossibleRetournée.length-1]);
    }

    public void updateActionPossible(String actionUtilisé){ //enleve l'action utilisé des actions possible au tour impair FINI
        String[] newPioche = new String[0];
        for(int i = 0; i < actionsPossible.length; i++){
            if(!(Objects.equals(actionsPossible[i], new String(actionUtilisé)))){
                newPioche = Arrays.copyOf(newPioche, newPioche.length + 1);// append en python
                newPioche[newPioche.length - 1] = actionsPossible[i];
            }
        }
        setActionsPossible(newPioche);
    }

    public void updateActionPossibleRetournée(String actionUtilisé){  //enleve l'action utilisé des actions possible au tour pair FINI
        String[] newPioche = new String[0];
        for(int i = 0; i < actionsPossibleRetournée.length; i++){
            if(!(Objects.equals(actionsPossibleRetournée[i], new String(actionUtilisé)))){
                newPioche = Arrays.copyOf(newPioche, newPioche.length + 1);// append en python
                newPioche[newPioche.length - 1] = actionsPossibleRetournée[i];
            }
        }
        setActionsPossibleRetournée(newPioche);
    }

    public String chooseAction(){ //demande au joueur de rentrer son choix d'action, return l'action choisie FINI
        System.out.println();
        System.out.println("Quelle action choisi-tu ?");
        Scanner scanner = new Scanner(System.in);
        String actionChoisi = scanner.nextLine();
        return actionChoisi;
    }
}
