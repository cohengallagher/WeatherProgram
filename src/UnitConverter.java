/*
 * UnitConverter
 * Name: Cohen Gallagher
 * Date: 5/2/2025
 * Class: Programming in Java
 * Description: Converts units based on user input.
 */

public class UnitConverter {

    // Temperature
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Precipitation
    public static double millimetersToInches(double mm) {
        return mm / 25.4;
    }

    public static double inchesToMillimeters(double inches) {
        return inches * 25.4;
    }

    // Wind Speed
    public static double kmhToMph(double kmh) {
        return kmh * 0.621371;
    }

    public static double mphToKmh(double mph) {
        return mph / 0.621371;
    }
}