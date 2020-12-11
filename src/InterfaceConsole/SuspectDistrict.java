package InterfaceConsole;

import InterfaceUtilisateur.Affichage.PanelBoard;

import javax.swing.*;
import java.util.Arrays;
import static java.lang.Math.abs;

public class SuspectDistrict extends District{


    public SuspectDistrict(){

    }

    //permet de transferé la valeur des atributs de mrjack a suspectDis


    public String[] see(District districtDetective, PanelBoard panelBoard){ //renvoi en String[] qui tu vois
        int[] coord = panelBoard.findPosition(districtDetective);
        int regard = districtDetective.getOrientation(); //N = 0, E = 1, S = 2, Ouest = 3

        String[] sortie = new String[0];


        boolean visionBloque = false;
        int[] move = new int[2];


        //on défini les movemments a faire sur les districts a partir de l'observateur
        if(regard == 0){
            move[0] = -1;
            move[1] = 0;
        } else if (regard == 1){
            move[0] = 0;
            move[1] = 1;
        } else if (regard == 2){
            move[0] = 1;
            move[1] = 0;
        } else {
            move[0] = 0;
            move[1] = -1;
        }

        //partie principale de la fonction
        int i = 1;
        do {
            District observé = panelBoard.getBoard()[coord[0]+move[0]*i][coord[1]+move[1]*i];//la case observé les *i pour passer a la case suivante si on vois au travers
            if(observé.getOrientation() == regard){ //on regarde le mur directement (dos du T)
                visionBloque = true; //la boucle s'arete
            } else if (abs(observé.getOrientation()-regard) == 2) { //on regarde la base du T
                if(getFaceVisible() == 1){ //si face suspect
                    sortie = Arrays.copyOf(sortie, sortie.length + 1);// on crée une copie qui écrase l'originale et qui est plus longue de 1 (append en python)
                    sortie[sortie.length - 1] = observé.getNom(); //On rajoute le nom du personnage dans la case car il est visible
                }
                visionBloque = true; // la fin du T bloque la vision, la boucle s'arrête
            } else if (observé.getNom() == "Joseph Lane" && getFaceVisible() == 0){//exception si case coté vide car pas en forme de T mais X
                i += 1;
            }  else { //on voit a travers le T
                if(getFaceVisible() == 1){//si face suspect
                    sortie = Arrays.copyOf(sortie, sortie.length + 1); //append en python
                    sortie[sortie.length - 1] = observé.getNom(); //On rajoute le nom du personnage dans la case car il est visible
                    i += 1;
                }//si face vide
                i += 1;
            }
        } while(!visionBloque && i != 4); //cas i si on peut voir a travers le plateau complet afin que la boucle s'arete
        return sortie;
    }

    //fini il me semble, test a faire
    public String[] see(String coord0bservateur, int orientationRegard, PanelBoard panelBoard){ //renvoi en String[] qui tu vois
        //N = 0, E = 1, S = 2, Ouest = 3
        //en entree les coordonnee en string ex : 12, 22, et dir du regard en int
        String[] sortie = new String[0];
        int[] observ = {Integer.valueOf(coord0bservateur.substring(0, 1)), Integer.valueOf(coord0bservateur.substring(1, 2))};


        boolean visionBloque = false;
        int[] move = new int[2];


        //on défini les movemments a faire sur les districts a partir de l'observateur
        if(orientationRegard == 0){
            move[0] = -1;
            move[1] = 0;
        } else if (orientationRegard == 1){
            move[0] = 0;
            move[1] = 1;
        } else if (orientationRegard == 2){
            move[0] = 1;
            move[1] = 0;
        } else {
            move[0] = 0;
            move[1] = -1;
        }

        //partie principale de la fonction
        int i = 1;
        do {
            District observé = panelBoard.getBoard()[observ[0]+move[0]*i][observ[1]+move[1]*i];//la case observé les *i pour passer a la case suivante si on vois au travers
            if(observé.getOrientation() == orientationRegard){ //on regarde le mur directement (dos du T)
                visionBloque = true; //la boucle s'arete
            } else if (abs(observé.getOrientation()-orientationRegard) == 2) { //on regarde la base du T
                if(getFaceVisible() == 1){ //si face suspect
                    sortie = Arrays.copyOf(sortie, sortie.length + 1);// on crée une copie qui écrase l'originale et qui est plus longue de 1 (append en python)
                    sortie[sortie.length - 1] = observé.getNom(); //On rajoute le nom du personnage dans la case car il est visible
                }
                visionBloque = true; // la fin du T bloque la vision, la boucle s'arrête
            } else if (observé.getNom() == "Joseph Lane" && getFaceVisible() == 0){//exception si case coté vide car pas en forme de T mais X
                i += 1;
            }  else { //on voit a travers le T
                if(getFaceVisible() == 1){//si face suspect
                    sortie = Arrays.copyOf(sortie, sortie.length + 1); //append en python
                    sortie[sortie.length - 1] = observé.getNom(); //On rajoute le nom du personnage dans la case car il est visible
                    i += 1;
                }//si face vide
                i += 1;
            }
        } while(!visionBloque && i != 4); //cas i si on peut voir a travers le plateau complet afin que la boucle s'arete
        return sortie;
    }
}
