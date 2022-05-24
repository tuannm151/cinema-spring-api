package com.example.cinemaspringapi.controller;

import com.example.cinemaspringapi.model.Movie;
import com.example.cinemaspringapi.services.MovieServices;
import com.example.cinemaspringapi.services.MovieServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/api/movies",produces = "application/json")
public class MovieController {
    private final MovieServices movieServices;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovie(){
        return ResponseEntity.ok().body(movieServices.getAllMovie());
    }
    @GetMapping(value= "{urlId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String urlId){
        return ResponseEntity.ok().body(movieServices.getMovieByUrlId(urlId));
    }
}



