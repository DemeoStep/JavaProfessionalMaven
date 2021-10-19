package homework9.task2;

public class ClassB implements Runnable {
    private Counter counter;
    private Thread thread;

    ClassB(Counter counter) {
        this.counter = counter;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        System.out.println("ClassB thread start");
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        counter.tick();
    }
}
