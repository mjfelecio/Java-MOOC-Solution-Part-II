import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstContainer = 0;
        int secondContainer = 0;

        System.out.println("First: " + firstContainer + "/100");
        System.out.println("Second: " + secondContainer + "/100");

        while (true) {
            String input = scan.nextLine();
            String[] parts = input.split(" ");

            String command = parts[0].toLowerCase();

            if (command.equals("quit")) {
                break;
            }

            if (parts.length > 1) {
                int amount = Integer.parseInt(parts[1]);

                switch (command) {
                    case "add":
                        if (amount > 0) {
                            firstContainer += amount;
                        }

                        if (firstContainer > 100) {
                            firstContainer = 100;
                        }
                        break;

                    case "move":
                        if (amount > 0) {
                            if (firstContainer < amount) {
                                secondContainer += firstContainer;
                            } else {
                                secondContainer += amount;
                            }
                            firstContainer -= amount;

                            if (firstContainer < 0) {
                                firstContainer = 0;
                            }
                            if (secondContainer > 100) {
                                secondContainer = 100;
                            }
                        }
                        break;

                    case "remove":
                        if (amount > 0) {
                            if (secondContainer < amount) {
                                secondContainer = 0;
                            } else {
                                secondContainer -= amount;
                            }
                        }
                        break;

                    default:
                        System.out.println("Unknown command.");
                }
            } else {
                System.out.println("Please enter a valid command.");
            }

            System.out.println("First: " + firstContainer + "/100");
            System.out.println("Second: " + secondContainer + "/100");
        }
    }
}
