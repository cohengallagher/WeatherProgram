/*
 * WeatherData
 * Name: Cohen Gallagher
 * Date: 5/2/2025
 * Class: Programming in Java
 * Description: Used to retrieve weather related information from OpenMeteo API.
 */

public class WeatherData {
    public double temperature;
    public double realFeel;
    public double precipitation;
    public double windSpeed;
    public double windDirection;
    public int weatherCode;
    public String windDirectionCompass;

    public WeatherData(double temperature, double realFeel, double precipitation, double windSpeed, double windDirection, int weatherCode) {
        this.temperature = temperature;
        this.realFeel = realFeel;
        this.precipitation = precipitation;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.weatherCode = weatherCode;
        this.windDirectionCompass = getCompassDirection(windDirection);
    }

    private String getCompassDirection(double angle) {
        String[] directions = {
                "North", "Northeast", "East", "Southeast",
                "South", "Southwest", "West", "Northwest", "North"
        };
        int index = (int) Math.round(angle / 45.0);
        return directions[index % 8];
    }

    public String getWeatherDescription() {
        switch (weatherCode) {
            case 0: return "Clear sky";
            case 1: return "Mainly clear";
            case 2: return "Partly cloudy";
            case 3: return "Overcast";
            case 45: case 48: return "Fog";
            case 51: case 53: case 55: return "Drizzle";
            case 61: case 63: case 65: return "Rain";
            case 66: case 67: return "Freezing rain";
            case 71: case 73: case 75: return "Snow fall";
            case 80: case 81: case 82: return "Rain showers";
            case 95: return "Thunderstorm";
            case 96: case 99: return "Thunderstorm with hail";
            default: return "Unknown weather";
        }
    }

    @Override
    public String toString() {
        return String.format("Temperature: %.1f°C, Real Feel: %.1f°C, Precipitation: %.2fmm, Wind: %.1f km/h %s, Weather: %s",
                temperature, realFeel, precipitation, windSpeed, windDirectionCompass, getWeatherDescription());
    }
}
