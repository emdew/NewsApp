package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Emily on 9/28/17.
 */

public class ArticleAdapter extends ArrayAdapter<Article> {

    private static final String DATE_TIME_SEPARATOR = "T";
    // Variables for splitting the date and time.
    private String date;
    private String time;
    // Variables for splitting title and contributor
    private String title;
    private String contributor;

    // Constructor
    public ArticleAdapter(Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Find the article at the given position in the list of articles
        Article currentArticle = getItem(position);

        // Find TextView with the ID "section_tv"
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section_tv);
        // Display text in TextView
        sectionView.setText(currentArticle.getSection());

                    /**  Code for splitting the title and contributor **/
        // Get the title and contributor which are contained in the same string but separated by " | "
        // Not every article contains the contributor so check first
        String titleAndContributor = currentArticle.getTitle();

        // Check whether the titleAndContributor string contains the " | " text
        if (titleAndContributor.contains(" | ")) {

            String[] parts = titleAndContributor.split("\\|");
            // Could keep the " | " by simply putting parts[0] + " | ";
            title = parts[0];
            contributor = parts[1];

        } else {
            title = titleAndContributor;
            contributor = null;
        }

        // Find TextView with the ID "title_tv"
        TextView titleView = (TextView) listItemView.findViewById(R.id.title_tv);
        // Display text in TextView
        titleView.setText(title);

        // Find TextView with the ID "title_tv"
        TextView contributorView = (TextView) listItemView.findViewById(R.id.contributor_tv);
        // Display text in TextView
        contributorView.setText(contributor);
                    /**  End code for splitting the title and contributor **/

                    /**  Code for splitting the date and time **/
        // Get the date and time which are contained in the same string i.e. "2017-08-17T15:16:54Z"
        String dateAndTime = currentArticle.getDate();

        // Split the string into different parts (as an array of Strings) based on the "T" text.
        String[] parts = dateAndTime.split(DATE_TIME_SEPARATOR);
        date = parts[0];
        time = parts[1].replace("Z", "");

        // Find TextView with the ID "date"
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Display text in TextView
        dateView.setText(date);

        // Find TextView with the ID "time"
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Display text in TextView
        timeView.setText(time);
                    /** End code for splitting date and time **/

        return listItemView;
    }
}
