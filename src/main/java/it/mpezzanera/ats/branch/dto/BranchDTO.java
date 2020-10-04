package it.mpezzanera.ats.branch.dto;

import java.io.Serializable;


public class BranchDTO implements Serializable {

    private String type;
    private String distance;
    private AddressDTO address;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
