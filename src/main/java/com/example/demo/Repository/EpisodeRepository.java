package com.example.demo.Repository;

import com.example.demo.DTO.EpisodeDto;
import com.example.demo.Model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

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




    // Truy vấn SQL để lấy video_url của episode từ movie_code và episode_number
    @Query(value = "SELECT e.id, e.episode_number, e.description, e.release_date, " +
            "e.duration, e.video_url, e.status, e.created_at, e.updated_at, " +
            "m.movie_code, m.movie_name " +
            "FROM episode e " +
            "INNER JOIN movie m ON e.movie_code = m.movie_code " +
            "WHERE m.movie_code = :movie_code AND e.episode_number = :episode_number " +
            "AND e.status = 1 ",
            nativeQuery = true)
    Optional<EpisodeDto> findVideoUrl(@Param("movie_code") String movie_code,
                                      @Param("episode_number") Integer episode_number);
}
