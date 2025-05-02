import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ZipcodeConverter {
    public static LocationData getLocationFromZip(int zipCode) {
        // String for connecting to zippopotam.us API
        String apiURL = "https://zippopotam.us/us/" + zipCode;

        try {
            // Create the connection
            URL url = new URL(apiURL);
            System.out.println(apiURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Get response code to confirm there is no errors while fetching data
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
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
                String latitude = jsonResponse.getJSONArray("places").getJSONObject(0).getString("latitude");
                String longitude = jsonResponse.getJSONArray("places").getJSONObject(0).getString("longitude");
                String city = jsonResponse.getJSONArray("places").getJSONObject(0).getString("place name");
                String state = jsonResponse.getJSONArray("places").getJSONObject(0).getString("state");

                // Returns if no errors, else returns null with error messages
                return new LocationData(latitude, longitude, city, state);
            } else {
                System.out.println("Failed to fetch location data. Code: " + responseCode);
            }
        } catch (Exception ex) {
            System.out.println("Error fetching location data: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
}