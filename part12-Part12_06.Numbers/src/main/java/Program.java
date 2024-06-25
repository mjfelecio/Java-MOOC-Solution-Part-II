
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many random numbers should be printed?");
        int numOfRandNum = Integer.parseInt(scanner.nextLine());

        Random dice = new Random();

        for (int i = 0; i < numOfRandNum; i++) {
            int randomNumber = dice.nextInt(10 + 1);

            System.out.println(randomNumber);
        }

        scanner.close();
    }

}
