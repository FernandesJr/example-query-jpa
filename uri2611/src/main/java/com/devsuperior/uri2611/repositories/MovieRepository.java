package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    //Sql raiz precisa da interface, porém, ao utilizar o próprio spring cria uma classe concreta
    @Query(nativeQuery = true, value = "SELECT movies.id, movies.name FROM movies " +
            "INNER JOIN genres ON " +
            "genres.id = movies.id_genres " +
            "WHERE UPPER(genres.description) = UPPER(:genre)")
    List<MovieMinProjection> search01(String genre);

    //JPQL não precisa da interface de projeção
    @Query("SELECT new com.devsuperior.uri2611.dto.MovieMinDTO(m.id, m.name) FROM Movie m " +
            "WHERE UPPER(m.genre.description) = UPPER(:genre)")
    List<MovieMinDTO> search02(String genre);
}
