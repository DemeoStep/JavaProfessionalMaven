package homework7.task5;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("country")
    private String country;
    @JsonProperty("city")
    private String city;
    @JsonProperty("street")
    private String street;

    public Address() {}

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address {" +
                "\n\tcountry = " + country +
                "\n\tcity = " + city +
                "\n\tstreet = " + street +
                "\n}";
    }
}
