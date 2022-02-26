package com.simplilearn.E2e_Rest_App.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Director {

	@Id
	@GeneratedValue
	@Column(name="director_id")
	private int id;
	
	@Column(name="director_name")
	private String directorName;
	
	@OneToMany(mappedBy = "director", cascade= CascadeType.ALL)
	private List<Movie> movies;
}
