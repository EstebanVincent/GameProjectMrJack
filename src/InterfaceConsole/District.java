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
    private int typeDistrict; //0 case vide, 1 case suspect, 2 case detective
    private int orientation; //N = 0, E = 1, S = 2, Ouest = 3, c'est le bout du T dans cette direction

    private ImageIcon faceSus;
    private ImageIcon faceVide;

    private District[][] baseDeDonnee; //ne pas modifier !!!!!!!!!!

    //Constructeurs
    public District(){ }

    public District(String nom, int orientation, int typeDistrict, int faceVisible, ImageIcon faceSus) {
        this.setNom(nom);
        this.setOrientation(orientation);
        this.setTypeDistrict(typeDistrict);
        this.setFaceVisible(faceVisible);
        this.setFaceSus(faceSus);
    }

    //Getters and Setters

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public int getTypeDistrict() {
        return typeDistrict;
    }

    public void setTypeDistrict(int typeDistrict) {
        this.typeDistrict = typeDistrict;
    }

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

    public District[][] getBaseDeDonnee() { return baseDeDonnee; }

    public void setBaseDeDonnee(District[][] baseDeDonnee) { this.baseDeDonnee = baseDeDonnee; }

    //Nouvelle instance de classe
    TraitementIcon tIcon = new TraitementIcon();
    Random random = new Random();

    //Méthodes

    public void setUp(){
        int[] orienté = randomIntArray(9,0,3);

        District Mme = new District("Madame",orienté[0],1,1,tIcon.changeSize("image/faceSus/Madame.png",160,160));
        District SGT = new District("SGT Goodley",orienté[1],1,1, tIcon.changeSize("image/faceSus/Sgt._Goodley.png",160,160));
        District JB = new District("Jeremy Bert",orienté[2],1,1, tIcon.changeSize("image/faceSus/Jeremy_Bert.png",160,160));
        District WG = new District("William Gull",orienté[3],1,1, tIcon.changeSize("image/faceSus/William_Gull.png",160,160));
        District Ms = new District("Miss Stealthy",orienté[4],1,1, tIcon.changeSize("image/faceSus/Miss_Stealthy.png",160,160));
        District Gs = new District("John Smith",orienté[5],1,1, tIcon.changeSize("image/faceSus/John_Smith.png",160,160));
        District Insp = new District("Insp. Lestrade",orienté[6],1,1, tIcon.changeSize("image/faceSus/Insp._Lestrade.png",160,160));
        District JP = new District("John Pizer",orienté[7],1,1, tIcon.changeSize("image/faceSus/John_Pizer.png",160,160));
        District JL = new District("Joseph Lane",orienté[8],1,1, tIcon.changeSize("image/faceSus/Joseph_Lane.png",160,160)); // spécial si retournéé croix preciser dans suspect district

        //des district speciaux avec les inspecteurs dessus, regles diff
        District Holmes = new District("Holmes",1,2,1,tIcon.changeSize("image/detective/holmes.png",160,160));
        District Watson = new District("Watson",1,2,1,tIcon.changeSize("image/detective/watson.png",160,160));
        District Toby = new District("Toby",1,2,1,tIcon.changeSize("image/detective/toby.png",160,160));

        //districtes juste case ou y'as rien
        District Vide = new District("Vide",1,0,1,tIcon.changeSize("image/void.png",160,160));

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

