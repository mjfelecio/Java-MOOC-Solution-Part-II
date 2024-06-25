import java.util.ArrayList;

public class Box implements Packable{
    private final double maximumCapacity;
    private int numOfItems;
    private ArrayList<Packable> containedItems;

    public Box(double maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.containedItems = new ArrayList<>();
    }

    public void add(Packable item) {
        if (item.weight() + this.weight() <= maximumCapacity) {
            numOfItems ++;
            containedItems.add(item);
        }
    }

    @Override
    public double weight() {
        double totalWeight = 0;

        for (Packable item: containedItems) {
            totalWeight += item.weight();
        }

        return totalWeight;
    }

    public String toString() {
        return "Box: " + this.numOfItems + " items, total weight " + this.weight() + " kg";
    }
}
