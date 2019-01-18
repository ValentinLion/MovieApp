package com.esir.projet_dlc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("filmRepository")
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByMovieTitle(@Param("title")String title);
}