package com.simplilearn.E2e_Rest_App.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.E2e_Rest_App.entity.Movie;
import com.simplilearn.E2e_Rest_App.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	@GetMapping("/movies/{name}")
	public Movie getAllMovies(@PathVariable("name") String name) {
		return movieService.getMovieByName(name);
	}

	@PostMapping("/movies")
	public int saveMovie(@RequestBody Movie movie) {
		movieService.saveMovie(movie);
		return movie.getId();
	}

	@DeleteMapping("/movies/{id}")
	public void deleteMovie(@PathVariable("id") int id) {
		movieService.deleteMovie(id);
	}

	@GetMapping("/movies/director/{name}")
	public List<String> getMoviesByDirectorName(@PathVariable("name") String name) {
		List<Movie> movies = movieService.getMoviesByDirectorName(name);
		List<String> movieNames = new ArrayList<>();
		if (movies != null && movies.size() > 0) {
			for (Movie movie : movies) {
				movieNames.add(movie.getName());
			}
		}
		return movieNames;
	}
}
