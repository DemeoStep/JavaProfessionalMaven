package addTask_HashMap;

public class Main {
    public static void main(String[] args) throws Exception {

        MyHashMap<String, String> my = new MyHashMap<>();

        my.put("one", "1");
        System.out.println("Capacity: " + my.getCap() + " " + my);
        my.put("neo", "1.1");
        System.out.println("Capacity: " + my.getCap() + " " + my);
        my.put("two", "2");
        System.out.println("Capacity: " + my.getCap() + " " + my);
        my.put("tow", "2.2");
        System.out.println("Capacity: " + my.getCap() + " " + my);
        my.put("three", "3");
        System.out.println("Capacity: " + my.getCap() + " " + my);
        my.put("four", "4");
        System.out.println("Capacity: " + my.getCap() + " " + my);
        my.put("six", "6");
        System.out.println("Capacity: " + my.getCap() + " " + my);
        my.put(null, null);
        System.out.println("Capacity: " + my.getCap() + " " + my);
        my.put("isx", null);
        System.out.println("Capacity: " + my.getCap() + " " + my);
        my.put("seven", "7");
        System.out.println("Capacity: " + my.getCap() + " " + my);

        System.out.println(my.remove("null"));

        System.out.println(my);

    }
}
