package Main;

import Model.Game;

/**
 * Created by Brandon on 2015-12-14.
 */
public class Main {

    public static void main(String[] args) {
        Game g = new Game();
        while (!g.isOver()) {
            g.handleRound();
        }
    }
}
