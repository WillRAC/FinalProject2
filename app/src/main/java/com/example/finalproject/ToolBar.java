package com.example.finalproject;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.snackbar.Snackbar;

public class ToolBar extends AppCompatActivity {

    ImageButton homeicon;
    ImageButton searchicon;
    ImageButton infoicon;
    ImageButton exiticon;

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar);

        homeicon = findViewById(R.id.homeIcon);

        homeicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToolBar.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        searchicon = findViewById(R.id.searchIcon);

        searchicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToolBar.this, MainActivity.class);
                startActivity(intent);
            }
        });
        infoicon = findViewById(R.id.infoIcon);

        infoicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToolBar.this, InfoActivity.class);
                startActivity(intent);
            }
        });
        exiticon = findViewById(R.id.searchIcon);

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
