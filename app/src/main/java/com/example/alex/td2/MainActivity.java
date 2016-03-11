package com.example.alex.td2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final static  String SEARCH="search";
    private EditText urlText;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlText = (EditText) findViewById(R.id.myUrl);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
public void onLaunch(View v){
    Intent i = new Intent(this,  Result.class);
    String searchText = urlText.getText().toString();
    i.putExtra("search", searchText);
    startActivity(i);

}


    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,  Result.class);
        String searchText = urlText.getText().toString();
        i.putExtra("search", searchText);
        startActivity(i);
    }
}
