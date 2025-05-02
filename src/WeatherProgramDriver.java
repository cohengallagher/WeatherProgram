/*
 * WeatherProgramDriver
 * Name: Cohen Gallagher
 * Date: 5/2/2025
 * Class: Programming in Java
 * Description: This JavaFX application fetches current weather data based on
 * zip code. It displays it in a console view (Command Line Interface).
 */

import java.util.Scanner;

public class WeatherProgramDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Weather Program!");

        // ZIP code validation/entry
        String zipInput;
        do {
            System.out.print("Enter your ZIP code (5 digits): ");
            zipInput = scanner.next();
        } while (!Validator.isValidZip(zipInput));
        int zipCode = Integer.parseInt(zipInput);

        // Temperature unit validation/entry
        String tempUnit;
        do {
            System.out.print("Choose temperature unit (C/F): ");
            tempUnit = scanner.next();
        } while (!Validator.isValidTempUnit(tempUnit));

        // Precipitation unit validation/entry
        String precipUnit;
        do {
            System.out.print("Choose precipitation unit (MM/IN): ");
            precipUnit = scanner.next();
        } while (!Validator.isValidPrecipUnit(precipUnit));

        // Wind speed unit validation/entry
        String windUnit;
        do {
            System.out.print("Choose wind speed unit (KMH/MPH): ");
            windUnit = scanner.next();
        } while (!Validator.isValidWindUnit(windUnit));

        // Fetch location and weather data
        LocationData location = ZipcodeConverter.getLocationFromZip(zipCode);
        if (location != null) {
            WeatherData weather = WeatherFetcher.getWeather(location.latitude, location.longitude);
            if (weather != null) {
                // Unit conversions
                double temperature = weather.temperature;
                double realFeel = weather.realFeel;
                String tempSymbol = "°C";
                if (tempUnit.equalsIgnoreCase("F")) {
                    temperature = UnitConverter.celsiusToFahrenheit(temperature);
                    realFeel = UnitConverter.celsiusToFahrenheit(realFeel);
                    tempSymbol = "°F";
                }

                double precipitation = weather.precipitation;
                String precipSymbol = "mm";
                if (precipUnit.equalsIgnoreCase("IN")) {
                    precipitation = UnitConverter.millimetersToInches(precipitation);
                    precipSymbol = "in";
                }

                double windSpeed = weather.windSpeed;
                String windSymbol = "km/h";
                if (windUnit.equalsIgnoreCase("MPH")) {
                    windSpeed = UnitConverter.kmhToMph(windSpeed);
                    windSymbol = "mph";
                }

                // Output
                System.out.println("\n--- Weather Report ---");
                System.out.println("Location: " + location.city + ", " + location.state);
                System.out.printf("Weather: %s\n", weather.getWeatherDescription());
                System.out.printf("Temperature: %.1f%s\n", temperature, tempSymbol);
                System.out.printf("Feels Like: %.1f%s\n", realFeel, tempSymbol);
                System.out.printf("Precipitation: %.2f %s\n", precipitation, precipSymbol);
                System.out.printf("Wind: %.1f %s %s\n", windSpeed, windSymbol, weather.windDirectionCompass);

            } else {
                System.out.println("Weather data could not be retrieved.");
            }
        } else {
            System.out.println("Location data could not be retrieved.");
        }

        scanner.close();
    }
}
