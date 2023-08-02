package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class InfoActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        ImageButton homeicon;
        ImageButton searchicon;
        ImageButton infoicon;
        ImageButton exiticon;

        homeicon = findViewById(R.id.homeIcon);

        homeicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        searchicon = findViewById(R.id.searchIcon);

        searchicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        infoicon = findViewById(R.id.infoIcon);

        infoicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
        exiticon = findViewById(R.id.exitIcon);

        exiticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Are you sure you want to close the app?", Snackbar.LENGTH_LONG)
                        .setAction("Yes", new View.OnClickListener() {
                            public void onClick(View v) {
                                finish();
                            }
                        })
                        .show();
            }
        });
    }
}
