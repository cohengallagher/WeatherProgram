public class WeatherData {
    public double temperature;
    public double realFeel;
    public double precipitation;
    public double windSpeed;
    public double windDirection; // in degrees
    public String windDirectionCompass; // e.g., "NE", "Southwest"

    public WeatherData(double temperature, double realFeel, double precipitation, double windSpeed, double windDirection) {
        this.temperature = temperature;
        this.realFeel = realFeel;
        this.precipitation = precipitation;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.windDirectionCompass = getCompassDirection(windDirection);
    }

    // Converts degrees to compass direction (North appears twice)
    private String getCompassDirection(double angle) {
        String[] directions = {
                "North", "Northeast", "East", "Southeast",
                "South", "Southwest", "West", "Northwest", "North"
        };
        int index = (int) Math.round(((angle % 360) / 45));
        return directions[index];
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "temperature=" + temperature +
                ", realFeel=" + realFeel +
                ", precipitation=" + precipitation +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", windDirectionCompass='" + windDirectionCompass + '\'' +
                '}';
    }
}