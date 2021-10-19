package homework9.task2;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        ClassA classA = new ClassA(counter);
        ClassB classB = new ClassB(counter);

        Thread threadOne = new Thread(classA);
        Thread threadTwo = new Thread(classB);

        classA.setThread(threadTwo);
        classB.setThread(threadOne);

        threadOne.start();
        threadTwo.start();

        while (threadOne.isAlive() || threadTwo.isAlive()) {
        }

        System.out.println(counter);
    }
}
