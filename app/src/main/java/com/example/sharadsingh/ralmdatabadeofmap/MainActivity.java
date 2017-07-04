package com.example.sharadsingh.ralmdatabadeofmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmConfiguration;
public class MainActivity extends AppCompatActivity {
    ArrayList<Business> listd = new ArrayList<Business>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent in = getIntent();
        if(in!=null){
            String resultObj = in.getStringExtra("data");
            VehicleRoutResponce rsp = new Gson().fromJson(resultObj, VehicleRoutResponce.class);
            VehicleRoutMode[] data = rsp.getData();
            ArrayList<VehicleRoutMode> list = new ArrayList<>(Arrays.asList(data));
            if (list != null && list.size() > 0) {
                setmapDataFromApi(list);
            }
        }
        resetRealm();
        // Sets default realm with sample data module
        Realm.setDefaultConfiguration(getRealmConfig());
        // Loads and adds sample data to realm
        new SFRestaurantDataLoader().loadBusinessSmallDataSet(this,listd);
        setContentView(R.layout.activity_main);
    }
    private void resetRealm() {
        RealmConfiguration realmConfig = new RealmConfiguration
                .Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.deleteRealm(realmConfig);
    }

    private RealmConfiguration getRealmConfig() {
        return new RealmConfiguration
                .Builder(this)
                .modules(Realm.getDefaultModule(), new SFRestaurantModule())
                .build();
    }


    private void setmapDataFromApi(ArrayList<VehicleRoutMode> list) {
        for (VehicleRoutMode p : list) {
            Business business = new Business();
            business.setName("vinay");
            business.setLatitude(Float.parseFloat(String.valueOf(p.getLatValue())));
            business.setLongitude(Float.parseFloat(String.valueOf(p.getLongValue())));
            listd.add(business);

        }

    }

}
