package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(value = "/movie")
    public ResponseEntity<String> create(@RequestBody Movie movie) {
        movieService.create(movie);
        return ResponseEntity.ok(movie.getTitle()+ " movie is Created");
    }

    @GetMapping(value = "/movie/{id}")
    public ResponseEntity<Movie> find(@PathVariable(value = "id") int movieID) {
        Movie movie = movieService.findByID(movieID);
        return ResponseEntity.ok(movie);
    }
    @GetMapping(value = "/movie")
    public ResponseEntity<List<Movie>> findAll() {
        List<Movie> movieList = movieService.findAll();
        return ResponseEntity.ok(movieList);
    }

    @PutMapping(value = "movie/{id}")
    public ResponseEntity<String> update(@PathVariable(value = "id") int movieID, @RequestBody Movie movie) {
        movieService.update(movieID, movie);
        return ResponseEntity.ok(movie.getTitle()+ " movie is Updated");
    }

    @DeleteMapping(value = "/movie/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") int movieID) {
        movieService.delete(movieID);
        return ResponseEntity.ok("Seleced movie was deleted");
    }


}
