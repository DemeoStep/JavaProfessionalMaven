package homework8.task3;

public class Main {
    public static void main(String[] args) {
        PriorityThread min = new PriorityThread("min", Thread.MIN_PRIORITY);
        PriorityThread max = new PriorityThread("max", Thread.MAX_PRIORITY);
        PriorityThread norm = new PriorityThread("norm", Thread.NORM_PRIORITY);
    }
}
