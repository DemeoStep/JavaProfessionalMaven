package addTask_HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        MyHashMap<String, String> my = new MyHashMap<>();

        // isEmpty()
        System.out.println("isEmpty: " + my.isEmpty());

        // put()
        my.put("one", "1");
        my.put("neo", "1.1");
        my.put("two", "2");
        my.put("three", "3");
        my.put("four", "5");

        System.out.println("size: " + my.size() + " " + my);
        System.out.println("isEmpty: " + my.isEmpty());

        System.out.println(my.put("four", "4")); // возвращаем старое значение и переписываем его новым
        System.out.println("size: " + my.size() + " " + my);

        // get()
        System.out.println(my.get("four"));
        System.out.println(my.get("five"));

        // containsKey()
        System.out.println(my.containsKey("two"));
        System.out.println(my.containsKey("wto"));

        // containsValue()
        System.out.println(my.containsValue("1"));
        System.out.println(my.containsValue("6"));

        // entrySet()
        System.out.println(my.entrySet());

        // keySet()
        System.out.println(my.keySet());

        // remove()
        System.out.println(my.remove("one"));
        System.out.println(my.remove("six"));
        System.out.println(my);

        //clear
        my.clear();
        System.out.println(my);
    }
}
