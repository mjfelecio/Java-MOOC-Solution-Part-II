import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // You can test your method here
        Set<String> names = new HashSet<>();
        names.add("first");
        names.add("first");
        names.add("second");
        names.add("second");
        names.add("second");

        System.out.println(returnSize(names));

    }

    private static int returnSize(Set<String> strings) {
        return strings.size();
    }

    // implement the method returnSize here, which returns
    // the number of elements in the set that it receives as a parameter.

}
