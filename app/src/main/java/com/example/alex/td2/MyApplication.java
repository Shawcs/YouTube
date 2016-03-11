package com.example.alex.td2;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by alex on 29/01/2016.
 */
public class MyApplication extends Application {

    private static RequestQueue requestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(this);
    }
    public static RequestQueue getRequestQueue(){
        return requestQueue;
    }
}