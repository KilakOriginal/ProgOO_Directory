package Directory.src.Contact;

import Directory.src.Address.Address;

/**
 * A class defining a particular kind of contact; a person
 */
public class Person extends Contact {

    /**
     * Person specific constructor
     * @param forename
     * @param surname
     * @param address
     */
    public Person(String forename, String surname, Address address) {
        super(new Name(forename, surname), address);
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
        super(new Name(forename, surname), new Address(city, postcode, street, number));
    }
}
