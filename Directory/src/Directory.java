package Directory.src;

import java.util.ArrayList;
import java.util.Arrays;

import Directory.src.Address.Address;
import Directory.src.Contact.*;

/**
 * Class for creating and performing operations on directories
 */
public class Directory {

    /**
     * List of contacts
     */
    private ArrayList<Contact> contacts;
    /**
     * Add a person to the directory.
     * @param forename
     * @param surname
     * @param city
     * @param postcode
     * @param street
     * @param house
     */
    public void addPerson(String forename, String surname, String city, String postcode, String street, String house) {
        this.contacts.add(new Person(forename, surname, new Address(city, postcode, street, house)));
    }
    /**
     * Add a company to the directory.
     * @param name
     * @param city
     * @param postcode
     * @param street
     * @param house
     * @param owner
     */
    public void addCompany(String name, String city, String postcode, String street, String house, int owner) {
        this.contacts.add(new Company(name, new Address(city, postcode, street, house), this.contacts.get(owner)));
    }
    /*
     * Print all contacts.
     */
    public void printContacts() {
        for (int i = 0; i < this.contacts.size(); ++i) {
            System.out.printf("\tContact %d:\r\n%s\n\n", i+1, this.contacts.get(i).toString());
        }
    }
    /**
     * Search directory for contact and print results.
     * @param query
     */
    public void search(String query) {
        System.out.printf("Searching for \"%s\"...\r\n", query);
        ArrayList<Integer> matches = new ArrayList<Integer>();

        for (int i = 0; i < this.contacts.size(); ++i) {
            if (this.contacts.get(i).toString().contains(query)) { matches.add(i); }
        }

        if (matches.size() <= 0) { System.out.println("No matches."); }
        else {
            System.out.println("The following contacts match your query:");
            for (int i = 0; i < matches.size(); ++i) {
                System.out.printf("\tContact %d:\r\n%s\n\n", i+1, this.contacts.get(i).toString());
            }
        }
    }
    /**
     * Delete a contact from the directory.
     * @param index
     */
    public void deleteContact(int index) {
        this.contacts.remove(index);
    }
    /**
     * Construct a new directoy with any number of initial contacts.
     * @param contacts
     */
    public Directory(Contact... contacts) {
        this.contacts = new ArrayList<Contact>(Arrays.asList(contacts));
    }
}
