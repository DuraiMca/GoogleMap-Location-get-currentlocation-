package Models;

/**
 * Created by Mgr studio on 27/12/2018.
 */

public class TouristModel {
    String Place;

    public TouristModel(String place, String description, String url, Double lat, Double lon) {
        Place = place;
        Description = description;
        this.url = url;
        this.lat = lat;
        this.lon = lon;
    }

    String Description;
    String url;

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    Double lat;
    Double lon;
}
