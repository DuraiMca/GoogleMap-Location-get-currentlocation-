package Models;

/**
 * Created by Mgr studio on 27/12/2018.
 */

public class NonVegHotelModel {
    String HotelName;
    String url;

    public NonVegHotelModel(String hotelName, String url, String desc, Double lat, Double lon) {
        HotelName = hotelName;
        this.url = url;
        this.desc = desc;
        this.lat = lat;
        this.lon = lon;
    }

    String desc;

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    Double lat,lon;  //latitute and longtitute
}
