package homework8.task2;

public class SimpleThread implements Runnable {
    private int millis;

    public SimpleThread(int millis) {
        this.millis = millis;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Завершение потока " + Thread.currentThread().getName() + " после задержки в " + millis + " мс");
    }
}
