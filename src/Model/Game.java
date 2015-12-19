package Model;

import Input.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Brandon on 2015-11-30.
 */
public class Game {
    public static final int MAX_PLAYERS = 9;

    private List<Player> players;
    private int bigBlind;
    private int smallBlind;
    private int current;
    private int end;
    private Deck deck;
    private int pot;
    private List<Card> flop;

    public Game() {
        System.out.printf("Welcome to Texas Hold'em Poker. If you would like to quit at any time, type '%s'.\n", UserInput.EXIT_STRING);
        players = new ArrayList<>();
        initPlayers();
        deck = new Deck();
        initBlinds();
    }

    public void handleRound() {
        deck.shuffle();
        dealHands();
        runRound();
        nextBlinds();
    }

    private void runRound() {
        pot = 0;
        flop = new ArrayList<>();
        for (Round next : Round.values()) {
            if (next.equals(Round.FLOP)) {
                flop.addAll(deck.deal(3));
            } else if (next.equals(Round.TURN) || next.equals(Round.RIVER)) {
                flop.addAll(deck.deal(1));
            }
            runBetting();
            findWinner();
        }
    }

    private void runBetting() {
        while (true) {
            pot = players.get(current).bet(pot, flop);
            nextCurrent();
            if (current == end) {
                return;
            }
        }
    }

    private void findWinner() {

    }

    private void dealHands() {
        for (Player next : players) {
            next.setHand(deck.deal(2));
        }
    }

    private void initPlayers() {
        int num = UserInput.inputNum("Enter the number of players:", 2, MAX_PLAYERS);
        for (int i = 0; i < num; i++) {
            players.add(new Player());
        }
    }

    private void initBlinds() {
        bigBlind = players.size() - 1;
        smallBlind = bigBlind - 1;
        current = 0;
        end = current;
    }

    private void nextBlinds() {
        while (true) {
            bigBlind = (bigBlind + 1) % players.size();
            if (!players.get(bigBlind).isOver()) {
                break;
            }
        }
        while (true) {
            smallBlind = (smallBlind + 1) % players.size();
            if (!players.get(smallBlind).isOver()) {
                break;
            }
        }
        current = bigBlind;
        nextCurrent();
        end = current;
    }

    private void nextCurrent() {
        while (true) {
            current = (current + 1) % players.size();
            if (!players.get(current).isOver()) {
                return;
            }
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
}
