package com.simplilearn.E2e_Rest_App.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.E2e_Rest_App.entity.Director;
import com.simplilearn.E2e_Rest_App.entity.Movie;
import com.simplilearn.E2e_Rest_App.repository.DirectorRepository;
import com.simplilearn.E2e_Rest_App.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	DirectorRepository directorRepository;

	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		movieRepository.findAll().forEach(movie -> movies.add(movie));
		return movies;
	}

	public Movie getMovieByName(String movieName) {
		return movieRepository.findByName(movieName);
	}

	public void saveMovie(Movie movie) {
		String directorName = movie.getDirector().getDirectorName();
		Optional<Director> optioalDirector = directorRepository.findByDirectorName(directorName);
		if (optioalDirector.isPresent()) {
			Director d = optioalDirector.get();
			movie.setDirector(d);
		}
		movieRepository.save(movie);
	}

	public void deleteMovie(int id) {
		movieRepository.deleteById(id);
	}

	public List<Movie> getMoviesByDirectorName(String directorName) {
		return movieRepository.findByDirectorName(directorName);
	}
}
