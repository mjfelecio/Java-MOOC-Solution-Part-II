import java.util.HashMap;

public class MisplacingBox extends Box {
    private HashMap<String, Integer> unknownItems;

    public MisplacingBox () {
        this.unknownItems = new HashMap<>();
    }

    @Override
    public void add(Item item) {
        this.unknownItems.put(item.getName(), item.getWeight());
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
}