package Model;

import Input.UserInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 2015-11-29.
 */
public class Player {
    public static final int STARTING_BALANCE = 100;

    private String name;
    private int balance;
    private List<Card> hand;

    public Player() {
        name = UserInput.inputString("Enter the player name:");
        hand = new ArrayList<>();
        balance = STARTING_BALANCE;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isOver() {
        return balance == 0;
    }

    public int bet(int pot, List<Card> flop) {
        for (Card next : flop) {
            System.out.println(next);
        }
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return !(name != null ? !name.equals(player.name) : player.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
