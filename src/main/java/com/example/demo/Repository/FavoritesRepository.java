//package com.example.demo.Repository;
//
//import com.example.demo.Model.Favorites;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//
//public interface FavoritesRepository extends JpaRepository<Favorites, String> {
//    List<Favorites> findByUser_phone(String user_phone);
//
//    void deleteByUser_phoneAndMovieCode(String user_phone, String movie_code);
//
//}
