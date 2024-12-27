package com.example.demo.Service;

import com.example.demo.Model.Episode;
import com.example.demo.Model.Movie;
import com.example.demo.Repository.EpisodeRepository;
import com.example.demo.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    public List<Movie> getAllActiveMovies() {
        return movieRepository.getAllMovies();
    }

    public List<Movie> getMoviesByType(Boolean type) {
        return movieRepository.findByType(type);
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
    }

    public List<Movie> searchMovies(String movie_name,String movie_genre ,Boolean type) {
        return movieRepository.searchMovies(movie_name,movie_genre,type);
    }

    public List<Movie> getHotMovies() {
        return movieRepository.getHotMovies();
    }
}
