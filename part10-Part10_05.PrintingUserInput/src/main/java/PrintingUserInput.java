
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) break;

            strings.add(input);
        }

        strings.forEach(System.out::println);

    }
}
