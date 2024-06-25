public class Organism implements Movable {
    private int posX;
    private int posY;

    public Organism(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    @Override
    public void move(int dx, int dy) {
        this.posX += dx;
        this.posY += dy;
    }

    public String toString() {
        return "x: " + this.posX + "; y: " + this.posY;
    }
}