import java.util.ArrayList;

public class TodoList {
    private final ArrayList<String> tasks;

    public TodoList () {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        this.tasks.add(task);
    }

    public void print() {
        int number = 1;

        for (String task: tasks) {
            System.out.println(number + ": " + task);
            number ++;
        }
    }

    public void remove(int number) {
        tasks.remove(number -1);
    }

}