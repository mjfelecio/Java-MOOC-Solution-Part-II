import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> warehouse;
    private Map<String, Integer> stockBalance;

    public Warehouse() {
        this.warehouse = new HashMap<>();
        this.stockBalance = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        warehouse.put(product, price);
        stockBalance.put(product, stock);
    }

    public int price(String product) {
        for (String key : warehouse.keySet()) {
            if (key.equals(product)) {
                return this.warehouse.get(key);
            }
        }
        return -99;
    }

    public int stock(String product) {
        for (String key : stockBalance.keySet()) {
            if (key.equals(product)) {
                return stockBalance.get(key);
            }
        }
        return 0;
    }

    public boolean take(String product) {
        for (Map.Entry<String, Integer> entry : stockBalance.entrySet()) {
            String productName = entry.getKey();
            Integer stock = entry.getValue();

            if (productName.equals(product) && stock > 0) {
                stock--;
                stockBalance.put(productName, stock);
                return true;
            }
        }
        return false;
    }

    public Set<String> products() {
        Set<String> productNames = new HashSet<>();

        for (String name : warehouse.keySet()) {
            productNames.add(name);
        }

        return productNames;
    }


}