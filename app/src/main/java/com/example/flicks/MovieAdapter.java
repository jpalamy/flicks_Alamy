package com.example.flicks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flicks.models.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    // list of Movie
    ArrayList<Movie> movies;

    // creates and inflates a new view
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    // blinds and inflated view to a new item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    // returns the total number of items in the list
    @Override
    public int getItemCount() {
        return movies.size();
    }

    // initialize with list
    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;


    }

    // create the viewholder as a static inner class
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // track view objets
        ImageView ivPosterImage;
        TextView tVTitle;
        TextView tvOverview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // lookup view objets by id
            ivPosterImage = itemView.findViewById(R.id.ivPosterImage);
            tvOverview = itemView.findViewById(R.id.tVOverview);
            tVTitle = itemView.findViewById(R.id.tVTitle);

        }
    }
}
