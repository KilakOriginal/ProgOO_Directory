package Directory.src.Contact;

import Directory.src.Address.Address;

/**
 * A class defining a particular kind of contact; a company
 */
public class Company extends Contact {

    /**
     * Every company has a name.
     */
    private String name;
    /**
     * A company has an owner (some sort of contact).
     * A company's owner might be a person or another company.
     */
    private Contact owner;
    /**
     * Get the company's name
     * @return name
     */
    public String getName() { return this.name; }
    /**
     * A company only has one name, so it gets its own setter.
     * @param name
     */
    public void setName(String name) { this.name = name; }
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
    public Company(String name, Address address, Contact owner) {
        super(address);
        this.name = name;
        this.owner = owner;
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
        super(new Address(city, postcode, street, number));
        this.name = name;
        this.owner = owner;
    }
    /**
     * String representation of a company
     * @return the string representation
     */
    public String toString() { return super.toString(String.format("%s", this.name)); }
}
