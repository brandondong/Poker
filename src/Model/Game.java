package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Brandon on 2015-11-30.
 */
public class Game {
    private List<Player> players;
    private Player bigBlind;
    private Player littleBlind;
    private Player current;
    private Card[] cards;
    private Player end;

    public Game(List<String> names) {
        players = new ArrayList<>();
        for (String next : names) {
            players.add(new Player(next));
        }

        cards = new Card[52];
        initCards();
    }

    private void initCards() {
        for (int i = 0; i < 52; i++) {
            cards[i] = new Card(i / 4 + 1, Suit.values()[i % 4]);
        }
    }

    public void shuffle() {
        shuffleHelper(51);
    }

    private void shuffleHelper(int i) {
        if (i != 0) {
            shuffleHelper(i - 1);
            swap(i, ThreadLocalRandom.current().nextInt(0, i + 1));
        }
    }

    private void swap(int i1, int i2) {
        Card temp = cards[i1];
        cards[i1] = cards[i2];
        cards[i2] = temp;

    }

    public Card[] getCards() {
        return cards;
    }
}
