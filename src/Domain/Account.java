package Domain;

public class Account {
    private String name;
    private String street;
    private String postcode;
    private String houseNumber;
    private String city;

    public Account(String name, String street, String postcode, String houseNumber, String city) {
        this.name = name;
        this.street = street;
        this.postcode = postcode;
        this.houseNumber = houseNumber;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
