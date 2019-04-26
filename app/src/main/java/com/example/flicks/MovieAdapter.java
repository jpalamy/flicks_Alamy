package com.example.flicks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // track view objets
        ImageView ivPosterImage;
        TextView tVTitle;
        TextView tvOverview;

        public ViewHolder(View itemView) {
            super(itemView);
            // lookup view objets by id
            ivPosterImage = itemView.findViewById(R.id.ivPosterImage);
            

        }
    }
}
