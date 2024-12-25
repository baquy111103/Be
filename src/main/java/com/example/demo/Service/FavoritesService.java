//package com.example.demo.Service;
//
//import com.example.demo.Model.Favorites;
//import com.example.demo.Model.Movie;
//import com.example.demo.Repository.FavoritesRepository;
//import com.example.demo.Repository.MovieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class FavoritesService {
//    @Autowired
//    private FavoritesRepository favoriteRepository;
//
//    @Autowired
//    private MovieRepository movieRepository;
//
//    public Favorites addFavorite(String user_phone, String movie_code) {
//        // Tìm movie dựa trên movie_code
//        Movie movie = movieRepository.findByMovieCode(movie_code)
//                .orElseThrow(() -> new RuntimeException("Movie not found"));
//
//        // Tạo mới Favorites
//        Favorites favorites = new Favorites();
//        favorites.setUser_phone(user_phone);
//        favorites.setMovie(movie);
//
//        // Lưu vào database
//        return favoriteRepository.save(favorites);
//    }
//
//
//    // Hiển thị danh sách yêu thích
//    public List<Favorites> getFavorites(String user_phone) {
//        return favoriteRepository.findByUser_phone(user_phone);
//    }
//
//    // Xóa khỏi danh sách yêu thích
//    public void removeFavorite(String user_phone, String movie_code) {
//        favoriteRepository.deleteByUser_phoneAndMovieCode(user_phone, movie_code);
//    }
//}
