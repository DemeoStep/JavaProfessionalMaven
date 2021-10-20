package homework10.task1;

/*  Создать список и заполнить рандомными числами 10 ячеек, нужно вывести сумму квадратов всех элементов списка.
    Мы используем метод map() для возведения в квадрат каждого элемента, а потом применяем метод reduce()
    для свертки всех элементов в одно число.
*/

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var arrayList = new ArrayList<Integer>(10);

        for (var i = 0; i < 10; i++) {
            arrayList.add(new Random().nextInt(10));
        }

        System.out.println(arrayList);

        //Вариант 1 (Через stream)
        var t1 = System.nanoTime();
        System.out.println(arrayList.stream()
                .map(e -> e * e)
                .reduce(0, Integer::sum));
        var t2 = System.nanoTime();

        //Вариант 2 (Простенько, но намного быстрее, как оказалось)
        var t3 = System.nanoTime();
        var sum = 0;
        for (Integer num : arrayList) {
            sum += num * num;
        }
        System.out.println(sum);
        var t4 = System.nanoTime();

        System.out.println("Stream: " + (t2 - t1));
        System.out.println("Simple: " + (t4 - t3));
    }
}
