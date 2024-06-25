import java.util.HashMap;

public class OneItemBox extends Box {
    private HashMap<String, Integer> itemInBox;

    public OneItemBox () {
        this.itemInBox = new HashMap<>();
    }

    @Override
    public void add(Item item) {
        if (itemInBox.isEmpty()) {
            this.itemInBox.put(item.getName(), item.getWeight());
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return itemInBox.containsKey(item.getName());
    }
}