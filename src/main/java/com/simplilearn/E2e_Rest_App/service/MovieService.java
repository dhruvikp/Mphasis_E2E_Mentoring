package com.simplilearn.E2e_Rest_App.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.E2e_Rest_App.entity.Movie;
import com.simplilearn.E2e_Rest_App.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	public  List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		movieRepository.findAll().forEach(movie -> movies.add(movie));
		return movies;
	}
	
	public Movie getMovieByName(String movieName) {
		return movieRepository.findByName(movieName);
	}
	
	
	public void saveMovie(Movie movie) {
		movieRepository.save(movie);
	}
	
	public void deleteMovie(int id) {
		movieRepository.deleteById(id);
	}
}
