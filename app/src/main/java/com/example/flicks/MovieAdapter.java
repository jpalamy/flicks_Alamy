package com.example.flicks;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flicks.models.Config;
import com.example.flicks.models.Movie;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    // list of Movie
    ArrayList<Movie> movies;
    // config needed for image urls
    Config config;
    // context for rendering
    Context context;


    // initialize with list
    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
        
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    // creates and inflates a new view
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        // get the context and create the inflater
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // create the view using the item_movie layout
        View movieView = inflater.inflate(R.layout.item_movie, parent, false);
        // return a new view Holder
        return new ViewHolder(movieView);
    }

    // blinds and inflated view to a new item
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // get the movie data at the specified position
        Movie movie = movies.get(position);
        // populate the view with the movie data
        holder.tVTitle.setText(movie.getTitle());
        holder.tvOverview.setText(movie.getOverview());

        // determine the current orientation
        boolean isPortrait = context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;

        // build url for poster image
        String imageUrl = null;
        // if in portrait mode, load the poster image
        if (isPortrait) {
            imageUrl = config.getImageUrl(config.getPosterSize(), movie.getPosterPath());
        } else {
            // load the backdrop image
            imageUrl = config.getImageUrl(config.getBackdropSize(), movie.getBackdropPath());
        }

        // get the correct placeholder and imageView for the current orientation
        // load image using glide
        int placeholderId = isPortrait ? R.drawable.flicks_movie_backdrop_placeholder: R.drawable.flicks_backdrop_placeholder2;
        ImageView imageView = isPortrait ? holder.ivPosterImage : holder.ivBackdropImage;
        Glide.with( context )
                .load( imageUrl )
                .bitmapTransform(new RoundedCornersTransformation(context, 25,0))
                .placeholder(placeholderId)
                .error (placeholderId)
                .into (imageView);

                
    }

    // returns the total number of items in the list
    @Override
    public int getItemCount() { return movies.size(); }

    // create the viewHolder as a static inner class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // track view objects
        ImageView ivPosterImage;
        ImageView ivBackdropImage;
        TextView tVTitle;
        TextView tvOverview;
        public ViewHolder(View itemView) {
            super(itemView);
            // lookup view objets by id
            ivPosterImage = itemView.findViewById(R.id.ivPosterImage);
            ivBackdropImage = (ImageView) itemView.findViewById(R.id.ivBackropImage);
            tvOverview = (TextView) itemView.findViewById(R.id.tvOverview);
            tVTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}