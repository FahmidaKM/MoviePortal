package com.cts.moviecruiser.favorite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.moviecruiser.favorite.model.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

	// int deleteFromFavorite(long userId, long movieId);
	@Query(value = "select f from Favorite f where f.favoriteId=:id")
	List<Favorite> getAllFavoritesItem(@Param("id") long favoriteId);

	@Modifying
	@Query(value = "delete from Favorite f where f.favoriteId=:favoriteId and movieId=:movieId")
	int deleteFromFavorite(@Param("favoriteId") long favoriteId, @Param("movieId") long movieId);

}
