package Models;

/**
 * Created by Mgr studio on 24/12/2018.
 */

public class vegHotelModel {
    String imgurl;

   String desc;

    public vegHotelModel(String imgurl, String desc,String hotelName, Double lat, Double lan) {
        this.imgurl = imgurl;
        this.desc = desc;
        this.lat = lat;
        this.lan = lan;
        HotelName = hotelName;
    }

    Double lat,lan;

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
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

    public Double getLan() {
        return lan;
    }

    public void setLan(Double lan) {
        this.lan = lan;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    String HotelName;
}
