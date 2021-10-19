package homework9.task3_tryLock_with_join;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int counter;
    private final Lock lock = new ReentrantLock();

    public boolean tryLock() {
        return lock.tryLock();
    }

    public void unlock() {
        lock.unlock();
    }

    public void tick() {
        this.counter++;
    }

    @Override
    public String toString() {
        return "counter = " + counter;
    }
}
