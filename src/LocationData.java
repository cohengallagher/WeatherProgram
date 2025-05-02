/*
 * LocationData
 * Name: Cohen Gallagher
 * Date: 5/2/2025
 * Class: Programming in Java
 * Description: Used to retrieve location and latitude and longitude from zippopotam.us API.
 */

public class LocationData {
    public String latitude;
    public String longitude;
    public String city;
    public String state;

    public LocationData(String latitude, String longitude, String city, String state) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.state = state;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
