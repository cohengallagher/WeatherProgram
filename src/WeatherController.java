/*
 * WeatherController
 * Name: Cohen Gallagher
 * Date: 5/2/2025
 * Class: Programming in Java
 * Description: Provides functionality to GUI.
 */

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WeatherController {

    // Radio button group
    @FXML private RadioButton tempCButton;
    @FXML private RadioButton tempFButton;
    @FXML private RadioButton precipMMButton;
    @FXML private RadioButton precipINButton;
    @FXML private RadioButton windKMHButton;
    @FXML private RadioButton windMPHButton;

    // Text field group
    @FXML private TextField zipField;

    // Button group
    @FXML private Button checkWeatherButton;
    @FXML private Button resetButton;

    // Label group
    @FXML private Label locationLabel;
    @FXML private Label temperatureLabel;
    @FXML private Label feelsLikeLabel;
    @FXML private Label precipitationLabel;
    @FXML private Label windLabel;
    @FXML private Label weatherDescriptionLabel;
    @FXML private Label errorLabel;

    //Image view group
    @FXML private ImageView backgroundImage;

    @FXML
    public void initialize() {
        // Set initial background image and clear labels upon load
        backgroundImage.setImage(new Image(getClass().getResource("/Images/defaultBackground.jpg").toExternalForm()));
        clearLabels();
    }

    // Called when "Check Weather" button is pressed
    @FXML
    public void handleCheckWeather() {
        clearLabels();

        // Get trimmed zipcode
        String zipInput = zipField.getText().trim();
        if (!Validator.isValidZip(zipInput)) {
            errorLabel.setText("Please enter a valid 5-digit ZIP code.");
            return;
        }

        // Determine user-selected radio buttons
        String tempUnit = tempFButton.isSelected() ? "F" : "C";
        String precipUnit = precipINButton.isSelected() ? "IN" : "MM";
        String windUnit = windMPHButton.isSelected() ? "MPH" : "KMH";

        try {
            //Convert zip string to int and get location data
            int zipCode = Integer.parseInt(zipInput);
            LocationData location = ZipcodeConverter.getLocationFromZip(zipCode);

            if (location == null) {
                errorLabel.setText("Location not found for that ZIP code.");
                return;
            }

            // Use location to fetch weather data
            WeatherData weather = WeatherFetcher.getWeather(location.latitude, location.longitude);
            if (weather == null) {
                errorLabel.setText("Failed to fetch weather data.");
                return;
            }

            // Display data in UI
            displayWeather(location, weather, tempUnit, precipUnit, windUnit);

            // General catch statement to avoid any unhandled errors
        } catch (Exception e) {
            errorLabel.setText("Unexpected error occurred.");
            e.printStackTrace();
        }
    }

    // Called when "Reset" button is pressed
    @FXML
    public void handleReset() {
        // Clear all inputs
        zipField.clear();

        // Reset radio button groups to defaults
        tempCButton.setSelected(true);
        precipMMButton.setSelected(true);
        windKMHButton.setSelected(true);

        // Clear all output labels
        clearLabels();

        // Reset background
        backgroundImage.setImage(new Image(getClass().getResource("/Images/defaultBackground.jpg").toExternalForm()));
    }

    // Method to clear labels
    private void clearLabels() {
        errorLabel.setText("");
        locationLabel.setText("");
        temperatureLabel.setText("");
        feelsLikeLabel.setText("");
        precipitationLabel.setText("");
        windLabel.setText("");
        weatherDescriptionLabel.setText("");
    }

    // Method used to populate labels and change background
    private void displayWeather(LocationData location, WeatherData weather, String tempUnit, String precipUnit, String windUnit) {
        double temperature = weather.temperature;
        double realFeel = weather.realFeel;
        double precipitation = weather.precipitation;
        double windSpeed = weather.windSpeed;

        // Convert temperature units if needed, defaults to C, mm, and and km/h
        String tempSymbol = "°C";
        if (tempUnit.equals("F")) {
            temperature = UnitConverter.celsiusToFahrenheit(temperature);
            realFeel = UnitConverter.celsiusToFahrenheit(realFeel);
            tempSymbol = "°F";
        }

        String precipSymbol = "mm";
        if (precipUnit.equals("IN")) {
            precipitation = UnitConverter.millimetersToInches(precipitation);
            precipSymbol = "in";
        }

        String windSymbol = "km/h";
        if (windUnit.equals("MPH")) {
            windSpeed = UnitConverter.kmhToMph(windSpeed);
            windSymbol = "mph";
        }

        // Populate labels
        locationLabel.setText(location.city + ", " + location.state);
        temperatureLabel.setText(String.format("Temperature: %.1f%s", temperature, tempSymbol));
        feelsLikeLabel.setText(String.format("Feels Like: %.1f%s", realFeel, tempSymbol));
        precipitationLabel.setText(String.format("Precipitation: %.2f %s", precipitation, precipSymbol));
        windLabel.setText(String.format("Wind: %.1f %s %s", windSpeed, windSymbol, weather.windDirectionCompass));
        weatherDescriptionLabel.setText("Condition: " + weather.getWeatherDescription());

        // Change background image based on weather code
        String bgImage = switch (weather.weatherCode) {
            case 0, 1 -> "clear.png";
            case 2, 3 -> "cloudy.png";
            case 45, 48 -> "fog.png";
            case 61, 63, 65, 80, 81, 82 -> "rainy.png";
            case 71, 73, 75 -> "snow.png";
            case 95, 96, 99 -> "storm.png";
            default -> "defaultBackground.jpg";
        };

        backgroundImage.setImage(new Image(getClass().getResource("/Images/" + bgImage).toExternalForm()));
    }
}