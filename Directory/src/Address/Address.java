package Directory.src.Address;

public class Address {

    private String city, postcode, street, number;

    public void setCity(String city) { this.city = city; }

    public void setPostcode(String postcode) { this.postcode = postcode; }

    public void setStreet(String street) { this.street = street; }

    public void setNumber(String number) { this.number = number; }

    public String getCity() { return this.city; }

    public String getPostcode() { return this.postcode; }

    public String getStreet() { return this.street; }

    public String getNumber() { return this.number; }

    public Address(String city, String postcode, String street, String number) {
        this.city = city;
        this.postcode = postcode;
        this.street = street;
        this.number = number;
    }

    public String toString() { return String.format("%s %s, %s %s", this.street, this.number, this.postcode, this.city); }
}
