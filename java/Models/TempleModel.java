package Models;

import android.content.Context;

import java.util.List;

/**
 * Created by Mgr studio on 26/12/2018.
 */

public class TempleModel {
    String ImageUrl;

    public TempleModel(String imageUrl, String templeName, String description, Double lat, Double lon) {
        ImageUrl = imageUrl;
        TempleName = templeName;
        Description = description;
        this.lat = lat;
        this.lon = lon;
    }


    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getTempleName() {
        return TempleName;
    }

    public void setTempleName(String templeName) {
        TempleName = templeName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

    String TempleName;
    String Description;
    Double lat,lon;
}
