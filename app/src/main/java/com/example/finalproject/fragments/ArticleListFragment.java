package com.example.finalproject.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.AdapterListCharacterName;
import com.ModelCharacter;
import com.example.finalproject.NewsArticle;
import com.example.finalproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ArticleListFragment extends Fragment {

    private final static String NEWS_URL = "https://content.guardianapis.com";

    private InterfaceMain interMain;

    private FrameLayout frameLayoutDetailView;

    private ListView lstArticles;

    private Context coxContext;

    private List<NewsArticle> articles;

    private String searchUrl = "";


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            interMain  = (InterfaceMain) context;
        } catch (ClassCastException ccex) {
            ccex.printStackTrace();
        }

        this.coxContext = context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View listView = inflater.inflate(R.layout.fragment_list, container, false);

        frameLayoutDetailView = (FrameLayout) listView.findViewById(R.id.fragmentCharacterDetail);

        lstArticles = (ListView) listView.findViewById(R.id.theList);

        // Execute the AsyncTask to query the Star Wars API
        NewsListTask req = new NewsListTask();
        req.execute();

        return listView;
    }

    public void setSearchUrl(String searchUrl){

        this.searchUrl = searchUrl;
    }



    private void loadListItemsOntoListView(List<NewsArticle> articles) {

        lstArticles.setAdapter(new AdapterListCharacterName(coxContext, android.R.layout.simple_list_item_1, articles));
        lstArticles.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                NewsArticle selectedCharacter = articles.get(position);

                if (frameLayoutDetailView != null) {
                    // We're in tablet mode

                    if (interMain != null) {
                        interMain.codeToSetUpDetailsFragmentOnTabletMode(selectedCharacter);
                    }

                } else {
                    // We're in phone mode

                    if (interMain != null) {
                        interMain.codeToSetUpDetailsFragmentOnPhoneMode(selectedCharacter);
                    }

                }

            }

        });

    }


    private class NewsListTask extends AsyncTask<String, Integer, List<NewsArticle>> {

        @Override
        protected List<NewsArticle> doInBackground(String... args) {


            try {

                URL url = new URL(NEWS_URL + "/search?q=" + searchUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();


                // Read the response
                InputStream inputStream = connection.getInpu
                tStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                String result = sb.toString();

                Log.e("FRAGMENTS", "result: " + result);    //  TODO: For TESTING ONLY


                JSONObject jsonResponse = new JSONObject(result);
                Log.e("FRAGMENTS", "jsonResponse: " + jsonResponse);    //  TODO: For TESTING ONLY

                JSONArray resultsArray = jsonResponse.getJSONArray("results");
                Log.e("FRAGMENTS", "resultsArray: " + resultsArray);    //  TODO: For TESTING ONLY

                articles = new ArrayList<>();

                for (int i = 0; i < resultsArray.length(); i++) {

                    JSONObject articleObject = resultsArray.getJSONObject(i);
                    String articleTitle = articleObject.getString("title");
                    String articleDesc = articleObject.getString("description");
                    String articleUrl = articleObject.getString("link");

                    NewsArticle newsArticle = new NewsArticle();
                    newsArticle.setArticleTitle(articleTitle);
                    newsArticle.setArticleDesc(articleDesc);
                    newsArticle.setArticleUrl(articleUrl);

                    articles.add(newsArticle);

                    Log.e("FRAGMENTS", "articles: " + articles.size());    //  TODO: For TESTING ONLY

                }


            } catch (MalformedURLException muex) {
                muex.printStackTrace();
            } catch (JSONException jsex) {
                jsex.printStackTrace();
            } catch (IOException ioex) {
                ioex.printStackTrace();
            }

            return articles;
        }


        @Override
        public void onProgressUpdate(Integer... args) {
        }


        @Override
        protected void onPostExecute(List<NewsArticle> articles) {
            super.onPostExecute(articles);

            loadListItemsOntoListView(articles);

        }

    }
}
