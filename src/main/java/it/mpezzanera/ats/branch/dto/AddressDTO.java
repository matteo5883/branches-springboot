package it.mpezzanera.ats.branch.dto;

import java.io.Serializable;

public class AddressDTO implements Serializable {

    private String street;
    private int houseNumber;
    private String postalcode;
    private String city;
    private GeoLocationDTO geoLocation;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public GeoLocationDTO getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocationDTO geoLocation) {
        this.geoLocation = geoLocation;
    }
}
