package com.example.demo.Service;

import com.example.demo.Model.Movie;
import com.example.demo.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByType(Boolean type) {
        // Lấy tất cả phim từ cơ sở dữ liệu với điều kiện type == false (phim lẻ)
        return movieRepository.findByType(type);
    }

    public Movie getMovieById(String id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
    }
}
