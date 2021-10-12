package homework7.task2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/homework7/task2/file.txt");
        Car car1 = new Car("BMW", "X3");

        System.out.println("Source object: " + car1);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){

            out.writeObject(car1);

            Car car2 = (Car) in.readObject();
            System.out.println("Deserialized object: " + car2);

        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Total cars: " + Car.count);
    }
}
