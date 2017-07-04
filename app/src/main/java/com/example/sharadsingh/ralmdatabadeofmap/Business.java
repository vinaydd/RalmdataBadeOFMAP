package com.example.sharadsingh.ralmdatabadeofmap;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by sharadsingh on 03/07/17.
 */

public class Business extends RealmObject {
    private String name;
    private float latitude;

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    private float longitude;
    public Business(int id, String name, float latitude, float longitude) {

        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public Business() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getLatitude() {
        return latitude;
    }
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

}