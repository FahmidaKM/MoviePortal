package com.cts.moviecruiser.movie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.moviecruiser.movie.model.Movie;


@Repository
public interface MovieRepository extends CrudRepository<Movie,Long>{

}
