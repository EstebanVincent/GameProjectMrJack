package InterfaceConsole;

import java.util.*;

public class Pioche extends Alibi {
    //Attributs
    private Alibi[] pioche = new Alibi[9];

    //Getters and Setters
    public Alibi[] getPioche() {
        return pioche;
    }

    public void setPioche(Alibi[] piocheAlibi) {
        this.pioche = piocheAlibi;
    }

    //Méthodes
    public void initialisePioche(){ //crée la pioche

        Alibi Mme = new Alibi("Madame",2);
        Alibi SGT = new Alibi("SGT_Goodley",0);
        Alibi JB = new Alibi("Jeremy_Bert",1);
        Alibi WG = new Alibi("William_Gull",1);
        Alibi Ms = new Alibi("Miss_Stealthy",1);
        Alibi JS = new Alibi("John_Smith",1);
        Alibi Insp = new Alibi("Insp._Lestrade",0);
        Alibi JP = new Alibi("John_Pizer",1);
        Alibi JL = new Alibi("Joseph_Lane",1);

        //la pioche est diférente a chaque partie
        Alibi[] pioche1 = new Alibi[] {Mme, SGT, JB, WG, Ms, JS, Insp, JP, JL};
        List<Alibi> list = Arrays.asList(pioche1);
        Collections.shuffle(list);
        list.toArray(pioche1);

        setPioche(pioche1);
    }

    public void updatePiocheAlibi(Alibi cartePioché){ //update la pioche en enlevant la carte pioché
        Alibi[] newPioche = new Alibi[0];
        for(int i = 0; i < pioche.length; i++){
            if(pioche[i] != cartePioché){
                newPioche = Arrays.copyOf(newPioche, newPioche.length + 1);// append en python
                newPioche[newPioche.length - 1] = pioche[i];
            }
        }
        setPioche(newPioche);
    }

    public Alibi draw1Carte(){//return la carte pioché et update la pioche
        Random random = new Random();
        int rand = random.nextInt((pioche.length-1) - 0 + 1);//int random entre 0 et la longueur de piocheAlibi-1
        Alibi tempo = pioche[rand];
        updatePiocheAlibi(pioche[rand]);//la carte pioché n'est plus dans la pioche
        return tempo;
    }
/*
    public static void main(String[] args) {
        Pioche p = new Pioche();
        p.initialisePioche();
        Alibi a = p.draw1Carte();
        System.out.printf(a.toString());
    }

 */
}
