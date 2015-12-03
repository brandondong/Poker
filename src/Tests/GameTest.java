package Tests;

import Model.Card;
import Model.Game;
import Model.Suit;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Brandon on 2015-12-02.
 */
public class GameTest {
    private Game test;

    @Before
    public void setUp() throws Exception {
        test = new Game(Arrays.asList("Test Player 1", "Test Player 2", "Test Player 3"));
    }

    @Test
    public void testCardInit() {
        Card[] deck = test.getCards();
        assertEquals(new Card(1, Suit.DIAMOND), deck[0]);
        assertEquals(new Card(13, Suit.SPADE), deck[51]);
    }
}