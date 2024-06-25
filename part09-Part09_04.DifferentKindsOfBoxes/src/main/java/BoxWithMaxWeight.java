import java.util.HashMap;

public class BoxWithMaxWeight extends Box {
    private int maxWeight;
    private HashMap<String, Integer> itemWeights;

    public BoxWithMaxWeight(int capacity) {
        this.maxWeight = capacity;
        this.itemWeights = new HashMap<>();
    }

    @Override
    public void add(Item item) {
        if (getTotalWeight() + item.getWeight() <= maxWeight) {
            itemWeights.put(item.getName(), item.getWeight());
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return itemWeights.containsKey(item.getName());
    }

    private int getTotalWeight() {
        int sum = 0;
        for (Integer i: itemWeights.values()) {
            sum += i;
        }

        return sum;
    }

}
