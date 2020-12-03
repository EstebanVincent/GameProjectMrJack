package InterfaceConsole;

public class Alibi {
    //Attributs
    private String name; //j'ai changer en String c'est mieux avec des nom pour les cartes
    private int sablier; //0 à 2

    //Constructeurs
    public Alibi(){this("Default",0);} //Constructeur par default

    public Alibi(String name, int sablier) { //constructeur pour les cartes Alibli
        this.setName(name);
        this.setSablier(sablier);
    }

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSablier() {
        return sablier;
    }

    public void setSablier(int sablier) {
        if (!(sablier == 0 || sablier == 1 || sablier == 2)){
            throw new RuntimeException("Sablier must be an int between 0 and 2");
        }
        this.sablier = sablier;
    }

    //Méthodes
    public String toString() {
        return String.format("La personnage sur la carte est %s avec %d sablier(s)",this.name, this.sablier);
    }
}
