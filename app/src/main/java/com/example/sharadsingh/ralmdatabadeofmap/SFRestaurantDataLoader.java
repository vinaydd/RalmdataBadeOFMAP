package com.example.sharadsingh.ralmdatabadeofmap;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import io.realm.Realm;

/**
 * Created by sharadsingh on 03/07/17.
 */

public class SFRestaurantDataLoader {
    private static final int DATA_SET_SMALL_NUM = 500;

    public final void loadBusinessSmallDataSet(Context context ,ArrayList<Business> map_list) {
        loadBusinessesData(context, DATA_SET_SMALL_NUM,map_list);
    }
    public final void loadBusinessesData(Context context, int limit,ArrayList<Business>list) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(list);
        realm.commitTransaction();
        realm.close();
    }

    private String removeQuotes(String original) {
        return original.subSequence(1, original.length() - 1).toString();
    }
}