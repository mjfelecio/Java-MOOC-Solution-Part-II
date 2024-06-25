
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Container firstContainer = new Container();
        Container secondContainer = new Container();

        System.out.println("First: " + firstContainer);
        System.out.println("Second: " + secondContainer);

        try {
            while (true) {
                String input = scan.nextLine();
                String[] parts = input.split(" ");

                String command = parts[0];
                int amount = Integer.parseInt(parts[1]);

                if (command.equals("quit")) {
                    break;
                }

                if (command.equals("add")) {
                    firstContainer.add(amount);
                }

                if (command.equals("move")) {
                    if (amount > firstContainer.contains()) {
                        secondContainer.add(firstContainer.contains());
                        firstContainer.remove(amount);
                    } else {
                        secondContainer.add(amount);
                        firstContainer.remove(amount);
                    }
                }

                if (command.equals("remove")) {
                    secondContainer.remove(amount);
                }

                System.out.println("First: " + firstContainer);
                System.out.println("Second: " + secondContainer);
            }
        } catch (IndexOutOfBoundsException Error) {
            System.out.println("There was an Error reading input: " + Error.getMessage());
        }
    }

}
