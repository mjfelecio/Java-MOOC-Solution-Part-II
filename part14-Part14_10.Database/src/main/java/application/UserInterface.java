package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;
    private final TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println();
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here
            switch (command) {
                case "1": listTodos(); break;
                case "2": addTodo(); break;
                case "3": markTodo(); break;
                case "4": removeTodo(); break;
            }
        }

        System.out.println("Thank you!");
    }

    private void removeTodo() throws SQLException {
        System.out.println("Which todo should be removed (give the id)?");
        int id = Integer.parseInt(scanner.nextLine());

        database.remove(id);
    }

    private void markTodo() throws SQLException {
        System.out.println("Which todo should be marked as done (give the id)?");
        int id = Integer.parseInt(scanner.nextLine());

        database.markAsDone(id);
    }

    private void addTodo() throws SQLException {
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter description");
        String description = scanner.nextLine();

        database.add(new Todo(name, description, false));
    }

    public void listTodos() throws SQLException {
        System.out.println("Listing the database contents");
        database.list().forEach(System.out::println);
    }

}
