package rocks.thiscoder;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private final List<Square> squares;
    private final List<Player> players;

    private int currentChanceOf = 0;

    Board(List<Square> squares, List<Player> players) {
        this.squares = squares;
        this.players = players;
    }

    private int rollDice() {
        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

    void play() {
        Player currentPlayer = players.get(currentChanceOf);
        int howMuchToMove = rollDice() + rollDice();
        Square moveToSquare = getSquare(currentPlayer, howMuchToMove);
        moveToSquare.addPlayer(currentPlayer);
        setChanceOf();
    }

    private void setChanceOf() {
        currentChanceOf = (currentChanceOf + 1) % 4;
    }

    private Square getSquare(Player p, int howMuchToMove) {
        Square playerCurrentSquare = p.getCurrentSquare();
        int location = playerCurrentSquare.getLocation();
        int newLocation = (location + howMuchToMove) % 40;
        return squares.get(newLocation);
    }
}
