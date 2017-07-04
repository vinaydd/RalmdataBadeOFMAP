package com.example.sharadsingh.ralmdatabadeofmap;

import java.io.Serializable;

/**
 * Created by sharadsingh on 14/06/17.
 */

public class VehicleRoutMode implements Serializable {

    private double latValue;
    private double longValue;
    private String distance;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }



    public double getLatValue() {
        return latValue;
    }

    public void setLatValue(double latValue) {
        this.latValue = latValue;
    }

    public double getLongValue() {
        return longValue;
    }

    public void setLongValue(double longValue) {
        this.longValue = longValue;
    }

}
