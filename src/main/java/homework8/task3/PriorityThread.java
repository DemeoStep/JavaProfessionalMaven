package homework8.task3;

public class PriorityThread {

    public PriorityThread(String name, int priority) {
        Thread thread = new Thread(new PriorityRunner(), name);
        thread.setPriority(priority);
        thread.start();
    }
}
