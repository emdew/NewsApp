package com.example.android.newsapp;

/**
 * Created by Emily on 9/27/17.
 */

public class Article {

    // Article section
    private String mSection;

    // Article title
    private String mTitle;

    // Book title
    private String mDate;

    // Book author
    private String mUrl;

    // Create a new Article object
    public Article(String section, String title, String date, String url) {
        mSection = section;
        mTitle = title;
        mDate = date;
        mUrl = url;
    }

    // Get the section of the news article.
    public String getSection() {
        return mSection;
    }

    // Get the title of the article.
    public String getTitle() {
        return mTitle;
    }

    // Get the date the article was written.
    public String getDate() {
        return mDate;
    }

    // Get the url of the article.
    public String getUrl() {
        return mUrl;
    }
}
