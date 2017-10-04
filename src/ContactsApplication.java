import util.Input;

import java.util.Scanner;

public class ContactsApplication {

    public static void main(String[] args) {
        Input userInput = new Input();


//        Scanner input = new Scanner(System.in);

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n");

        userInput.getInt(1, 5);
    }

    public static void contactsMenu(int userInput) {


        switch (userInput) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
}
