package util;

import util.FileHandler;
import util.Input;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class ContactsApplication {

    static Input userInput = new Input();
    static FileHandler directory1 = new FileHandler("resources", "contacts.txt");

    public static void main(String[] args) throws IOException {

        directory1.createDirectory();
        directory1.createFile();
        contactsMenu();
    }

    public static void contactsMenu() throws IOException {
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n");


        String option = userInput.getNextString();

        int userNum = Integer.valueOf(option);

        switch (userNum) {
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
        System.out.println(directory1.readFile());
        System.out.println("Would you like to go back to the main menu?");
        boolean menuConfirmation = userInput.yesNo();
        if (menuConfirmation) {
            contactsMenu();
        } else {
            System.out.println("GoodBye!");
        }
    }

    static public void searchContact() throws IOException {
        System.out.println("Search contact by name:");
        String contact = userInput.getString();
        List<String> contactFile = directory1.readFile();

        for (String line : contactFile) {
            String[] parts = line.split(",");

            if (contact.equalsIgnoreCase(parts[0])) {
                System.out.println("Name: " + parts[0] + " - " + "Number: " + parts[1]);
                directory1.contacts.remove(directory1.contacts.indexOf(contact));
                directory1.writeFile();
                System.out.println(directory1.readFile());
            }
        }
    }

    public static void addContact() throws IOException {
        System.out.println("What is the name of your new contact?");
        String name = userInput.getString();
        System.out.println("Please enter phone number as follows: (xxx)xxx-xxxx");
        String phoneNumber = userInput.getString();
        directory1.contacts.add(name + "," + phoneNumber);
        directory1.writeFile();
    }

    public static void deleteContact() throws IOException {
        System.out.println("Search contact by name:");
        String contact = userInput.getString();

        List<String> contactFile = directory1.readFile();
        for (int i = 0; i < contactFile.size(); i++) {
            String[] parts = contactFile.get(i).split(",");
            if (contact.equalsIgnoreCase(parts[0])) {
                directory1.contacts.remove(i);
                directory1.writeFile();
            }
        }
    }

}