
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int count = 0;
        while(true) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number == 0) {
                System.out.println("Cannot calculate the average");
                break;
            }

            if (number > 0) {
                sum += number;
                count++;
            }
        }

        System.out.println(1.0 * sum / count);
    }
}
