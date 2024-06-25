
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sumOfRows = new ArrayList<>();

        int sum = 0;
        for (int row = 0; row < this.square.length; row++) {
            for (int column = 0; column < this.square[row].length; column++) {
                int value = this.square[row][column];

                sum += value;
            }
            sumOfRows.add(sum);
            sum = 0;
        }
        return sumOfRows;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sumOfColumns = new ArrayList<>();

        int sum = 0;

        for (int column = 0; column < this.square.length; column++) {
            for (int row = 0; row < this.square.length; row++) {
                int valueInColumn = this.square[row][column];
                sum += valueInColumn;
            }
            sumOfColumns.add(sum);
            sum = 0;
        }
        return sumOfColumns;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sumsOfDiagonals = new ArrayList<>();

        int sum = 0;

        // Top to bottom diagonal sum
        // it looks for the value in the same index
        // making sure that only the diagonal is accessed
        for (int topRow = 0; topRow < this.square.length; topRow++) {
            int value = this.square[topRow][topRow];

            sum += value;
        }
        sumsOfDiagonals.add(sum);
        sum = 0;

        // Bottom to top diagonal sum
        int column = 0;

        // the pointer goes upward for the row
        // while the pointer for the column goes to the right each iteration
        for (int bottomRow = this.square.length; bottomRow > 0; bottomRow--) {
            int value = this.square[bottomRow - 1][column];

            sum += value;
            column ++;
        }
        sumsOfDiagonals.add(sum);

        return sumsOfDiagonals;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
