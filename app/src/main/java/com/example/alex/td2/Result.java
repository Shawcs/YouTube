package com.example.alex.td2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
    final ObjectMapper mapper = new ObjectMapper();
    //here we build the query for the get methode
String search_id; //this is the search world you type in the first page
    String KEY="AIzaSyAN_vNoKojmtZi2Uyq4Vfnj9HlsnEo8YEg";
    String s ="https://www.googleapis.com/youtube/v3/search?q=";
    String z="&key=";
    String finaly="&part=snippet";

    List<youtubeJSON> data;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public void parse() {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, s+search_id+z+KEY+finaly,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                               youtubeJSON video_data= mapper.readValue(response, youtubeJSON.class);
                                data.addAll(Arrays.asList(video_data));
                                mAdapter.notifyDataSetChanged();
                            }
                            catch (IOException e) {
                                Log.d("jackson",e.getMessage());
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
    MyApplication.getRequestQueue().add(stringRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String search_result = getIntent().getStringExtra("search");
        search_id=search_result;
        data = new ArrayList<youtubeJSON>();
        super.onCreate(savedInstanceState);
        parse();
        setContentView(R.layout.recycler_vue);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapteur(data);
        mRecyclerView.setAdapter(mAdapter);
    }
}

