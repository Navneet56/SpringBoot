package com.zee.zee5app.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movie;
@Repository
public interface MoviesRepository 
extends JpaRepository<Movie, String> 
{
	public List<Movie> findAllByMovieName(String MovieName);
	public List<Movie> findAllByGenre(String Gener);
}
