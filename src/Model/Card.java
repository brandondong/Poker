package Model;

import java.util.List;

/**
 * Created by Brandon on 2015-11-29.
 */
public class Card {
    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public static int scoreHand(List<Card> flop, List<Card> hand) {
        Card c1;
        Card c2;
        if (hand.get(0).getValue() > hand.get(1).getValue()) {
            c1 = hand.get(0);
            c2 = hand.get(1);
        } else {
            c1 = hand.get(1);
            c2 = hand.get(0);
        }

        if (false) {
            return 1;
        } else {
            return c1.getValue() * 100 + c2.getValue();
        }
    }

    private static int matchPairs(List<Card> flop, Card c) {
        int count = 0;
        for (Card next : flop) {
            if (c.getValue() == next.getValue()) {
                count++;
            }
        }
        return count;
    }

    private static int matchSuit(List<Card> flop, Card c) {
        int count = 0;
        for (Card next : flop) {
            if (c.getSuit() == next.getSuit()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        String suitString = suit.toString();
        if (!suit.equals(Suit.CLOVER)) {
            suitString += "S";
        }
        String face;
        if (value == 1) {
            face = "ACE";
        } else if (value <= 10) {
            face = String.valueOf(value);
        } else if (value == 11) {
            face = "JACK";
        } else if (value == 12) {
            face = "QUEEN";
        } else {
            face = "KING";
        }
        return face + " OF " + suitString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (value != card.value) return false;
        return suit == card.suit;

    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (suit != null ? suit.hashCode() : 0);
        return result;
    }
}
