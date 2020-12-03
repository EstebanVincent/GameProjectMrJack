package InterfaceUtilisateur;

import InterfaceConsole.Game;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        game.play();
    }
}
