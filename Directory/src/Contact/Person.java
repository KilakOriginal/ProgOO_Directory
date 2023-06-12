package Directory.src.Contact;

import Directory.src.Address.Address;

/**
 * A class defining a particular kind of contact; a person
 */
public class Person extends Contact {

    private String forename, surname;

    /**
     * Set a person's forename
     * @param forename
     */
    public void setForename(String forename) { this.forename = forename; }
    /**
     * Set a person's last name
     * @param surname
     */
    public void setSurname(String surname) { this.surname = surname; }
    /**
     * A person has a first and a last name, so they get its own setter.
     * @param forename
     * @param surname
     */
    public void setName(String forename, String surname) { 
        this.forename = forename;
        this.surname = surname;
    }
    /**
     * Get a person's forename
     * @return name
     */
    public String getForename() { return this.forename; }
    /**
     * Get a person's last name
     * @return surname
     */
    public String getSurname() { return this.surname; }
    /**
     * Person specific constructor
     * @param forename
     * @param surname
     * @param address
     */
    public Person(String forename, String surname, Address address) {
        super(address);
        this.forename = forename;
        this.surname = surname;
    }
    /**
     * Person specific constructor
     * @param forename
     * @param surname
     * @param city
     * @param postcode
     * @param street
     * @param number
     */
    public Person(String forename, String surname, String city, String postcode, String street, String number) {
        super(new Address(city, postcode, street, number));
        this.forename = forename;
        this.surname = surname;
    }
    /**
     * String representation of a person
     * @return the string representation
     */
    public String toString() { return super.toString(String.format("%s %s", this.forename, this.surname)); }
}
