package homework8.task2;

public class Main {
    public static void main(String[] args) {
        Thread main = new Thread(new SimpleThread(1000), "main");
        Thread first = new Thread(new SimpleThread(2000), "first");
        Thread second = new Thread(new SimpleThread(3000), "second");

        main.start();
        first.start();
        second.start();

    }
}
