//package com.example.demo.Controller;
//
//import com.example.demo.Model.Favorites;
//import com.example.demo.Service.FavoritesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/favorites")
//public class FavoritesController {
//    @Autowired
//    private FavoritesService favoriteService;
//
//    // Thêm vào danh sách yêu thích
//    @PostMapping("/add")
//    public ResponseEntity<Favorites> addFavorite(
//            @RequestParam String user_phone,
//            @RequestParam String movie_code) {
//        Favorites favorites = favoriteService.addFavorite(user_phone, movie_code);
//        return ResponseEntity.ok(favorites);
//    }
//
//    // Hiển thị danh sách yêu thích
//    @GetMapping("/list")
//    public ResponseEntity<List<Favorites>> getFavorites(@RequestParam String user_phone) {
//        List<Favorites> favorites = favoriteService.getFavorites(user_phone);
//        return ResponseEntity.ok(favorites);
//    }
//
//    // Xóa khỏi danh sách yêu thích
//    @DeleteMapping("/remove")
//    public ResponseEntity<String> removeFavorite(
//            @RequestParam String user_phone,
//            @RequestParam String movie_code) {
//        favoriteService.removeFavorite(user_phone, movie_code);
//        return ResponseEntity.ok("Removed from favorites!");
//    }
//}
