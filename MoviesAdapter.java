package com.example.student.movieapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.student.movieapp.R;
import com.example.student.movieapp.model.Movie;
import com.example.student.movieapp.model.MovieResult;
import com.example.student.movieapp.model.Result;

import java.util.List;

/**
 * This class is responsible for styling items in the RecyclerView
 * Created by student on 7/15/2017.
 */
public class MoviesAdapter  extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Result> moviesList;
    private String posterPath = "http://image.ttmdb.org/t/p/w500";

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView posterImageView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            posterImageView =(ImageView) view.findViewById(R.id.image_view_poster);


        }
    }

    private Context mContext;
    public MoviesAdapter(Context context, List<Result> moviesList) {
        this.moviesList = moviesList;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Result movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getOverview());
        holder.year.setText(movie.getReleaseDate());

        Glide.with(mContext)
                .load(posterPath + movie.getPosterPath())
                .into(holder.posterImageView);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}


