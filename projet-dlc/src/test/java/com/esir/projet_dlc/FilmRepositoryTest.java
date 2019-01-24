package com.esir.projet_dlc;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@JdbcTest
public class FilmRepositoryTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private FilmRepository filmRepository;
 

    @Test
    public void whenFindByMovieTitle() {
        
        Film film = new Film();
        film.setMovieTitle("TestFindFilm");
        entityManager.persist(film);
        entityManager.flush();
     
        List<Film> found = filmRepository.findByMovieTitle("TestFindFilm");
     
        assertEquals(1,found.size());
        assertEquals("TestFindFilm",found.get(0).getMovieTitle());
    }


    @Test
    public void whenFindByDirector() {
        
        Film film = new Film();
        film.setMovieTitle("TestFindFilm2");
        film.setDirectorName("TestFindDirector");
        entityManager.persist(film);
        entityManager.flush();
     
        List<Film> found = filmRepository.findByDirector("TestFindDirector");
     
        assertEquals(1,found.size());
        assertEquals("TestFindDirector",found.get(0).getDirectorName());
    }
    
    

    @Test
    public void whenFindByActor() {
        
        Film film = new Film();
        film.setMovieTitle("TestFindFilm3");
        film.setActor1Name("Actor1");
        entityManager.persist(film);
        entityManager.flush();
     
        List<Film> found = filmRepository.findByActor("Actor1");
     
        assertEquals(1,found.size());
        assertEquals("TestFindFilm3",found.get(0).getMovieTitle());
    }

    
}