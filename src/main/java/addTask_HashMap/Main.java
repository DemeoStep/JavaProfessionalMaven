package addTask_HashMap;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> original = new HashMap<>();

        original.put("one", "1");
        original.put("neo", "2");
        original.put("two", "3");

        System.out.println(original.entrySet());

        MyHashMap<String, String> my = new MyHashMap<>();

        my.put("one", "1");
        my.put("neo", "2");
        my.put("two", "3");
        System.out.println(my.put("two", "4"));

        System.out.println(my);

        System.out.println(my.keySet());
    }
}
