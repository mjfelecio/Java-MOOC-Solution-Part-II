import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        Scanner scanner = new Scanner(System.in);
        Checker checker = new Checker();



        while (true) {
            System.out.print("Enter a string: ");
            String string = scanner.nextLine();

            if (string.isEmpty()) break;

            if (checker.timeOfDay(string)) {
                System.out.println("The form is correct.");
            } else {
                System.out.println("The form is incorrect.");
            }
        }

    }
}
