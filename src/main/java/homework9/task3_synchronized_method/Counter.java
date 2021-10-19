package homework9.task3_synchronized_method;

public class Counter {
    private int counter;

    public synchronized void tick() {
        this.counter++;
    }

    @Override
    public String toString() {
        return "counter = " + counter;
    }
}
