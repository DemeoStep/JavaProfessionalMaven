package homework8.task4;

public class Customer implements Runnable {
    private String id;
    private String name;
    private final Balancer balancer;

    public Customer(String id, String name, Balancer balancer) {
        this.id = id;
        this.name = name;
        this.balancer = balancer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            id = Integer.toString(i);
            name = "customer_" + i;
            balancer.tack("Customer id: " + id);
            balancer.tack("Customer name: " + name);
        }
    }

}
