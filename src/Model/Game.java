package Model;

import Input.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Brandon on 2015-11-30.
 */
public class Game {
    private List<Player> players;
    private Player bigBlind;
    private Player littleBlind;
    private Player current;
    private Player end;
    private Deck deck;

    public Game() {
        System.out.println("Welcome to Texas Hold'em Poker. If you would like to quit at any time, type 'q'");
        players = new ArrayList<>();
        initPlayers();
        deck = new Deck();

        while (!isOver()) {
            deck.shuffle();
            dealHands();
        }
    }

    private void dealHands() {
        for (Player next : players) {
            next.setHand(deck.deal(2));
        }
    }

    private void initPlayers() {
        int num = UserInput.inputNum("Enter the number of players:", 2, 9);
        for (int i = 0; i < num; i++) {
            players.add(new Player());
        }
    }

    public boolean isOver() {
        int count = 0;
        Player winner = null;
        for (Player next : players) {
            if (!next.isOver()) {
                count++;
                winner = next;
            }
        }
        if (count == 1) {
            System.out.printf("%s has won the game.", winner.toString());
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
