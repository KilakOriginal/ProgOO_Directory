package Directory.src.Contact;

import Directory.src.Address.Address;

/**
 * A class defining an abstract contact (i.e. a person or a company)
 */
public abstract class Contact {

    /**
     * Every type of contact has a name.
     * A person has a first and a last name.
     * A company has a name.
     */
    private Name name;
    /**
     * Every type of contact has an address.
     * There is only one kind of address.
     */
    protected Address address;
    /**
     * Setter for an object's name
     * @param name
     */
    public void setName(Name name) { this.name = name; }
    /**
     * Universal setter for the contact's address
     * @param address
     */
    public void setAddress(Address address) { this.address = address; }
    /**
     * Alternate setter for the contact's address that doesn't require an Address object
     * @param city
     * @param postcode
     * @param street
     * @param number
     */
    public void setAddress(String city, String postcode, String street, String number) { this.address = new Address(city, postcode, street, number); }
    /**
     * Universal getter for the contact's name
     * @return the name
     */
    public Name getName() { return this.name; }
    /**
     * Universal getter for the contact's address
     * @return the address
     */
    public Address getAddress() { return this.address; }
    /**
     * Universal contructor for all types of contacts
     * All contacts need a name and an address.
     * @param address
     */
    protected Contact(Name name, Address address) {
        this.name = name;
        this.address = address;
    }
    /**
     * Universal string representation of a contact
     * @return the string representation
     */
    @Override
    public String toString() { return String.format("%s\r\n%s", this.name.toString(), this.address.toString()); }
}
