package Controller;

import java.util.ArrayList;
import java.util.Scanner;
import Model.Country;

public class Validation {

    private final Scanner scanner;

    public Validation() {
        this.scanner = new Scanner(System.in);
    }

    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input a number in the range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputString() {
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Input cannot be empty.");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input a double number.");
                System.out.print("Enter again: ");
            }
        }
    }

    public boolean checkCountryExist(ArrayList<Country> countries, String countryCode) {
        for (Country country : countries) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return false;
            }
        }
        return true;
    }
}