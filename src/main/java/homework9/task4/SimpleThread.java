package homework9.task4;

public class SimpleThread implements Runnable {

    @Override
    public void run() {
        System.out.println("======= Thread started =======");

        System.out.println("Name: " + Thread.currentThread().getName());
        System.out.println("isDaemon = " + Thread.currentThread().isDaemon());
        System.out.println("isAlive = " + Thread.currentThread().isAlive());
        System.out.println("Priority = " + Thread.currentThread().getPriority());
        System.out.println("State = " + Thread.currentThread().getState());
        System.out.println("Id = " + Thread.currentThread().getId());
        System.out.println("isInterrupted = " + Thread.currentThread().isInterrupted());
    }
}
