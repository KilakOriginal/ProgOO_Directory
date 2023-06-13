package src;

import java.util.Scanner;

import Directory.src.Directory;

public class Main {

    
    /** 
     * main function of CLI application
     * @param argv
     */
    public static void main(String[] argv) {

        Directory directory = new Directory();
        boolean shouldQuit = false;

        System.out.println("Directory Manager v.1.0.0");
        System.out.println("Type `help' to list all commands.");

        Scanner scanner = new Scanner(System.in, "UTF-8");
        String command = "";

        try {
            while (!shouldQuit) {
                System.out.printf("> ");
                command = scanner.nextLine().strip();

                switch(command) {
                    case "add":
                        mutCreateContactCLI(directory, scanner);
                        break;
                    case "rm":
                        mutDeleteContactCLI(directory, scanner);
                        break;
                    case "search":
                        searchCLI(directory, scanner);
                        break;
                    case "ls":
                        directory.printContacts();
                        break;
                    case "clear":
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        break;
                    case "exit":
                        shouldQuit = true;
                        break;
                    case "help":
                        printHelp();
                        break;
                    default:
                        System.out.printf("Unknown command \"%s\". Type `help' to get a list of commands.\r\n", command);
                }
            }
        }
        catch (Exception e) {
            System.out.printf("Critical Error: %s\r\n", e);
        }
        finally {
            scanner.close();
        }
    }

    static void mutCreateContactCLI(Directory directory, Scanner scanner) {
        String forename = "", surname = "", city = "", street = "", postcode = "", house = "";
        char type;

        try {
            while (true) {
                System.out.print("What type of contact do you want to add ([P]erson or [C]ompany)? ");
                type = scanner.nextLine().toLowerCase().charAt(0);
                switch(type) {
                    case 'p':
                        break;
                    case 'c':
                        break;
                    default:
                        System.out.printf("\nUnknown contact type \"%c\"\n\n", type);
                        continue;
                }
                break;
            }

            while (forename.isEmpty()) {
                if (type == 'c') { System.out.print("Please enter a name: "); }
                else { System.out.print("Please enter the forename: "); }
                forename = scanner.nextLine().trim();
                scanner.reset();
            }

            if (type == 'p') { 
                System.out.print("Please enter the surname (optional): ");
                surname = scanner.nextLine().trim();
            }

            System.out.print("Please enter the city: ");
            city = scanner.nextLine().trim();

            System.out.print("Please enter the street: ");
            street = scanner.nextLine().trim();

            System.out.print("Please enter the house: ");
            house = scanner.nextLine().trim();

            System.out.print("Please enter the postcode: ");
            postcode = scanner.nextLine().trim();

            if (type == 'p') { directory.addPerson(forename, surname, city, postcode, street, house); }

            else {
                String userInput = "";
                while (true) {
                    System.out.print("Please enter the owner's contact number (type \"ls\" to list all current contacts): ");
                    userInput = scanner.nextLine().trim();
                    if (userInput.equals("ls")) { directory.printContacts(); }
                    else {
                        try { directory.addCompany(forename, city, postcode, street, userInput, Integer.parseInt(userInput) - 1); break; }
                        catch (NumberFormatException e) {
                            System.out.printf("\nInvalid contact number \"%s\"\n", userInput);
                        }
                    }
                }
            }
        }
        catch(Exception e) {
            System.out.printf("Error: %s - Unable to create contact\r\n", e);
        }
    }

    static void mutDeleteContactCLI(Directory directory, Scanner scanner) {
        try{
            String userInput = "";
            while (true) {
                System.out.print("Please enter the number of the contact that you want to delete (type \"ls\" to list all current contacts): ");
                userInput = scanner.nextLine().trim();
                if (userInput.equals("ls")) { directory.printContacts(); }
                else {
                    try { directory.deleteContact(Integer.parseInt(userInput) - 1); break; }
                    catch (NumberFormatException e) {
                        System.out.printf("\nInvalid contact number \"%s\"\n", userInput);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.printf("Error: %s\r\n", e);
        }
    }

    static void searchCLI(Directory directory, Scanner scanner) {
        try{
            System.out.printf("Please enter a search term: ");
            String query = scanner.nextLine();
            if (!query.equals("")) { directory.search(query); }
        }
        catch (Exception e) {
            System.out.printf("Error: %s\r\n", e);
        }
    }

    static void printHelp() {
        System.out.println("add\t\t: add a new contact to the directory");
        System.out.println("rm\t\t: remove a contact from the directory");
        System.out.println("search\t\t: search for a contact in the directory");
        System.out.println("ls\t\t: list all contacts in the directory");
        System.out.println("clear\t\t: clear the terminal");
        System.out.println("exit\t\t: quit the application");
        System.out.println("help\t\t: list all commands");
    }
}
