package com.example.cinemaspringapi.services;

import com.example.cinemaspringapi.model.Movie;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class MovieServicesImpl implements MovieServices{
    @Override
    public List<Movie> getAllMovie() {
        List<Movie> movies = new ArrayList<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference collectionReference = dbFirestore.collection("movies");
        // mot collection bao gom nhieu document
        // snapshot bao gom metadata va data
        // lay snapshot collection
        ApiFuture<QuerySnapshot> future = collectionReference.get();
        QuerySnapshot querySnapshot = null;
        try {
            querySnapshot = future.get();
            // lay snapshot cac documents trong collection
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                Movie movie = document.toObject(Movie.class);
                movie.setId(document.getId());
                movies.add(movie);
            }

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public Movie getMovieByUrlId(String urlId) {
        Movie movie = new Movie();
        try {
            Firestore db = FirestoreClient.getFirestore();
            // query by urlId
            ApiFuture<QuerySnapshot> future = db.collection("movies").whereEqualTo("urlId", urlId).get();
            QuerySnapshot querySnapshot = future.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

            movie = documents.get(0).toObject(Movie.class);
            movie.setId(documents.get(0).getId());
        }  catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return movie;
    }

    @Override
    public Movie addMovie(Movie movie) {
        return null;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return null;
    }

    @Override
    public void deleteMovie(String id) {
    }
}
