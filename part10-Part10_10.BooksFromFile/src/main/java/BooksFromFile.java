
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooksFromFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }

    public static List<Book> readBooks(String file) {

        List<Book> books = new ArrayList<>();

        try {
            Files.lines((Paths.get(file)))
                    .map(row -> row.split(","))
                    .filter(parts -> parts.length >= 4) 
                    .map(parts -> new Book(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]))
                    .forEach(books::add); 
            
        } catch (Exception e) {

            System.err.println("Error reading file" + e.getMessage());
        }

        return books;

    }

}