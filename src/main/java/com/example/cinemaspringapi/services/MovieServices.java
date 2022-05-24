package com.example.cinemaspringapi.services;

import com.example.cinemaspringapi.model.Movie;

import java.util.List;

public interface MovieServices {
    List<Movie> getAllMovie();
    Movie getMovieByUrlId(String urlId);
    Movie addMovie(Movie movie);
    Movie updateMovie(Movie movie);
    void deleteMovie(String id);
}
