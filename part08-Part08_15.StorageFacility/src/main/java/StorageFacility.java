import java.util.ArrayList;
import java.util.HashMap;


public class StorageFacility {
    private final HashMap<String, ArrayList<String>> storageUnit;

    public StorageFacility() {
        this.storageUnit = new HashMap<>();
    }

    public void add(String unit, String item) {
        this.storageUnit.putIfAbsent(unit, new ArrayList<>());

        ArrayList<String> itemsInUnit = this.storageUnit.get(unit);

        itemsInUnit.add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        for (String key: this.storageUnit.keySet()) {
            if (key.equals(storageUnit)) {
                return this.storageUnit.get(key);
            }
        }
        return new ArrayList<>();
    }

    public void remove(String storageUnit, String item) {
        for (String key: this.storageUnit.keySet()) {

            if (key.equals(storageUnit)) {
                ArrayList<String> items = this.storageUnit.get(key);

                for (String i: items) {
                    if (i.equals(item)) {
                        items.remove(i);
                        break;
                    }
                }
            }
        }

        if (this.storageUnit.get(storageUnit).isEmpty()) {
            this.storageUnit.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        return new ArrayList<>(this.storageUnit.keySet());
    }
}