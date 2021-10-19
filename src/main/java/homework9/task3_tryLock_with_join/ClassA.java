package homework9.task3_tryLock_with_join;

public class ClassA implements Runnable {
    private final Counter counter;
    private Thread thread;

    ClassA(Counter counter) {
        this.counter = counter;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        System.out.println("ClassA thread start");
        for (int i = 0; i < 1000; i++) {
            if (counter.tryLock()) {
                System.out.println("ClassA tick");
                counter.tick();
                counter.unlock();
                try {
                    Thread.sleep(0, 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i--;
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
