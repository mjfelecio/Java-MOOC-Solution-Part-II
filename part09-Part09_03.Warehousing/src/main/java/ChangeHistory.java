import java.util.ArrayList;

public class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        this.history.add(status);
    }

    public void clear() {
        this.history.clear();
    }

    public double maxValue() {
        double largestValue = this.history.get(0);

        for (Double d : history) {
            if (d > largestValue) {
                largestValue = d;
            }
        }
        return largestValue;
    }

    public double minValue() {
        double smallestValue = this.history.get(0);

        for (Double d : history) {
            if (d < smallestValue) {
                smallestValue = d;
            }
        }
        return smallestValue;
    }

    public double average() {
        double sum = 0.0;
        int count = 0;

        for (double i: history) {
            sum += i;
            count ++;
        }

        return sum/count;
    }

    public String toString() {
        return this.history.toString();
    }
}