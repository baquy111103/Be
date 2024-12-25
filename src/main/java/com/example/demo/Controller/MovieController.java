package com.example.demo.Controller;

import com.example.demo.Model.Episode;
import com.example.demo.Model.Movie;
import com.example.demo.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/type")
    public ResponseEntity<List<Movie>> getMoviesByType(@RequestParam Boolean type) {
        List<Movie> movies = movieService.getMoviesByType(type);

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(
            @RequestParam(required = false) String movie_name,
            @RequestParam(required = false) String movie_genre,
            @RequestParam(required = false) Boolean type) {

        List<Movie> movies = movieService.searchMovies(movie_name, movie_genre, type);

        return ResponseEntity.ok(movies);
    }


//    @GetMapping("/{id}/episodes")
//    public ResponseEntity<List<Episode>> getEpisodesByMovieCode(@PathVariable String movie_code) {
//        return ResponseEntity.ok(movieService.getEpisodesByMovieCode(movie_code));
//    }
}
