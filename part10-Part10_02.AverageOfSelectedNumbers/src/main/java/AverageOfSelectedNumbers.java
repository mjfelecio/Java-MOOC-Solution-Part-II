
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputList = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");
        while(true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            inputList.add(input);
        }

        double positive = inputList.stream()
                .mapToInt(s -> Integer.parseInt(s))
                .filter(posNum -> posNum > 0)
                .average()
                .getAsDouble();

        double negative = inputList.stream()
                .mapToInt(s -> Integer.parseInt(s))
                .filter(posNum -> posNum < 0)
                .average()
                .getAsDouble();


        System.out.println("Print the average of the negative numbers or positive numbers? (n/p)");
        String choice = scanner.nextLine();

        if (choice.equals("n")) {
            System.out.println("Average of the negative numbers: " + negative);
        }
        else if (choice.equals("p")) {
            System.out.println("Average of the positive numbers: " + positive);
        }


    }
}
