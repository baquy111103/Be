package com.example.demo.Repository;

import com.example.demo.Model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, String> {
    @Query(value = "SELECT e.id, e.episode_number, e.description, e.release_date, " +
            "e.duration, e.video_url, e.status, e.created_at, e.updated_at, " +
            "m.movie_code, m.movie_name " +
            "FROM episode e " +
            "INNER JOIN movie m ON e.movie_code = m.movie_code " +
            "WHERE m.movie_code = :movie_code AND e.status = 1 " +
            "ORDER BY e.episode_number DESC",
            nativeQuery = true)
    List<Object[]> findEpisodesByMovieCode(@Param("movie_code") String movie_code);
}
