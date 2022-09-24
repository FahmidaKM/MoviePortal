package com.cts.moviecruiser.favorite.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Favorite {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="favorite_sno")
	private long favoriteSNo;

	@Column(name="favorite_id")
	private long favoriteId;
	
	@Column(name="movie_id")
	private long movieId;
	
	
//	private int us_id;

//	private int mv_id;

	//private int count;

	//private List<Movie> movieList;

	
	
	
}
