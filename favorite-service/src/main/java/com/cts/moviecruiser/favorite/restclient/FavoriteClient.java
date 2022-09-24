package com.cts.moviecruiser.favorite.restclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cts.moviecruiser.favorite.model.Movie;

@FeignClient("MOVIE-SERVICE")
public interface FavoriteClient {
	

	@GetMapping("movies/customer")
	public List<Movie> getAllMovies();
}
