package Directory.src.Contact;

/**
 * Class for creating and performing operations on names
 */
public class Name {
    
    /**
     * A person has two names (one or more forenames and surnames).
     * A company only has a single name.
     */
    private String name1, name2;
    /**
     * Setter for a person's first and last name
     * @param forename
     * @param surname
     */
    public void setName(String forename, String surname) { 
        this.name1 = forename;
        this.name2 = surname;
    }
    /**
     * Setter for a company's name or a person's forename
     * @param name
     */
    public void setName(String name) { 
        this.name1 = name;
        this.name2 = "";
    }
    /**
     * Getter for person's forename
     * @return forename
     */
    public String getForename() { return this.name1; }
    /**
     * Getter for person's surname
     * @return surname
     */
    public String getSurname() { return this.name2; }
    /**
     * Getter for the object's name
     * @return object's name
     */
    public String getName() { return String.format("%s %s", this.name1, this.name2).strip(); }
    /**
     * Constructor for a person's name
     * @param forename
     * @param surname
     */
    public Name(String forename, String surname) { this.setName(forename, surname); }
    /**
     * Constructor for a company's name or person's forename
     * @param name
     */
    public Name(String name) { this.setName(name); }
    /**
     * String representation of a name
     * @return object's name
     */
    @Override
    public String toString() { return this.getName(); }
}
