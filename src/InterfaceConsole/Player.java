package InterfaceConsole;

public class Player {
    //Attributs
    private String name;
    private int role; //0 detective, 1 jack

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

    public int getRole() { return role; }

    public void setRole(int role) { this.role = role; }

    public Player[] getPlayers(){return players;}

    public void setPlayers(Player[] players) { this.players = players; }


    public Player(String name, int role) {
        this.name = name;
        this.role = role;
    }

    //Méthodes
    public void initialiseName(){ //initialise les players
        Player jack = new Player("Jack");
        Player detective = new Player("Detective");
        setPlayers(new Player[]{jack, detective});
    }



}
