import java.util.Objects;

public class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item))
            return false;
        Item oItem = (Item) o;

        return this.getName().equals(oItem.getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
}

