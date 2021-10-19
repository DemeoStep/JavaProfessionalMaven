package homework9.task3_lock;

public class ClassA implements Runnable {
    private final Counter counter;

    ClassA(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("ClassA thread start");
        for (int i = 0; i < 1000; i++) {
            counter.lock();
            System.out.println("ClassA tick");
            counter.tick();
            counter.unlock();

            // Для распараллеливания потоков... без sleep первый запустившийся поток может успеть отработать полностью,
            // либо (на быстрых машинах и легких задачах) монитор не будет успевать переключаться
            try {
                Thread.sleep(0, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
