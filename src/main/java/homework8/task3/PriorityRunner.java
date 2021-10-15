package homework8.task3;

public class PriorityRunner implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(i + " - " + Thread.currentThread().getName() + "(" + Thread.currentThread().getPriority() + ")");
        }
    }
}
