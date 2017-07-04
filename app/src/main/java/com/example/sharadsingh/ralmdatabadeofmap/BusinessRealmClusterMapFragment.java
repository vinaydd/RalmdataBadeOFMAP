package com.example.sharadsingh.ralmdatabadeofmap;

import co.moonmonkeylabs.realmmapview.RealmClusterMapFragment;


/**
 * Implementation of {@link RealmClusterMapFragment} for the {@link Business} class/Realm.
 */
public class BusinessRealmClusterMapFragment extends RealmClusterMapFragment<Business> {

    @Override
    protected String getTitleColumnName() {
        return "name";
    }

    @Override
    protected String getLatitudeColumnName() {
        return "latitude";
    }

    @Override
    protected String getLongitudeColumnName() {
        return "longitude";
    }
}
