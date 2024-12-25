package com.example.demo.Repository;

import com.example.demo.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByType(Boolean type);

    @Query(
            value = "SELECT * FROM movie " +
                    "WHERE (:movie_name IS NULL OR movie_name LIKE CONCAT('%', :movie_name, '%')) " +
                    "AND (:movie_genre IS NULL OR movie_genre LIKE CONCAT('%', :movie_genre, '%'))" +
                    "AND (:type IS NULL OR type = :type) " +
                    "AND status = 1 " +
                    "ORDER BY created_at DESC",
            countQuery = "SELECT count(*) FROM movie " +
                    "WHERE (:movie_name IS NULL OR movie_name LIKE CONCAT('%', :movie_name, '%')) " +
                    "AND (:movie_genre IS NULL OR movie_genre LIKE CONCAT('%', :movie_genre, '%'))" +
                    "AND (:type IS NULL OR type = :type) " +
                    "AND status = 1",
            nativeQuery = true
    )
    List<Movie> searchMovies(
            @Param("movie_name") String name,
            @Param("movie_genre") String genre,
            @Param("type") Boolean type);
}
