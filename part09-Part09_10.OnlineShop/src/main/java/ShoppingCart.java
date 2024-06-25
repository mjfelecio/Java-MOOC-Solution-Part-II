import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private Map<String, List<Item>> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void add(String product, int price) {
        if (cart.containsKey(product)) {
            increaseQuantity(product);

        } else {
            List<Item> itemList = new ArrayList<>();
            itemList.add(new Item(product, 1, price));
            cart.put(product, itemList);
        }
    }

    public int price() {
        int totalPrice = 0;

        for (List<Item> items : this.cart.values()) {
            for (Item item : items) {
                totalPrice += item.price();
            }
        }

        return totalPrice;
    }

    private void increaseQuantity(String product) {
        for (Item item : this.cart.get(product)) {
            item.increaseQuantity();
        }
    }

    public void print() {
        for (List<Item> v: this.cart.values()) {
            for (Item item: v) {
                System.out.println(item);
            }
        }
    }
}