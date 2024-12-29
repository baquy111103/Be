package com.example.demo.Controller;

import com.example.demo.DTO.FavoriteDTO;
import com.example.demo.Model.Favorite;
import com.example.demo.Service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoritesController {
    @Autowired
    private FavoritesService favoriteService;

    @GetMapping
    public ResponseEntity<List<FavoriteDTO>> getAllFavorites() {
        List<FavoriteDTO> favoriteDTOs = favoriteService.getAllFavorites();
        return ResponseEntity.ok(favoriteDTOs);
    }

}
