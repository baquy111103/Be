package com.example.demo.Service;

import com.example.demo.DTO.FavoriteDTO;
import com.example.demo.DTO.MovieDTO;
import com.example.demo.Model.Favorite;
import com.example.demo.Repository.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoritesService {
    @Autowired
    private FavoritesRepository favoriteRepository;

    @Transactional
    public List<FavoriteDTO> getAllFavorites() {
        List<Favorite> favorites = favoriteRepository.findAll();
        return favorites.stream().map(favorite -> {
            FavoriteDTO dto = new FavoriteDTO();
            dto.setActive(favorite.getActive());
            dto.setFavorite_day(favorite.getFavorite_day().toString());
            dto.setUnfavorite_day(favorite.getUnfavorite_day() != null ? favorite.getUnfavorite_day().toString() : "Chưa có ngày hủy yêu thích");
            dto.setMovie_code(favorite.getMovie().getMovie_code());
            dto.setMovie_name(favorite.getMovie().getMovie_name());
            dto.setRelease_date(favorite.getMovie().getRelease_date());
            dto.setImage_url(favorite.getMovie().getImage_url());
            dto.setMovie_genre(favorite.getMovie().getMovie_genre());
            dto.setType(favorite.getMovie().getType());
            dto.setDuration(favorite.getMovie().getDuration());
            return dto;
        }).collect(Collectors.toList());
    }

    // Thêm một bản ghi yêu thích
    public Favorite addFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }
}
