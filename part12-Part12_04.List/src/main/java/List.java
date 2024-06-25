public class List<Type> {
    private Type[] values;
    private int firstFreeIndex;

    public List() {
        this.values = (Type[]) new Object[10];

        this.firstFreeIndex = 0;
    }

    public void add(Type value) {
        if (this.firstFreeIndex == this.values.length) {
            grow();
        }


        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }

    private void grow() {
        int biggerArraySize = this.values.length + this.values.length / 2;
        Type[] biggerArray = (Type[]) new Object[biggerArraySize];

        for (int i = 0; i < this.values.length; i++) {
            biggerArray[i] = this.values[i];
        }

        this.values = biggerArray;
    }


    public boolean contains(Type value) {
        return indexOfValue(value) >= 0;
    }

    public void remove(Type value) {
        int indexOfValue = indexOfValue(value);
        if (indexOfValue < 0) {
            return;
        }

        moveToTheLeft(indexOfValue);
        this.firstFreeIndex--;
    }

    public int indexOfValue(Type value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIndex - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
    }

    public Type value(int index) {
        if (index < 0 || index >= this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstFreeIndex + "]");
        }

        return this.values[index];
    }

    public int size() {
        return this.firstFreeIndex;
    }



}