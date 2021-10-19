package homework9.task4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SimpleThread(), "daemon_1");

        thread.setDaemon(true);

        thread.start();

        while (thread.isAlive()) {
        }

        System.out.println("\n======= Thread stopped =======");

        System.out.println("Name: " + thread.getName());
        System.out.println("isDaemon = " + thread.isDaemon());
        System.out.println("isAlive = " + thread.isAlive());
        System.out.println("Priority = " + thread.getPriority());
        System.out.println("State = " + thread.getState());
        System.out.println("Id = " + thread.getId());
        System.out.println("isInterrupted = " + thread.isInterrupted());
    }
}
