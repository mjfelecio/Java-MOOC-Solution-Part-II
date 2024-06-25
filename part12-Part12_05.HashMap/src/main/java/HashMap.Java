import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> {

    private List<Pair<K, V>>[] values;
    private int firstFreeIndex;

    public HashMap() {
        this.values = new ArrayList[32];
        this.firstFreeIndex = 0;
    }

    public V get(K key) {
        int hashValue = hashValue(this.values, key);
        if (this.values[hashValue] == null) {
            return null;
        }

        List<Pair<K, V>> valuesAtIndex = this.values[hashValue];

        for (Pair<K, V> atIndex : valuesAtIndex) {
            if (atIndex.getKey().equals(key)) {
                return atIndex.getValue();
            }
        }

        return null;
    }

    public void add(K key, V value) {
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        int index = getIndexOfKey(valuesAtIndex, key);

        if (index < 0) {
            // if the pair is not in that list then it will create a new pair then add it to the list.
            valuesAtIndex.add(new Pair<>(key, value));
            this.firstFreeIndex++;
        } else {
            // if it is found, it will override the value with the new value.
            valuesAtIndex.get(index).setValue(value);
        }

        /* grows the array if the amount of values is
         greater than 75% of the size of the internal array.*/
        if (1.0 * this.firstFreeIndex / this.values.length > 0.75) {
            grow();
        }
    }

    public V remove(K key) {
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        if (valuesAtIndex.isEmpty()) {
            return null;
        }

        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }

        Pair<K, V> pair = valuesAtIndex.get(index);
        valuesAtIndex.remove(pair);
        return pair.getValue();
    }

    private void grow() {
        // create a new array with double the capacity
        List<Pair<K, V>>[] newArray = new ArrayList[this.values.length * 2];

        for (int i = 0; i < this.values.length; i++) {
            // for each list in the old array, rehash its elements into the new array
            copy(newArray, i);
        }

        // replace the old array with the new one
        this.values = newArray;
    }


    private void copy(List<Pair<K, V>>[] newArray, int fromIndex) {
        // iterates through the list from the parameter
        for (int i = 0; i < this.values[fromIndex].size(); i++) {
            Pair<K, V> value = this.values[fromIndex].get(i);

            // gives new hashes to the pairs.
            int hashValue = hashValue(newArray, value.getKey());

            if(newArray[hashValue] == null) {
                newArray[hashValue] = new ArrayList<>();
            }

            newArray[hashValue].add(value);
        }
    }

    private List<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = hashValue(this.values, key);
        if (values[hashValue] == null) {
            values[hashValue] = new ArrayList<>();
        }

        return values[hashValue];
    }

    private int getIndexOfKey(List<Pair<K, V>> myList, K key) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }

    private int hashValue(List<Pair<K, V>>[] internalArray, K key) {
        // returns an integer hash based on the key given to it.
        return Math.abs(key.hashCode() % internalArray.length);
    }


}