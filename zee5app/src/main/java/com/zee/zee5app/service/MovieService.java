package com.zee.zee5app.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.InvalidLengthException;
import com.zee.zee5app.exceptions.NoDataFoundException;

public interface MovieService {
  
	public Movie insertMovie(Movie movie) throws FileNotFoundException;
	public Optional<Movie> updateMovie(String movieId,Movie movie) throws NoDataFoundException;
	public String deleteMovieByMovieId(String movieId) throws NoDataFoundException;
	public Optional<List<Movie>> getAllMovies() throws InvalidIdException;
	public Optional<List<Movie>> getAllMoviesByGenre(String genre);
	public Optional<List<Movie>> getAllMoviesByName(String movieName);
	public Optional<Movie> getMovieByMovieId(String movieId) throws InvalidNameException, InvalidLengthException;
	public List<Movie> findByOrderByMovieNameDsc();
	
}
