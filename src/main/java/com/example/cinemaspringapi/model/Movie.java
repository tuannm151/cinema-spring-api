package com.example.cinemaspringapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.cloud.firestore.DocumentReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.beans.Transient;
import java.util.List;
@NoArgsConstructor
@Setter
@Getter
public class Movie {
    private String id;
    private String title;
    private String urlId;
    private String description;
    private String trailerUrl;
    private String imageUrl;
    private String coverUrl;
    private Integer duration;
    private String genres;
    private String ratingPath;
    private String ageRating;
    private String status;
    private String releaseDate;

    @JsonIgnore
    private DocumentReference ratingRef;


    public List<String> getGenres() {
        return List.of(genres.split(","));
    }
    public String getRatingPath() {
        return ratingRef.getPath();
    }

}
