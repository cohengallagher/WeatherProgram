import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherFetcher {

    public static WeatherData getWeather(String latitude, String longitude){

        // String for connecting to OpenMeteo API
        String meteoURL = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude +
                "&longitude=" + longitude +
                "&current=temperature_2m,apparent_temperature,precipitation,wind_speed_10m,wind_direction_10m";


        try {
            // Create the connection
            URL url = new URL(meteoURL);
            System.out.println(meteoURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Get response code to confirm there is no errors while fetching data
            int responseCode = conn.getResponseCode();
            if (responseCode == 200){
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder content = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                in.close();
                conn.disconnect();

                // Parse the response from the API
                JSONObject jsonResponse = new JSONObject(content.toString());
                JSONObject current = jsonResponse.getJSONObject("current");
                double temperature = current.getDouble("temperature_2m");
                double realFeel = current.getDouble("apparent_temperature");
                double precipitation = current.getDouble("precipitation");
                double windSpeed = current.getDouble("wind_speed_10m");
                double windDirection = current.getDouble("wind_direction_10m");

                // Returns if no errors, else returns null with error messages
                return new WeatherData(temperature, realFeel, precipitation, windSpeed, windDirection);
            } else {
                System.out.println("Failed to fetch weather data. Code: " + responseCode);
            }
        } catch (Exception ex) {
            System.out.println("Error fetching weather data: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
}