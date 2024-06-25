import java.util.Scanner;

public class UserInterface {
    private final TodoList tasks;
    private final Scanner scanner;

    public UserInterface (TodoList tasks, Scanner scanner) {
        this.tasks = tasks;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String userCommand = scanner.nextLine().toLowerCase();

            if (userCommand.equals("stop")) {
                break;
            }

            switch (userCommand) {

                case "add" :
                    System.out.print("To add: ");
                    String taskToAdd = scanner.nextLine();

                    tasks.add(taskToAdd);
                    break;

                case "list":
                    tasks.print();
                    break;

                case "remove":
                    System.out.print("Which one is removed? ");
                    int removeTask = Integer.parseInt(scanner.nextLine());

                    tasks.remove(removeTask);
                    break;

                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}