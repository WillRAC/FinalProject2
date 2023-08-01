package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.finalproject.fragments.ArticleListFragment;
import com.example.finalproject.fragments.DetailsFragment;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.EditTextSearch);
        Button button = findViewById(R.id.SearchButton);

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