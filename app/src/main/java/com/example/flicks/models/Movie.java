package com.example.flicks.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie {

    // values from API
    private String title;
    private String overview;
    private String poster_path; // only the path

    // initialize from JSON data
    public Movie(JSONObject object) throws JSONException {
        title = object.getString("title");
        overview = object.getString("overview");
        poster_path = object.getString("poster_path");
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return poster_path;
    }
}
