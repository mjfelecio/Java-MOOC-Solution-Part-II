
import java.util.ArrayList;
import java.util.List;

public class Pipe<T> {
    public List<T> pipe;

    public Pipe() {
        this.pipe = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        this.pipe.add(value);
    }

     public T takeFromPipe() {
        T valueFromPipe = null;

        if (!this.pipe.isEmpty()) {
            valueFromPipe = this.pipe.get(0);
            this.pipe.remove(0);
        }

        return valueFromPipe;
     }

     public boolean isInPipe() {
        return !this.pipe.isEmpty();
     }
}