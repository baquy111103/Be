package com.example.demo.Controller;

import com.example.demo.DTO.Episode_DTO;
import com.example.demo.DTO.MovieDTO;
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
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/type")
    public ResponseEntity<List<MovieDTO>> getMoviesByType(@RequestParam Boolean type) {
        List<MovieDTO> movieDTOs = movieService.getMoviesByType(type);
        return ResponseEntity.ok(movieDTOs);
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieDTO>> searchMovies(
            @RequestParam(required = false) String movie_name,
            @RequestParam(required = false) String movie_genre,
            @RequestParam(required = false) String actor_name) {

        List<MovieDTO> movies = movieService.searchMovies(movie_name, movie_genre, actor_name);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/details/{movie_code}")
    public ResponseEntity<MovieDTO> getMovieDetails(@PathVariable String movie_code) {
        MovieDTO movie = movieService.getMovieByCode(movie_code);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/hot")
    public ResponseEntity<List<MovieDTO>> getHotMovies() {
        List<MovieDTO> hotMovies = movieService.getHotMovies();
        return ResponseEntity.ok(hotMovies);
    }

    @GetMapping("/episodes")
    public ResponseEntity<List<Episode>> getAllEpisodesByMovieCode(@RequestParam String movie_code) {
        List<Episode> episodes = movieService.getAllEpisodesByMovieCode(movie_code);

        if (episodes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(episodes); // Trả về danh sách tập phim theo movie_code
    }
}
