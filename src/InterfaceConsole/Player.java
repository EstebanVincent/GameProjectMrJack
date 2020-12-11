package InterfaceConsole;

public class Player {
    //Attributs
    private String name;
    private Player[] players;

    //Constructeurs
    public Player() {this("default");}
    public Player(String name) {
        this.setName(name);
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player[] getPlayers(){return players;}

    public void setPlayers(Player[] players) { this.players = players; }

    //Méthodes
    public void initialiseName(){ //initialise les players
        Player jack = new Player("Mr. Jack");
        Player enqueteur = new Player("Enqueteur");
        setPlayers(new Player[]{jack, enqueteur});
    }



}
