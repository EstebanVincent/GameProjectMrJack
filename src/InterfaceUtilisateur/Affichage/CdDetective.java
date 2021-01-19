package InterfaceUtilisateur.Affichage;

public enum CdDetective {
    A(200, 200),B(200, 400),C(200, 600),
    D(400, 200),E(400, 400),F(400, 600),
    G(600, 200),H(600, 400),I(600, 600),
    J(600, 200),K(600, 400),L(600, 600),

    DIM(200,200);

    private final int ordonnee;
    private final int abscisse;

    private CdDetective(int abscisse, int ordonnee){
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public int getOrd() { return ordonnee; }

    public int getAbs() { return abscisse; }
}
