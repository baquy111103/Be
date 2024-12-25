package com.example.demo.Controller;

import com.example.demo.DTO.EpisodeDto;
import com.example.demo.Service.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/episodes")
@RequiredArgsConstructor
public class EpisodeController {
    private final EpisodeService episodeService;

    @GetMapping("/movie")
    public ResponseEntity<List<EpisodeDto>> getEpisodesByMovieCode(@RequestParam String movie_code) {
        List<EpisodeDto> episodes = episodeService.getEpisodesByMovieCode(movie_code);
        return ResponseEntity.ok(episodes);
    }
}
