package homework8.task2;

public class Main {
    public static void main(String[] args) {
        Thread main = new Thread(new SimpleThread(), "main");
        Thread first = new Thread(new SimpleThread(), "first");
        Thread second = new Thread(new SimpleThread(), "second");

        main.start();
        first.start();
        second.start();

    }
}
