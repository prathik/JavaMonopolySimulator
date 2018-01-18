package rocks.thiscoder;

public class Player {
    private final String name;
    private Square currentSquare;

    Player(String name, Square firstSquare) {
        this.name = name;
        this.currentSquare = firstSquare;
    }

    public String getName() {
        return name;
    }

    Square getCurrentSquare() {
        return currentSquare;
    }

    void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
