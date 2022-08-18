package com.zee.zee5app.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.InvalidLengthException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.repos.MoviesRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MoviesRepository movieRepository ;
	@Override
	public Movie insertMovie(Movie movie) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// trailer file exists or not
		
		return movieRepository.save(movie);
	}

	@Override
	public Optional<Movie> updateMovie(String movieId, Movie movie) throws NoDataFoundException {
		return Optional.ofNullable(movieRepository.save(movie));
	}

	@Override
	public String deleteMovieByMovieId(String movieId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		
		try {
			if(movieRepository.existsById(movieId))
			{
				movieRepository.deleteById(movieId);
				return "Success";
			}
			
			else
			{
				throw new NoDataFoundException("No data found");
			}
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			// to handle any exception except nodatafoundexception.
			e.printStackTrace();
		}
		return "failed";
	}

	@Override
	public Optional<List<Movie>> getAllMovies() throws InvalidIdException {
		// TODO Auto-generated method stub
		return  Optional.ofNullable(movieRepository.findAll());
	}

	@Override
	public Optional<List<Movie>> getAllMoviesByGenre(String genre) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAllByGenre(genre));
	}

	@Override
	public Optional<List<Movie>> getAllMoviesByName(String movieName) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAllByMovieName(movieName));
	}

	@Override
	public Optional<Movie> getMovieByMovieId(String movieId) throws InvalidNameException, InvalidLengthException {
		// TODO Auto-generated method stub
		return movieRepository.findById(movieId);
	}

	@Override
	public List<Movie> findByOrderByMovieNameDsc() {
		// TODO Auto-generated method stub

		return null;
	}

}
