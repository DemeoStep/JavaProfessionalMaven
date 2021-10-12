package homework7.task2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car implements Externalizable {
    public static int count;
    private String manufacturer;
    private String model;

    public Car() {}

    public Car(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        count++;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(manufacturer);
        objectOutput.writeObject(model);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.manufacturer = (String) objectInput.readObject();
        this.model = (String) objectInput.readObject();
        count++;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
