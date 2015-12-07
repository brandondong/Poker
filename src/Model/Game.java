package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Brandon on 2015-11-30.
 */
public class Game {
    public static final String ERROR_MESSAGE = "Invalid input.";

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
        }
    }

    public void initPlayers() {
        int num = inputNum("Enter the number of players:", 2, 9);
        for (int i = 0; i < num; i++) {
            players.add(new Player(inputString("Enter the player name:")));
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

    private String inputString(String prompt) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(prompt);
            String s = sc.nextLine();
            if (s.equals("q")) {
                System.out.println("Thanks for playing.");
                System.exit(1);
            } else if (!s.equals("")) {
                return s;
            } else {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

    private int inputNum(String prompt, int low, int high) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(prompt);
            String s = sc.nextLine();
            if (s.equals("q")) {
                System.out.println("Thanks for playing.");
                System.exit(1);
            }
            try {
                int i = Integer.valueOf(s);
                if (i >= low && i <= high) {
                    return i;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
