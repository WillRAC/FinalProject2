package com.example.finalproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.finalproject.NewsArticle;
import com.example.finalproject.R;

public class DetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news_article, container, false);

        TextView textViewTitleValue = view.findViewById(R.id.textViewTitleValue);
        TextView textViewDescValue = view.findViewById(R.id.textViewDescValue);
        TextView textViewUrlValue = view.findViewById(R.id.textViewUrlValue);

        if (this.getArguments() != null) {

            NewsArticle characterData = (NewsArticle) getArguments().getSerializable("KEY_MODEL_CHARACTER");
            if (characterData != null) {

                String articleTitle = characterData.getArticleTitle();
                String articleDesc = characterData.getArticleDesc();
                String articleUrl = characterData.getArticleUrl();

                // Populate the TextViews with the values from the bundle
                textViewTitleValue.setText(articleTitle);
                textViewDescValue.setText(articleDesc);
                textViewUrlValue.setText(articleUrl);
            }

        }

        return view;
    }
}