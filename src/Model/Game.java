package Model;

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
        deck.shuffle();
    }

    public void initPlayers() {
        System.out.print("Enter the number of players: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            players.add(new Player(inputString("Enter the player name:")));
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
                System.out.println("Invalid input.");
            }
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
