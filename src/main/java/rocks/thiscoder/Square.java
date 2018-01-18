package rocks.thiscoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores details about the players on the monopoly board.
 */
public class Square {
    private final int location;
    private List<Player> players = new ArrayList<Player>();
    private int count = 0;

    public Square(int location) {
        this.location = location;
    }

    void addPlayer(Player player) {
        count++;
        players.add(player);
        player.getCurrentSquare().removePlayer(player);
        player.setCurrentSquare(this);
    }

    private void removePlayer(Player player) {
        players.remove(player);
    }

    int getLocation() {
        return location;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Square{" +
                "location=" + location +
                ", players=" + players +
                ", count=" + count +
                '}';
    }
}
