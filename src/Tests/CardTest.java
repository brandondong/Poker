package Tests;

import Model.Card;
import Model.Suit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Brandon on 2015-12-01.
 */
public class CardTest {
    private Card test;

    @Before
    public void setUp() throws Exception {
        test = new Card(2, Suit.DIAMOND);
    }

    @Test
    public void testPrint() {
        assertEquals("2 OF DIAMONDS", test.toString());
    }
}