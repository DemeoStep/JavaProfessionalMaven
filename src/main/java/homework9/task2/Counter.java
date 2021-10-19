package homework9.task2;

public class Counter {
    private int counter;

    public void tick() {
        this.counter++;
    }

    @Override
    public String toString() {
        return "counter = " + counter;
    }
}
