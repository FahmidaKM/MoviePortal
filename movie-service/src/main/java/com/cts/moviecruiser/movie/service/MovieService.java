package com.cts.moviecruiser.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.moviecruiser.movie.model.Movie;

@Service
public interface MovieService {

	public List<Movie> getMovieListAdmin();
	public List<Movie> getMovieListCustomer();
	public Movie getMovie(long movieId);
	public Movie modifyMovie(Movie movie);
	
}
