package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.example.finalproject.fragments.ArticleListFragment;
import com.example.finalproject.fragments.DetailsFragment;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.EditTextSearch);
        Button button = findViewById(R.id.SearchButton);

        Toolbar toolbar = findViewById(R.id.toolbarmain);

        ImageButton homeicon;
        ImageButton searchicon;
        ImageButton infoicon;
        ImageButton exiticon;

        homeicon = findViewById(R.id.homeIcon);

        homeicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        searchicon = findViewById(R.id.searchIcon);

        searchicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        infoicon = findViewById(R.id.infoIcon);

        infoicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
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


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchUrl = editText.getText().toString();
            }
        });
    }

    private void codeToSetUpListFragment() {

        FragmentTransaction ftFragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        ftFragmentTransaction.add(R.id.frameLayoutMainContainer, new ArticleListFragment());
        ftFragmentTransaction.commit();

    }

    private void codeToSetUpDetailFragmentOnPhoneMode(NewsArticle selectedArticle) {

        Bundle detailFragmentArguments = new Bundle();
        detailFragmentArguments.putSerializable("KEY_MODEL_ARTICLE", selectedArticle);

        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(detailFragmentArguments);

        FragmentTransaction ftFragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        ftFragmentTransaction.replace(R.id.frameLayoutMainContainer, detailsFragment);
        ftFragmentTransaction.addToBackStack(null);
        ftFragmentTransaction.commit();

    }
    public void codeToSetUpDetailsFragmentOnPhoneMode(NewsArticle selectedArticle) {
        codeToSetUpDetailFragmentOnPhoneMode(selectedArticle);
    }

}