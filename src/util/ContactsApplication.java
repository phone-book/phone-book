package util;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import util.FileHandler;
import util.Input;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.lang.Integer;


public class ContactsApplication {

    static Input userInput = new Input();
    static FileHandler directory1 = new FileHandler("resources", "contacts.txt");

    public static void main(String[] args) throws IOException {

        directory1.createDirectory();
        directory1.createFile();
        contactsMenu();
    }

    public static void contactsMenu() throws IOException {
        System.out.println("Welcome to your phone book!");
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n");


        //String option = userInput.getNextString();

        int option = userInput.getInt(1, 5);

        //int userNum = Integer.valueOf(option);

        //switch (userNum) {
        switch(option) {
            case 1:
                viewContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
                break;
            case 5:
                System.out.println("GoodBye!");
                break;
        }
    }

    static public void viewContacts() throws IOException {
        System.out.println("| Name       |  Phone Number   |");
        System.out.println("--------------------------------");
        List<String> contactFile = directory1.readFile();
        for (String line : contactFile) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                System.out.printf("| %-11s| ", parts[0]);
                System.out.println(parts[1] + "   |");
            }
        }

        recursionFunc();

    }

    static public void searchContact() throws IOException {
        System.out.println("Search contact by first name:");
        String contact = userInput.getNextString();
        List<String> contactFile = directory1.readFile();
        boolean found = false;
        for (String line : contactFile) {
            String[] parts = line.split(",");

            if (contact.equalsIgnoreCase(parts[0])) {
                System.out.println("Name: " + parts[0] + "\n" + "Number: " + parts[1]);
                found = true;
                recursionFunc();

            }
        }

        if (!found) {
            System.out.println("Contact not found!\nWould you like to add this contact? Y | N ");
            boolean add = userInput.yesNo();
            if (add) {
                addContact(contact);
            } else {
                recursionFunc();
            }
        }

    }

    // When contact already exists in addContact()
    static public void searchContact(String name) throws IOException {
        List<String> contactFile = directory1.readFile();
        for (String line : contactFile) {
            String[] parts = line.split(",");

            if (name.equalsIgnoreCase(parts[0])) {
                System.out.println("Name: " + parts[0] + "\n" + "Number: " + parts[1]);
            }
        }
    }

        public static void addContact() throws IOException {
        System.out.println("What is the first name of your new contact?");
        String name = userInput.getNextString().trim();
        List<String> contactFile = directory1.readFile();

        for (String line : contactFile) {
            String[] parts = line.split(",");

            if (name.equalsIgnoreCase(parts[0])) {
                System.out.println("There is already a contact by this name:");
                searchContact(name);
                System.out.println("\nWould you like to add another contact with this name? Y | N");
                boolean yes = userInput.yesNo();
                if (yes) {
                    addContact(name);
                    return;
                } else {
                    recursionFunc();
                }

            }
        }

        System.out.println("Please enter the phone number: (xxx)xxx-xxxx");
        String phoneNumber = userInput.getNextString().trim();

        boolean validated = validatePhoneNumber(phoneNumber);

        if (validated) {

            directory1.contacts.add(name + "," + phoneNumber);
            directory1.writeFile();
            System.out.println("Contact added!");
            recursionFunc();

        } else {

            System.out.println("Invalid format: (xxx)xxx-xxxx");
            addContact(name);

        }

    }

    // When contact doesn't exist and user wants to add
    public static void addContact(String name) throws IOException {

        System.out.println("Please enter the phone number: (xxx)xxx-xxxx");
        String phoneNumber = userInput.getNextString().trim();

        boolean validated = validatePhoneNumber(phoneNumber);

        if (validated) {

            directory1.contacts.add(name + "," + phoneNumber);
            directory1.writeFile();
            System.out.println("Contact added!");
            recursionFunc();

        } else {

            System.out.println("Invalid format: (xxx)xxx-xxxx");
            addContact(name);

        }
    }


    public static void deleteContact() throws IOException {
        System.out.println("Who would you like to delete?");
        String contact = userInput.getNextString();
        List<String> contactFile = directory1.readFile();
        boolean found = false;
        for (int i = 0; i < contactFile.size(); i++) {
            String[] parts = contactFile.get(i).split(",");
            if (contact.equalsIgnoreCase(parts[0])) {
                directory1.contacts.remove(i);
                directory1.writeFile();
                System.out.println("Contact deleted!");
                recursionFunc();
            }
        }
        if (!found) {
            System.out.println("Contact not found. Would you like to delete another contact? Y | N");
            boolean yes = userInput.yesNo();
            if (yes) {
                deleteContact();
            } else {
                recursionFunc();
            }
        }
    }

    public static boolean validatePhoneNumber(String phoneNumber) {

        return phoneNumber.charAt(0) == '(' &&
                phoneNumber.charAt(4) == ')' &&
                phoneNumber.charAt(8) == '-' &&
                phoneNumber.length() == 13 &&
                !isNaN(phoneNumber.substring(1, 4)) &&
                !isNaN(phoneNumber.substring(5, 8)) &&
                !isNaN(phoneNumber.substring(9, phoneNumber.length()));

    }

    public static boolean isNaN(String substring) {
        try {
            Integer.parseInt(substring);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }



    public static void recursionFunc() throws IOException {
        System.out.println("\nWould you like to go back to the main menu? Y | N");
        boolean menuConfirmation = userInput.yesNo();
        if (menuConfirmation) {
            contactsMenu();
        } else {
            System.out.println("Goodbye!");
        }
    }

    public static void replaceContact() throws IOException {
        System.out.println("To be replaced");
    }

}