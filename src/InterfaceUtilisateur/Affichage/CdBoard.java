package InterfaceUtilisateur.Affichage;

public enum CdBoard {
    A1(200,200),A2(200,400),A3(200,600),
    B1(400, 200),B2(400, 400),B3(400, 600),
    C1(600, 200),C2(600, 400),C3(600, 600),

    DIM(200,200);

    private final int ordonnee;
    private final int abscisse;

    private CdBoard(int abscisse, int ordonnee){
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public int getOrd() { return ordonnee; }

    public int getAbs() { return abscisse; }
}
