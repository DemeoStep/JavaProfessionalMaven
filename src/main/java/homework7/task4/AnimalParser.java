package homework7.task4;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.Arrays;

@XmlRootElement(name = "animal")
public class AnimalParser {
    @XmlElement(name = "cat")
    private ArrayList<Cat> animals = new ArrayList<>();

    public void add(Cat animal) {
        this.animals.add(animal);
    }

    public ArrayList<Cat> getAnimals() {
        return this.animals;
    }


    @Override
    public String toString() {
        return "AnimalParser {" +
                "animals=" + Arrays.deepToString(animals.toArray()) +
                '}';
    }
}
