package com.simplilearn.E2e_Rest_App.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.E2e_Rest_App.entity.Director;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Integer> {

	public Optional<Director> findByDirectorName(String directorName);
}