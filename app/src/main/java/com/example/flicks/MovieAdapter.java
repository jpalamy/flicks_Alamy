package com.example.flicks;

import android.support.v7.widget.RecyclerView;

import com.example.flicks.models.Movie;

import java.util.ArrayList;

public class MovieAdapter {

    // list of Movie
    ArrayList<Movie> movies;


    // initialize with list
    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    // create the viewHolder as a static inner class
    public static class  ViewHolder extends RecyclerView, RecyclerView.ViewHolder{

    }
}
