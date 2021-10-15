package homework8.task4;

public class Balancer {
    private boolean balance;

    public synchronized void tick(String str) {
        if (!balance) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(str);
        balance = false;
        notify();
    }

    public synchronized void tack(String str) {
        if (balance) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(str);
        balance = true;
        notify();
    }

}
