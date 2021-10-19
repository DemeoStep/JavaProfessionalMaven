package homework9.task3_synchronized_method;

public class ClassB implements Runnable {
    private final Counter counter;

    ClassB(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("ClassB thread start");
        for (int i = 0; i < 1000; i++) {
            System.out.println("ClassB tick");
            counter.tick();
            try {
                Thread.sleep(0, 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
