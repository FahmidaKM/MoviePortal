package com.cts.moviecruiser.movie.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.moviecruiser.movie.model.Movie;
import com.cts.moviecruiser.movie.repository.MovieRepository;





@Service
public class MovieServiceImpl {
	@Autowired
	MovieRepository movieRepository;

	
	public void setMovieRepository(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public List<Movie> getMovieListAdmin() {
		List<Movie> movies = new ArrayList<>();
		movieRepository.findAll().forEach(movies::add);
		return movies;
		//return movieDao.getMovieListAdmin();
	}

	public List<Movie> getMovieListCustomer() {
		List<Movie> customerMovieList = new ArrayList<Movie>();
		List<Movie> customerList = new ArrayList<Movie>();
		customerList = (List<Movie>) movieRepository.findAll();
		for (Movie movie : customerList) {
			if ((movie.getDateOfLaunch().equals(new Date()) || movie.getDateOfLaunch().before(new Date()))
					&& movie.isActive()) {
				customerMovieList.add(movie);
			}
		}
		
		return customerMovieList;
		// return movieDao.getMovieListCustomer();
	}


	public Movie getMovie(long movieId) {
		return movieRepository.findById(movieId).get();
		//return movieDao.getMovie(movieId);
	}

	public Movie modifyMovie(Movie movie) {
		return movieRepository.save(movie);
		//return movieDao.modifyMovie(movie);
	}
}



