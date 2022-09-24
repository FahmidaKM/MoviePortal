package com.cts.moviecruiser.favorite.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.moviecruiser.favorite.GlobalExceptionHandler;

import com.cts.moviecruiser.favorite.model.Favorite;
import com.cts.moviecruiser.favorite.model.Movie;
import com.cts.moviecruiser.favorite.repository.FavoriteRepository;
import com.cts.moviecruiser.favorite.response.FavoriteResponse;
import com.cts.moviecruiser.favorite.restclient.FavoriteClient;

@Service
public class FavoriteServiceImpl {

	@Autowired
	private FavoriteRepository favoriteRepository;

	@Autowired
	private FavoriteClient client;

	List<Movie> movieList = new ArrayList<Movie>();
	Favorite favorite = new Favorite();

	public Favorite addFavoritesMovie(long userId, long movieId) {
		
		Favorite favorite = new Favorite();
		favorite.setFavoriteId(userId);
		favorite.setMovieId(movieId);
		return favoriteRepository.save(favorite);
		
		// return favoritesDao.addFavoritesMovie(userId, movieId);

	}

	public List<Movie> getAllFavoritesMovies(long userId)  {
		
		List<Movie> movieList = new ArrayList<Movie>();
		for (Movie movie : client.getAllMovies()) {
			for (Favorite favorite : favoriteRepository.getAllFavoritesItem(userId)) {
				if (movie.getId() == favorite.getMovieId()) {
					movieList.add(movie);
				}
			}
		}
		return movieList;
		// return favoritesDao.getAllFavoritesMovies(userId);
	}

	@Transactional
	public FavoriteResponse deleteFavoritesItem(long userId, long movieId) throws GlobalExceptionHandler {
		if(favoriteRepository.deleteFromFavorite(userId, movieId)==1) {
		return new FavoriteResponse("Movie deleted!!");
		}else {
		return new FavoriteResponse("Failed!");
		}
	}
}
