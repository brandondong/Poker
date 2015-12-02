package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 2015-11-30.
 */
public class Game {
    private List<Player> players;
    private Player bigBlind;
    private Player littleBlind;
    private Player current;
    private List<Card> cards;
    private Player end;

    public Game(List<String> names) {
        players = new ArrayList<>();
        cards = new ArrayList<>();
        for (String next : names) {
            players.add(new Player(next));
        }
        initCards();
    }

    private void initCards() {
        for (int i = 1; i <= 13; i++) {
            for (Suit next : Suit.values()) {
                cards.add(new Card(i, next));
            }
        }
    }
}
