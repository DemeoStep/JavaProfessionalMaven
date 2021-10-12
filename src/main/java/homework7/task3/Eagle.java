package homework7.task3;

import java.io.*;
import java.lang.reflect.Field;

public class Eagle extends Animal implements Cloneable, Serializable {
    private int tail;

    public Eagle(){}

    public Eagle(int age, boolean isInRedBook, String breed, int tail) {
        super(age, isInRedBook, breed);
        this.tail = tail;
    }

    public Eagle(Eagle src) {
        super(src.getAge(), src.isInRedBook(), src.getBreed());
        this.tail = src.getTail();
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    @Override
    public Eagle clone() {
        return (Eagle) super.clone();
    }

    public static Eagle cloneFabricMethod(Eagle src) {
        return new Eagle(src.getAge(), src.isInRedBook(), src.getBreed(), src.getTail());
    }

    public static Eagle cloneWithReflection(Eagle src){
        Eagle clone = new Eagle();

        //get superclass fields

        Field[] fields = clone.getClass().getSuperclass().getDeclaredFields();

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Field cloneField = clone.getClass().getSuperclass().getDeclaredField(field.getName());
                cloneField.setAccessible(true);
                cloneField.set(clone, field.get(src));
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //get class fields

        fields = clone.getClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                Field cloneField = clone.getClass().getDeclaredField(field.getName());
                cloneField.set(clone, field.get(src));
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return clone;
    }

    public static Eagle cloneWithSerialization(Eagle src) {
        Eagle clone = (Eagle) Animal.cloneWithSerialization(src);

        try {
            ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(byteOutput);

            output.writeObject(src);

            ByteArrayInputStream byteInput = new ByteArrayInputStream(byteOutput.toByteArray());
            ObjectInputStream input = new ObjectInputStream(byteInput);

            clone = (Eagle) input.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clone;
    }

    @Override
    public String toString() {
        return " Eagle{" +
                super.toString() +
                ", tail=" + tail +
                '}';
    }
}
