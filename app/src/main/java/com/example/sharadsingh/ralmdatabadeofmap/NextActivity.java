package com.example.sharadsingh.ralmdatabadeofmap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.realm.Realm;

/**
 * Created by sharadsingh on 03/07/17.
 */

public class NextActivity extends AppCompatActivity {
    String Data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_layout);
        Button button = (Button) findViewById(R.id.send);
        try {
            getRoutData("http://crm.truxapp.com/truxapiv2/transport/getVehicleRoute");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NextActivity.this, MainActivity.class);
                intent.putExtra("data", Data);
                startActivity(intent);
            }
        });
    }
    private void getRoutData(String url) throws ParseException {
        String URL = url;
        final RequestQueue queue = Volley.newRequestQueue(this);
        queue.getCache().remove(URL);
        queue.getCache().clear();
        JSONObject jsonobject_one = new JSONObject();
        try {
            jsonobject_one.put("vtsDeviceId", "100101");
            jsonobject_one.put("startDate", " 2017-07-03");
            jsonobject_one.put("endDate", " 2017-07-03");
            jsonobject_one.put("vehicleNumber", "UP14DB9090");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonobject_one, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject resultJson) {
                String resultObj = resultJson.toString();
                try {
                    if (resultObj.equals("")) {
                        return;
                    }
                    JSONObject resultObject = new JSONObject(resultObj);
                     Data =  resultObj;
                    VehicleRoutResponce rsp = new Gson().fromJson(resultObj, VehicleRoutResponce.class);
                    if (resultObject.getString("errorCode").equals("100")) {
                        VehicleRoutMode[] data = rsp.getData();
                        ArrayList<VehicleRoutMode> list = new ArrayList<>(Arrays.asList(data));
                        if (list != null && list.size() > 0) {
                        } else {

                            //MainActivity.showSnackBar(findViewById(R.id.show_error),RouteMapsActivity.this, rsp.getErrorMesaage());
                        }
                    } else {

                        // MainActivity.showSnackBar(findViewById(R.id.show_error),RouteMapsActivity.this, rsp.getErrorMesaage());
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
            }

        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError, NullPointerException {
                Map<String, String> params = new HashMap<>();
                params.put("authKey","cYHVUWQFO7CHYwQrQ1x99OXrDtR/hzko7jOoIFd1yCcARfjmPNH1kAyRjUZZmWU+");
                return params;
            }
        };
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(300000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(jsObjRequest);
        //  {"vtsDeviceId":"358956063505896","startDate":"","endDate":"","vehicleNumber":"UP200002"}

    }



}