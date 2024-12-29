package com.example.demo.Repository;

import com.example.demo.Model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FavoritesRepository extends JpaRepository<Favorite, Long> {
}
