package rocks.thiscoder;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static void main(String args[]) {
        List<Square> squares = new ArrayList<Square>(40);
        for(int i = 0; i < 40; i++) {
            squares.add(new Square(i));
        }

        Square firstSquare = squares.get(0);
        List<Player> players = new ArrayList<Player>(4);
        players.add(new Player("A", firstSquare));
        players.add(new Player("B", firstSquare));
        players.add(new Player("C", firstSquare));
        players.add(new Player("D", firstSquare));

        Board board = new Board(squares, players);

        for(int i = 0; i < 500; i++) {
            board.play();
        }

        for(int i = 0; i < 40; i++) {
            Square square = squares.get(i);
            String output = String.valueOf("Square " + square.getLocation()) + " had " + square.getCount() + " visits.";
            System.out.println(output);
        }
    }
}
