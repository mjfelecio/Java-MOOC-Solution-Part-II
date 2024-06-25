
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private Random lotteryNum;
    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.lotteryNum = new Random();
        this.randomizeNumbers();

    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        // the method containsNumber is probably useful
        for (int i = 0; i < 7;) {
            int randomNum = lotteryNum.nextInt(40) + 1;

            if (!containsNumber(randomNum)) {
                this.numbers.add(randomNum);
                i++;
            }
        }
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        return this.numbers.contains(number);
    }
}

