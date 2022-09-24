package com.cts.moviecruiser.movie.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.moviecruiser.movie.MovieCruiserApplication;
import com.cts.moviecruiser.movie.model.Movie;
import com.cts.moviecruiser.movie.service.MovieServiceImpl;


@RestController
@RequestMapping("/movies")
public class MovieController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);
	
	@Autowired
	MovieServiceImpl movieServiceImpl;
	
	@GetMapping
	public List<Movie> getAllMoviesAdmin(){
		LOGGER.info("Start: Inside getAllMovies");
		LOGGER.info("End:  getAllMovies");
		return movieServiceImpl.getMovieListAdmin();
	}
	
	@GetMapping("/customer")
	public List<Movie> getAllMoviesCustomer(){
		LOGGER.info("Start: Inside getAllMovies");
		LOGGER.info("End:  getAllMovies");
		return movieServiceImpl.getMovieListCustomer();
	}
	
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable("id") long id)
	{
		LOGGER.info("Start: Inside getMovie");
		LOGGER.info("End:  getMovie");
		return movieServiceImpl.getMovie(id);
	}
	
	@PutMapping()
	public Movie modifyMovie(@RequestBody Movie movie)
	{
		LOGGER.info("Start: Inside modifyMovie");
		LOGGER.info("End:  modifyMovie");
		return movieServiceImpl.modifyMovie(movie);
	}
}


