package homework7.task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Украина", "Киев", "Крещатик");

        toJson(address);
        System.out.println(fromJson());
    }

    public static void toJson(Address address) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        String json = gson.toJson(address);

        try {
            Files.write(Paths.get("src/main/resources/homework7/task5/address.json"), json.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Address fromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        Address address = null;
        try {
            address = objectMapper.readValue(new File("src/main/resources/homework7/task5/address.json"), Address.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return address;
    }
}
