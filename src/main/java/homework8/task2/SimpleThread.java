package homework8.task2;

import java.util.Random;

public class SimpleThread implements Runnable{
    @Override
    public void run() {
        int rand = (new Random().nextInt(250));
        try {
            Thread.sleep(rand);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Завершение потока " + Thread.currentThread().getName() + " после задержки в " + rand + " мс");
    }
}
