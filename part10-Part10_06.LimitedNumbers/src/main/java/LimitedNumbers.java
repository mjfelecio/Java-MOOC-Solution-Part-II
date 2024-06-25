
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            int input = Integer.parseInt(scanner.nextLine());

            if (input < 0) break;

            numbers.add(input);
        }

        numbers.stream()
                .filter(s -> s > 0 && s <= 5)
                .forEach(System.out::println);
    }
}
