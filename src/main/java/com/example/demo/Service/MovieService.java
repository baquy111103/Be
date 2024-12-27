package com.example.demo.Service;

import com.example.demo.DTO.Episode_DTO;
import com.example.demo.DTO.MovieDTO;
import com.example.demo.DTO.Movie_ActorDTO;
import com.example.demo.Model.Episode;
import com.example.demo.Model.Movie;
import com.example.demo.Repository.EpisodeRepository;
import com.example.demo.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    @Transactional
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findByStatus(true);  // true tương ứng với status = 1

        return movies.stream().map(movie -> {
            MovieDTO dto = new MovieDTO();
            dto.setId(movie.getId());
            dto.setMovie_code(movie.getMovie_code());
            dto.setMovie_name(movie.getMovie_name());
            dto.setDescription(movie.getDescription());
            dto.setRelease_date(movie.getRelease_date().toString());
            dto.setDuration(movie.getDuration());
            dto.setImage_url(movie.getImage_url());
            dto.setVideo_url(movie.getVideo_url());
            dto.setStatus(movie.getStatus());
            dto.setLanguage(movie.getLanguage());
            dto.setMovie_genre(movie.getMovie_genre());
            return dto;
        }).collect(Collectors.toList());
    }


    @Transactional
    public List<MovieDTO> getMoviesByType(Boolean type) {
        List<Movie> movies = movieRepository.findMoviesByType(type);

        return movies.stream().map(movie -> {
            MovieDTO dto = new MovieDTO();
            dto.setId(movie.getId());
            dto.setMovie_code(movie.getMovie_code());
            dto.setMovie_name(movie.getMovie_name());
            dto.setDescription(movie.getDescription());
            dto.setRelease_date(movie.getRelease_date().toString());
            dto.setDuration(movie.getDuration());
            dto.setImage_url(movie.getImage_url());
            dto.setVideo_url(movie.getVideo_url());
            dto.setStatus(movie.getStatus());
            dto.setLanguage(movie.getLanguage());
            dto.setMovie_genre(movie.getMovie_genre());
            return dto;
        }).collect(Collectors.toList());
    }

    @Transactional
    public List<MovieDTO> searchMovies(String movieName, String movieGenre, String actorName) {
        List<Movie> movies = movieRepository.searchMovies(movieName, movieGenre, actorName);

        return movies.stream().map(movie -> {
            MovieDTO dto = new MovieDTO();
            dto.setId(movie.getId());
            dto.setMovie_code(movie.getMovie_code());
            dto.setMovie_name(movie.getMovie_name());
            dto.setDescription(movie.getDescription());
            dto.setRelease_date(movie.getRelease_date().toString());
            dto.setDuration(movie.getDuration());
            dto.setImage_url(movie.getImage_url());
            dto.setVideo_url(movie.getVideo_url());
            dto.setStatus(movie.getStatus());
            dto.setLanguage(movie.getLanguage());
            dto.setMovie_genre(movie.getMovie_genre());

            List<Movie_ActorDTO> actorDTOs = movie.getMovieActors().stream()
                    .map(actor -> new Movie_ActorDTO(actor.getActor().getActor_code(), actor.getActor().getName(),actor.getActor().getAvatar()))
                    .collect(Collectors.toList());
            dto.setMovieActors(actorDTOs);

            return dto;
        }).collect(Collectors.toList());
    }

    @Transactional
    public MovieDTO getMovieByCode(String movieCode) {
        Movie movie = movieRepository.findByMovieCode(movieCode)
                .orElseThrow(() -> new RuntimeException("Movie not found with movie_code: " + movieCode));
        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setMovie_code(movie.getMovie_code());
        dto.setMovie_name(movie.getMovie_name());
        dto.setDescription(movie.getDescription());
        dto.setRelease_date(movie.getRelease_date().toString());
        dto.setDuration(movie.getDuration());
        dto.setImage_url(movie.getImage_url());
        dto.setVideo_url(movie.getVideo_url());
        dto.setStatus(movie.getStatus());
        dto.setLanguage(movie.getLanguage());
        dto.setMovie_genre(movie.getMovie_genre());

        List<Movie_ActorDTO> actorDTOs = movie.getMovieActors().stream()
                .map(actor -> new Movie_ActorDTO(actor.getActor().getActor_code(), actor.getActor().getName(),actor.getActor().getAvatar()))
                .collect(Collectors.toList());
        dto.setMovieActors(actorDTOs);
        return dto;
    }

    @Transactional
    public List<MovieDTO> getHotMovies() {
        List<Movie> hotMovies = movieRepository.findHotMovies();

        return hotMovies.stream().map(movie -> {
            MovieDTO dto = new MovieDTO();
            dto.setId(movie.getId());
            dto.setMovie_code(movie.getMovie_code());
            dto.setMovie_name(movie.getMovie_name());
            dto.setDescription(movie.getDescription());
            dto.setRelease_date(movie.getRelease_date().toString());
            dto.setDuration(movie.getDuration());
            dto.setImage_url(movie.getImage_url());
            dto.setVideo_url(movie.getVideo_url());
            dto.setStatus(movie.getStatus());
            dto.setLanguage(movie.getLanguage());
            dto.setMovie_genre(movie.getMovie_genre());
            return dto;
        }).collect(Collectors.toList());
    }


    // Phương thức lấy tất cả các tập phim theo movie_code
    public List<Episode> getAllEpisodesByMovieCode(String movieCode) {
        return episodeRepository.findEpisodesByMovieCode(movieCode);
    }

//    public List<Movie_ActorDTO> getActorsByMovieCode(String movieCode) {
//        // Gọi repository để lấy dữ liệu
//        return movieRepository.findActorsByMovieCode(movieCode);
//    }
}
