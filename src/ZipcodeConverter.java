import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class ZipcodeConverter {
    int zipCode;
    String country;
        try{
            String apiURL = "https://zippopotam.us/" + country + "/" + zipCode;
            URL url = new URL(apiURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200){
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null){
                    content.append(inputLine);
                }

                in.close();
                conn.disconnect();

                // Parse the response
                JSONObject jsonResponse = new JSONObject(content.toString());
                String latitude = jsonResponse.getJSONArray("places").getJSONObject(0).getString("latitude");
                String longitude = jsonResponse.getJSONArray("places").getJSONObject(0).getString("longitude");
                String city = jsonResponse.getJSONArray("places").getJSONObject(0).getString("city");
                if(country == "us") {
                    String state = jsonResponse.getJSONArray("places").getJSONObject(0).getString("state");
                }
                try {
                    String meteoURL = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&" + longitude + "=-97.42&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m" ;
                    URL meteoUrl = new URL(meteoURL);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                }
            }
        }
    }

}
