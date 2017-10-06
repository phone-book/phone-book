package util;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input() {

        scanner = new Scanner(System.in);
    }

    /////////////////// Return some string.
    public String getString() {

        return scanner.nextLine();
    }

    /////////////////// Return next string
    public String getNextString() {

        return scanner.next();
    }

    ////////////////// Return true or false.
    public boolean yesNo() {

        String confirm = scanner.next();

        if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
            return true;
        } else if (confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no")) {
            return false;
        } else {
            System.out.println("That is not a valid response. Please enter Y | N");
            return yesNo();
        }
    }

    ////////////////// Check integer for min and max.
    public int getInt(int min, int max) {
        try {
            int userNum = Integer.valueOf(getNextString());
            String userNumToString = Integer.toString(userNum);
            if (userNum < min || userNum > max || ContactsApplication.isNaN(userNumToString)) {

                System.out.println("Enter a number between " + min + " and " + max + ": ");

                return getInt(min, max);

            } else {

                return userNum;
            }
        } catch (Exception e) {

            System.out.println("Invalid input. Try again.");

            return getInt(min, max);

        }


    }


    ////////////////// Get integer from user.

    public int getInt() {

        if (this.scanner.hasNextInt()) {

            int userNumber = Integer.valueOf(getString());

            return userNumber;

        } else {

            System.out.println("Invalid Input!");

            scanner.nextLine();

            return getInt();
        }
    }

    ////////////////// Check double for min and max.
    public double getDouble(double min, double max) {
        try {
            double userNum = Double.valueOf(getString());

            if (userNum < min || userNum > max) {

                System.out.println("Enter a number between " + min + " and " + max + ": ");

                scanner.nextLine();

                return getDouble(min, max);

            } else {

                return userNum;

            }


        } catch (Exception e) {

            System.out.println("Invalid input.\nTry again.");

            return getDouble(min, max);

        }
    }

    ////////////////// Get double from user.
    public double getDouble() {

        if (this.scanner.hasNextDouble()) {

            return scanner.nextDouble();

        } else {

            System.out.println("Invalid Input!");

            scanner.nextLine();

            return getDouble();

        }
    }
}

