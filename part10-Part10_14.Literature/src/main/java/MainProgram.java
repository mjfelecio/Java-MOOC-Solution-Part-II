
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

    public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String bookName = scanner.nextLine();

            if (bookName.isEmpty()) {
                break;
            }

            System.out.print("Input the age recommendation: ");
            int ageRec = Integer.parseInt(scanner.nextLine());

            books.add(new Book(bookName, ageRec));
        }

        System.out.println();

        if (books.isEmpty()) {
            System.out.println("No books in the library");
        } else if (books.size() == 1) {
            System.out.println("1 book in total");
        } else {
            System.out.println(books.size() + " books in total.");
        }

        System.out.println("\nBooks:");

        books.sort(Comparator
                .comparing(Book::getAgeRecommendation)
                .thenComparing(Book::getName));

        books.forEach(System.out::println);

    }

}
