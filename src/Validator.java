/*
 * Validator
 * Name: Cohen Gallagher
 * Date: 5/2/2025
 * Class: Programming in Java
 * Description: Validates user input to ensure no errors occur.
 */

public class Validator {

    // Validates zipcodes using regex
    public static boolean isValidZip(String input) {
        if (!input.matches("^\\d{5}$")) {
            System.out.println("Invalid ZIP code. It must be a 5-digit number (e.g., 12345).");
            return false;
        }
        return true;
    }

    // Validates temperature units
    public static boolean isValidTempUnit(String input) {
        if (!input.equalsIgnoreCase("C") && !input.equalsIgnoreCase("F")) {
            System.out.println("Invalid temperature unit. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
            return false;
        }
        return true;
    }

    // Validates precipitation units
    public static boolean isValidPrecipUnit(String input) {
        if (!input.equalsIgnoreCase("MM") && !input.equalsIgnoreCase("IN")) {
            System.out.println("Invalid precipitation unit. Please enter 'MM' for millimeters or 'IN' for inches.");
            return false;
        }
        return true;
    }

    // Validates wind units
    public static boolean isValidWindUnit(String input) {
        if (!input.equalsIgnoreCase("KMH") && !input.equalsIgnoreCase("MPH")) {
            System.out.println("Invalid wind speed unit. Please enter 'KMH' for kilometers per hour or 'MPH' for miles per hour.");
            return false;
        }
        return true;
    }
}