package homework9.task3_synchronized_block;

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
