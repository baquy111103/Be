package com.example.demo.Repository;

import com.example.demo.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
    List<Movie> findByType(Boolean type);
}
