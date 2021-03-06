package Tests;

import Model.Card;
import Model.Deck;
import Model.Suit;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Brandon on 2015-12-04.
 */
public class DeckTest {
    private Deck test;

    @Before
    public void setUp() throws Exception {
        test = new Deck();
    }

    @Test
    public void testInit() {
        List<Card> deck = test.deal(52);
        assertEquals(deck.size(), 52);
        assertEquals(deck.get(0), new Card(1, Suit.DIAMOND));
        assertEquals(deck.get(51), new Card(13, Suit.SPADE));
        try {
            test.deal(1);
            fail();
        } catch (Exception e) {

        }
    }

    @Test
    public void testShuffle() {
        test.shuffle();
        test.deal(52);
        test.shuffle();
        test.deal(52);
    }
}