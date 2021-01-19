package InterfaceUtilisateur.Affichage;

import InterfaceUtilisateur.TraitementIcon;

import javax.swing.*;

public enum Images {
    Madame(1,TraitementIcon.changeSize("image/districts/faceSus/Madame.png",200,200),TraitementIcon.changeSize("image/districts/faceVide/common.png",200,200)),
    SGT_Goodley(1,TraitementIcon.changeSize("image/districts/faceSus/Sgt_Goodley.png",200,200),TraitementIcon.changeSize("image/districts/faceVide/common.png",200,200)),
    Jeremy_Bert(1,TraitementIcon.changeSize("image/districts/faceSus/Jeremy_Bert.png",200,200),TraitementIcon.changeSize("image/districts/faceVide/common.png",200,200)),
    William_Gull(1,TraitementIcon.changeSize("image/districts/faceSus/William_Gull.png",200,200),TraitementIcon.changeSize("image/districts/faceVide/common.png",200,200)),
    Miss_Stealthy(1,TraitementIcon.changeSize("image/districts/faceSus/Miss_Stealthy.png",200,200),TraitementIcon.changeSize("image/districts/faceVide/common.png",200,200)),
    John_Smith(1,TraitementIcon.changeSize("image/districts/faceSus/John_Smith.png",200,200),TraitementIcon.changeSize("image/districts/faceVide/common.png",200,200)),
    Insp_Lestrade(1,TraitementIcon.changeSize("image/districts/faceSus/Insp_Lestrade.png",200,200),TraitementIcon.changeSize("image/districts/faceVide/common.png",200,200)),
    John_Pizer(1,TraitementIcon.changeSize("image/districts/faceSus/John_Pizer.png",200,200),TraitementIcon.changeSize("image/districts/faceVide/common.png",200,200)),
    Joseph_Lane(1,TraitementIcon.changeSize("image/districts/faceSus/Joseph_Lane.png",200,200),TraitementIcon.changeSize("image/districts/faceVide/Joseph_Lane.png",200,200)),

    Action1(TraitementIcon.changeSize("image/actions/1recto.png",160,160),TraitementIcon.changeSize("image/actions/1verso.png",160,160)),
    Action2(TraitementIcon.changeSize("image/actions/2recto.png",160,160),TraitementIcon.changeSize("image/actions/2verso.png",160,160)),
    Action3(TraitementIcon.changeSize("image/actions/3recto.png",160,160),TraitementIcon.changeSize("image/actions/3verso.png",160,160)),
    Action4(TraitementIcon.changeSize("image/actions/4recto.png",160,160),TraitementIcon.changeSize("image/actions/4verso.png",160,160)),
    ;



    private int orientation; // a set random apres
    private int faceVisible; //1 recto, 0 verso
    private  ImageIcon recto;
    private  ImageIcon verso;

    private Images(int faceVisible, ImageIcon recto, ImageIcon verso) { //constructeur pour les districts, l'orientation a determiner random
        this.faceVisible = faceVisible;
        this.recto = recto;
        this.verso = verso;
    }
    private Images(ImageIcon recto, ImageIcon verso) { //constructeur pour les jetons actions, la face visible a determiner random
        this.recto = recto;
        this.verso = verso;
    }


    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getFaceVisible() {
        return faceVisible;
    }

    public void setFaceVisible(int faceVisible) {
        this.faceVisible = faceVisible;
    }

    public ImageIcon getRecto() {
        return recto;
    }

    public void setRecto(ImageIcon recto) {
        this.recto = recto;
    }

    public ImageIcon getVerso() {
        return verso;
    }

    public void setVerso(ImageIcon verso) {
        this.verso = verso;
    }
}
