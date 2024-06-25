import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {
    private List<Movable> organisms;

    public Herd() {
        this.organisms = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        this.organisms.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable org: this.organisms) {
            org.move(dx, dy);
        }
    }

    public String toString() {
        String position = "";

        for (Movable org : this.organisms) {
            position += org.toString() + "\n";
        }

        return position;
    }
}