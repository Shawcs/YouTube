package com.example.alex.td2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alex on 22/01/2016.
 */
public class Result extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyAdapteur mAdapter;

    private List<youtubeJSON> data;

    private final ObjectMapper mapper = new ObjectMapper();
    private String mApiUrl = "https://www.googleapis.com/youtube/v3/search?part=snippet&key=AIzaSyAN_vNoKojmtZi2Uyq4Vfnj9HlsnEo8YEg&type=video&q=";


    private void initList() {

        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        data = new ArrayList<>();

        mAdapter = new MyAdapteur(data,this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
        downloadResults(i.getStringExtra("search").replaceAll(" ", "+"));
    }

    private void downloadResults(String search) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, mApiUrl + search,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            YoutubeRequestResult result = mapper.readValue(response, YoutubeRequestResult.class);
                            data.addAll(Arrays.asList(result.items));
                            mAdapter.notifyDataSetChanged();
                            Log.d("jackson", " length : " + data.size());
                            Log.d("jackson", "add all contract");

                        } catch (IOException e) {
                            Log.d("jackson", e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });
        MyApplication.getRequestQueue().add(stringRequest);
    }

}
