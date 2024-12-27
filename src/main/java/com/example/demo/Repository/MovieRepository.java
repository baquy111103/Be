package com.example.demo.Repository;

import com.example.demo.DTO.Movie_ActorDTO;
import com.example.demo.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(
            value = "SELECT *" +
                    "FROM movie " +
                    "WHERE type = :type " +
                    "AND status = 1 " +
                    "ORDER BY created_at DESC",
            nativeQuery = true
    )
    List<Movie> findMoviesByType(@Param("type") Boolean type);

    @Query(
            value = "SELECT m.* FROM movie m " +
                    "JOIN movie_actor ma ON ma.movie_code = m.movie_code " +  // Sử dụng movie_code thay vì movie_id
                    "JOIN actor a ON a.actor_code = ma.actor_code " +        // Sử dụng actor_code thay vì actor_id
                    "WHERE (:movie_name IS NULL OR m.movie_name LIKE CONCAT('%', :movie_name, '%')) " +
                    "AND (:movie_genre IS NULL OR m.movie_genre LIKE CONCAT('%', :movie_genre, '%')) " +
                    "AND (:actor_name IS NULL OR a.name LIKE CONCAT('%', :actor_name, '%')) " +
                    "AND m.status = 1 " +
                    "ORDER BY m.created_at DESC",
            countQuery = "SELECT count(*) FROM movie m " +
                    "JOIN movie_actor ma ON ma.movie_code = m.movie_code " +  // Sử dụng movie_code thay vì movie_id
                    "JOIN actor a ON a.actor_code = ma.actor_code " +        // Sử dụng actor_code thay vì actor_id
                    "WHERE (:movie_name IS NULL OR m.movie_name LIKE CONCAT('%', :movie_name, '%')) " +
                    "AND (:movie_genre IS NULL OR m.movie_genre LIKE CONCAT('%', :movie_genre, '%')) " +
                    "AND (:actor_name IS NULL OR a.name LIKE CONCAT('%', :actor_name, '%')) " +
                    "AND m.status = 1",
            nativeQuery = true
    )
    List<Movie> searchMovies(
            @Param("movie_name") String movieName,
            @Param("movie_genre") String movieGenre,
            @Param("actor_name") String actorName
    );


    @Query(
            value = "SELECT * FROM movie m WHERE m.movie_code = :movie_code AND m.status = 1",
            nativeQuery = true
    )
    Optional<Movie> findByMovieCode(@Param("movie_code") String movieCode);

    @Query(
            value = "SELECT * FROM movie m WHERE m.is_hot = 1 AND m.status = 1 ORDER BY m.created_at DESC",
            nativeQuery = true
    )
    List<Movie> findHotMovies();


    List<Movie> findByStatus(Boolean status);


//    @Query(
//            value = "SELECT a.actor_code, a.name " +
//                    "FROM actor a " +
//                    "JOIN movie_actor ma ON ma.actor_code = a.actor_code " +
//                    "JOIN movie m ON m.movie_code = ma.movie_code " +
//                    "WHERE m.movie_code = :movieCode AND a.status = 1",
//            nativeQuery = true
//    )
//    List<Movie_ActorDTO> findActorsByMovieCode(@Param("movieCode") String movieCode);

}
