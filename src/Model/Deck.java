package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Brandon on 2015-12-04.
 */
public class Deck {
    public static final int SIZE = 52;

    private Card[] cards;
    int index;

    public Deck() {
        cards = new Card[52];
        initCards();
    }

    private void initCards() {
        for (int i = 0; i < SIZE; i++) {
            cards[i] = new Card(i / 4 + 1, Suit.values()[i % 4]);
        }
        shuffle();
    }

    // Takes back all the cards that were dealt and shuffles the deck
    public void shuffle() {
        index = 0;
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

    public List<Card> deal(int num) {
        List<Card> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(cards[index]);
            index++;
        }
        return list;
    }
}
