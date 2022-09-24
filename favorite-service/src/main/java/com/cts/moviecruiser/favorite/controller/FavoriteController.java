package com.cts.moviecruiser.favorite.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.moviecruiser.favorite.FavoriteServiceApplication;
import com.cts.moviecruiser.favorite.GlobalExceptionHandler;
import com.cts.moviecruiser.favorite.model.Favorite;
import com.cts.moviecruiser.favorite.model.Movie;
import com.cts.moviecruiser.favorite.response.FavoriteResponse;
import com.cts.moviecruiser.favorite.service.FavoriteServiceImpl;


@RestController
@RequestMapping("/favorites")
public class FavoriteController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteServiceApplication.class);
	@Autowired
	FavoriteServiceImpl favoriteServiceImpl;
	
	
	@PostMapping("/{userId}/{movieId}")
	public Favorite addFavoritesItem(@PathVariable("userId") long userId,@PathVariable("movieId") long movieId) throws IOException
	{
		LOGGER.info("Start : Inside addFavoritesItem");
		LOGGER.info("End: addFavoritesItem");
		return favoriteServiceImpl.addFavoritesMovie(userId, movieId);
		
	}
	
	@GetMapping("/{userId}")
	public List<Movie> getAllFavoritesItems(@PathVariable("userId") long userId) throws GlobalExceptionHandler
	{
		LOGGER.info("Start: Inside getAllFavoritesItem");
		LOGGER.info("End : getAllFavoritesItem");
		return favoriteServiceImpl.getAllFavoritesMovies(userId);
	
	}
	

	
	@DeleteMapping("/{userId}/{movieId}")
	public FavoriteResponse deleteFavoritesItem(@PathVariable("userId") long userId,@PathVariable("movieId") long movieId) throws GlobalExceptionHandler
	{
		LOGGER.info("Start: Inside deleteFavoritesItem");
		LOGGER.info("End: deleteCartItem");
		return favoriteServiceImpl.deleteFavoritesItem(userId,movieId);
		
	}
}
	
	
	




