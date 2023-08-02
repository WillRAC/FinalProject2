package com.example.finalproject;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ToolBar extends AppCompatActivity {

    Button homeicon;
    Button searchIcon;
    Button infoicon;
    Button exiticon;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar);

        homeicon = findViewById(R.id.homeIcon);

        homeicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                activityLauncher.launch(intent);
            }
        });
        searchIcon = findViewById(R.id.searchIcon);
        infoicon = findViewById(R.id.infoIcon);
        exiticon = findViewById(R.id.searchIcon);

    }
}
