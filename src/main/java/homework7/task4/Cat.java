package homework7.task4;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cat")
public class Cat {
    private String name;
    private int age;
    private String breed;
    private int weight;

    public Cat() {
    }

    public Cat(String name, int age, String breed, int weight) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", weight=" + weight +
                '}';
    }
}
