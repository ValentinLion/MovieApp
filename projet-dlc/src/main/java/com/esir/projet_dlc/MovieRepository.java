package com.esir.projet_dlc;

import org.springframework.data.repository.CrudRepository;

import com.esir.projet_dlc.Movie;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MovieRepository extends CrudRepository<Movie, String> {

}