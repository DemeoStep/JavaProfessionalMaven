package homework9.task3_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int counter;
    private final Lock lock = new ReentrantLock();

    public void tick() {
        this.counter++;
    }

    public void lock() {
        try {
            lock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unlock() {
        lock.unlock();
    }

    @Override
    public String toString() {
        return "counter = " + counter;
    }
}
