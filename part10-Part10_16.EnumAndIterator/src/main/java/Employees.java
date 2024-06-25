import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        this.employees.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        Iterator<Person> iterator = peopleToAdd.iterator();

        while(iterator.hasNext()) {
            this.employees.add(iterator.next());
        }
    }

    public void print() {
        this.employees.forEach(System.out::println);
    }

    public void print(Education education) {
        Iterator<Person> iterator = this.employees.iterator();

        while(iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getEducation().equals(education)) {
                System.out.println(person);
            }
        }
    }


    public void fire(Education education) {
        Iterator<Person> iterator = this.employees.iterator();

        while(iterator.hasNext()) {
            if (iterator.next().getEducation().equals(education)) {
                iterator.remove();
            }
        }
    }
}
