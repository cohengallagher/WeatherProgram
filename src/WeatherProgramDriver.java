import java.util.Scanner;

public class WeatherProgramDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Weather Program Driver!");
        System.out.print("Let's begin. Enter your country: ");
        String country = scanner.nextLine();

        System.out.print("Perfect. Enter your zip code: ");
        int zipCode = scanner.nextInt();

        LocationData location = ZipcodeConverter.getLocationFromZip(zipCode, country);
        if (location != null) {
            WeatherData weather = WeatherFetcher.getWeather(location.latitude, location.longitude);
            if (weather != null) {
                System.out.println(weather);
            }
        }
    }
}
