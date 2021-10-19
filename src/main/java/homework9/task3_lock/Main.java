package homework9.task3_lock;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread threadOne = new Thread(new ClassA(counter));
        Thread threadTwo = new Thread(new ClassB(counter));

        threadOne.start();
        threadTwo.start();

        while (threadOne.isAlive() || threadTwo.isAlive()) {
        }

        System.out.println(counter);
    }
}
