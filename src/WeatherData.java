public class WeatherData {
    private String location;
    private double temperature;
    private String weatherDescription;
    private String state;
    private String city;
    private String country;
    private double windDirection;
    private double windSpeed;

    public WeatherData(String location, double temperature, String weatherDescription, String state, String city, String country, double windDirection, double windSpeed) {
        this.location = location;
        this.temperature = temperature;
        this.weatherDescription = weatherDescription;
        this.state = state;
        this.city = city;
        this.country = country;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }

    public String getLocation() {
        return location;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    // Helper method to convert degrees (angles) to wind direction
    private String getCompassDirection(double angle){
        String[] directions = {"North", "Northeast", "East", "Southeast",
                "South", "Southwest", "West", "Northwest", "North"};
        return directions[(int)Math.round(((angle % 360) / 45))];
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "location='" + location + '\'' +
                ", temperature=" + temperature +
                ", weatherDescription='" + weatherDescription + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", windDirection=" + windDirection +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
