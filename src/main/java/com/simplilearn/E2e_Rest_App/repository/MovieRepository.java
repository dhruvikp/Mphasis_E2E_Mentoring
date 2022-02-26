package com.simplilearn.E2e_Rest_App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.E2e_Rest_App.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

	
	public Movie findByName(String name);
	

	public List<Movie> findByDirectorName(String directorName) ;
}