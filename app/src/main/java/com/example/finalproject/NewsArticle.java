package com.example.finalproject;

import java.io.Serializable;

public class NewsArticle implements Serializable {

    private String articleTitle;

    private  String articleDesc;

    private String articleUrl;


    public NewsArticle() {}

    public String getArticleTitle() { return articleTitle; }
    public String setArticleTitle(String articleTitle) {this.articleTitle = articleTitle; }

    public String getArticleDesc() { return articleDesc; }
    public String setArticleDesc(String articleDesc) {this.articleDesc = articleDesc; }

    public String getArticleUrl() { return articleUrl; }
    public String setArticleUrl(String articleUrl) {this.articleUrl = articleUrl; }

}
