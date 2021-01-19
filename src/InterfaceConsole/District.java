package InterfaceConsole;

import InterfaceUtilisateur.TraitementIcon;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class District { //nom en foction du perso dessus
    //Attributs
    private String nom;
    private int faceVisible; //1 face suspect 0 face vide
    private int orientation; //N = 0, E = 1, S = 2, Ouest = 3, c'est le bout du T dans cette direction

    private ImageIcon faceSus;
    private ImageIcon faceVide;

    private District[][] baseDeDonnee; //ne pas modifier !!!!!!!!!!

    //Constructeurs
    public District(){ }

    public District(String nom, int orientation, int faceVisible, ImageIcon faceSus, ImageIcon faceVide) {
        this.setNom(nom);
        this.setOrientation(orientation);
        this.setFaceVisible(faceVisible);
        this.setFaceSus(faceSus);
        this.setFaceVide(faceVide);
    }

    public District(String nom, ImageIcon faceSus) {
        this.setNom(nom);
        this.setFaceSus(faceSus);
    }

    //Getters and Setters

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public int getFaceVisible() {
        return faceVisible;
    }

    public void setFaceVisible(int faceVisible) {
        this.faceVisible = faceVisible;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public ImageIcon getFaceSus() {
        return faceSus;
    }

    public void setFaceSus(ImageIcon faceSus) {
        this.faceSus = faceSus;
    }

    public ImageIcon getFaceVide() { return faceVide; }

    public void setFaceVide(ImageIcon faceVide) { this.faceVide = faceVide; }

    public District[][] getBaseDeDonnee() { return baseDeDonnee; }

    public void setBaseDeDonnee(District[][] baseDeDonnee) { this.baseDeDonnee = baseDeDonnee; }

    //Nouvelle instance de classe
    TraitementIcon tIcon = new TraitementIcon();
    Random random = new Random();

    //Méthodes

    public void setUp(){
        int[] orienté = randomIntArray(9,0,3);

        District Mme = new District("Madame",orienté[0],1,tIcon.changeSize("image/districts/faceSus/Madame.png",160,160),tIcon.changeSize("image/districts/faceVide/common.png",160,160));
        District SGT = new District("SGT_Goodley",orienté[1],1, tIcon.changeSize("image/districts/faceSus/SGT_Goodley.png",160,160),tIcon.changeSize("image/districts/faceVide/common.png",160,160));
        District JB = new District("Jeremy_Bert",orienté[2],1, tIcon.changeSize("image/districts/faceSus/Jeremy_Bert.png",160,160),tIcon.changeSize("image/districts/faceVide/common.png",160,160));
        District WG = new District("William_Gull",orienté[3],1, tIcon.changeSize("image/districts/faceSus/William_Gull.png",160,160),tIcon.changeSize("image/districts/faceVide/common.png",160,160));
        District Ms = new District("Miss_Stealthy",orienté[4],1, tIcon.changeSize("image/districts/faceSus/Miss_Stealthy.png",160,160),tIcon.changeSize("image/districts/faceVide/common.png",160,160));
        District Gs = new District("John_Smith",orienté[5],1, tIcon.changeSize("image/districts/faceSus/John_Smith.png",160,160),tIcon.changeSize("image/districts/faceVide/common.png",160,160));
        District Insp = new District("Insp._Lestrade",orienté[6],1, tIcon.changeSize("image/districts/faceSus/Insp_Lestrade.png",160,160),tIcon.changeSize("image/districts/faceVide/common.png",160,160));
        District JP = new District("John_Pizer",orienté[7],1, tIcon.changeSize("image/districts/faceSus/John_Pizer.png",160,160),tIcon.changeSize("image/districts/faceVide/common.png",160,160));
        District JL = new District("Joseph_Lane",orienté[8],1, tIcon.changeSize("image/districts/faceSus/Joseph_Lane.png",160,160),tIcon.changeSize("image/districts/faceVide/Joseph_Lane.png",160,160)); // spécial si retournéé croix preciser dans suspect district

        //des district speciaux avec les inspecteurs dessus, regles diff
        District Holmes = new District("Holmes",tIcon.changeSize("image/detectives/Holmes.png",160,160));
        District Watson = new District("Watson",tIcon.changeSize("image/detectives/Watson.png",160,160));
        District Toby = new District("Toby",tIcon.changeSize("image/detectives/Toby.png",160,160));

        //districtes juste case ou y'as rien
        District Vide = new District("Vide",tIcon.changeSize("image/void.png",160,160));

        District[][] bdd = setUpBDD(new District[]{Mme, SGT, JB, WG, Ms, Gs, Insp, JP, JL}, new District[]{Holmes, Watson, Toby}, Vide);

        setBaseDeDonnee(bdd);
    }

    public int[] randomIntArray(int length, int mini, int maxi){
        //on créer un tableau d'int random entre mini et maxi de length n
        int[] retour = new int[length];
        for(int i = 0; i< length; i++){
            int rand = random.nextInt(maxi - mini + 1) + mini;
            retour[i] = rand;
        }
        return retour;
    }

    public District[][] setUpBDD(District[] personnages, District[] detectives, District caseVide ){
        //On shuffle le tableau des personnages
        List<District> list1 = Arrays.asList(personnages);
        Collections.shuffle(list1);
        list1.toArray(personnages);

        //on cree un tableau de 3 lignes 9 colones
        District[][] bdd = new District[3][9];

        for(int i = 0; i < bdd.length; i++){
            int a = 0; //indice pour parcourir perso
            for (int j = 0; j < bdd[i].length; j++){
                if(i == 0){
                    bdd[i][j] = personnages[j];
                    a = a+1; //passe au prochain perso
                } else if(i == 1) {
                    bdd[i][j] = detectives[j];
                    a = a+1; //passe au prochain detect
                    if(a == 3){ //on a assigné les détectives, le reste reste null
                        break;
                    }
                } else {
                    bdd[i][j] = caseVide;
                    break; //on a  assigné vide, le reste reste null
                }

            }
        }
        return bdd;
    }
}

