package homework8.task4;

public class Seller implements Runnable {
    private String id;
    private String name;
    private final Balancer balancer;

    public Seller(String id, String name, Balancer balancer) {
        this.id = id;
        this.name = name;
        this.balancer = balancer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            id = Integer.toString(i);
            name = "seller_" + i;
            balancer.tick("Seller id: " + id);
            balancer.tick("Seller name: " + name);
        }
    }
}
