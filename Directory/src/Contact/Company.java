package Directory.src.Contact;

import Directory.src.Address.Address;

/**
 * A class defining a particular kind of contact; a company
 */
public class Company extends Contact {

    /**
     * A company has an owner (some sort of contact).
     * A company's owner might be a person or another company.
     */
    private Contact owner;
    /**
     * A company has an owner, so it gets its own setter.
     * @param owner
     */
    public void setOwner(Contact owner) { this.owner = owner; }
    /**
     * A company has an owner, so it gets its own getter.
     * @return the owner
     */
    public Contact getOwner() { return this.owner; }
    /**
     * Company specific constructor
     * @param name
     * @param address
     * @param owner
     */
    public Company(Name name, Address address, Contact owner) {
        super(name, address);
    }
    /**
     * Company specific constructor
     * @param name
     * @param city
     * @param postcode
     * @param street
     * @param number
     * @param owner
     */
    public Company(String name, String city, String postcode, String street, String number, Contact owner) {
        super(new Name(name), new Address(city, postcode, street, number));
        this.owner = owner;
    }
}
