package com.example.demo.Repository;

import com.example.demo.DTO.EpisodeDto;
import com.example.demo.Model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EpisodeRepository extends JpaRepository<Episode, String> {
    @Query("SELECT e FROM Episode e JOIN e.movie m WHERE m.movie_code = :movieCode")
    List<Episode> findEpisodesByMovieCode(@Param("movieCode") String movieCode);
}
