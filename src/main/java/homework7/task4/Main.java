package homework7.task4;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        AnimalParser animals = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AnimalParser.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            animals = (AnimalParser) unmarshaller.unmarshal(new File("src/main/resources/homework7/task4/animals.xml"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (animals != null) {
            for (Cat cat : animals.getAnimals()) {
                System.out.println(cat.getName() + ": " + cat.getBreed());
            }
        }
    }
}
