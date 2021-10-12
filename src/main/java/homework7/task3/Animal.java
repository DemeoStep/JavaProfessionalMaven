package homework7.task3;

import java.io.*;

public class Animal implements Cloneable, Serializable {
    private int age;
    private boolean isInRedBook;
    private String breed;

    public Animal(){}

    public Animal(int age, boolean isInRedBook, String breed) {
        this.age = age;
        this.isInRedBook = isInRedBook;
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isInRedBook() {
        return isInRedBook;
    }

    public void setInRedBook(boolean inRedBook) {
        isInRedBook = inRedBook;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Animal {" +
                "age=" + age +
                ", isInRedBook=" + isInRedBook +
                ", breed='" + breed + '\'' +
                '}';
    }

    @Override
    public Animal clone() {
        try {
            return (Animal) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static Animal cloneWithSerialization(Animal src) {
        Animal clone = null;

        try {
            ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(byteOutput);

            output.writeObject(src);

            ByteArrayInputStream byteInput = new ByteArrayInputStream(byteOutput.toByteArray());
            ObjectInputStream input = new ObjectInputStream(byteInput);

            clone = (Animal) input.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clone;
    }
}
