package homework8.task4;

public class Main {
    public static void main(String[] args) {
        Balancer balancer = new Balancer();

        Customer customer = new Customer("cust_0", "customer000000", balancer);
        Seller seller = new Seller("sell_0", "seller000000", balancer);

        Thread thread1 = new Thread(customer);
        Thread thread2 = new Thread(seller);

        thread1.start();
        thread2.start();

    }

}
