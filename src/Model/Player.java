package Model;

/**
 * Created by Brandon on 2015-11-29.
 */
public class Player {
    public static final int STARTING_BALANCE = 100;

    private String name;
    private int balance;
    private Card card1;
    private Card card2;

    public Player(String name) {
        this.name = name;
        balance = STARTING_BALANCE;
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
