import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LiteracyComparison {

    public static void main(String[] args) {
        List<Literacy> countryLiteracy = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("literacy.csv"))){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");

                String theme = parts[0];
                String ageGroup = parts[1].trim();
                String gender = parts[2].replace("(%)", "").trim();
                String country = parts[3];
                int year = Integer.parseInt(parts[4]);
                double literacyPercent = Double.parseDouble(parts[5]);

                countryLiteracy.add(new Literacy(theme, ageGroup, gender, country, year, literacyPercent));
            }
        } catch (IOException e) {
            System.err.println("File reading error" + e.getMessage());
        }

        countryLiteracy.stream()
                .sorted(Comparator.comparingDouble(Literacy::getLiteracyPercent))
                .forEach(l -> System.out.println(
                        l.getCountry() + " (" + l.getYear() + "), " + l.getGender() + ", " + l.getLiteracyPercent()
                ));
    }
}
