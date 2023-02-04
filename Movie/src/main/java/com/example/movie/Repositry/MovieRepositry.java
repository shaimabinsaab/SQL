package com.example.movie.Repositry;

import com.example.movie.Module.Director;
import com.example.movie.Module.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepositry extends JpaRepository<Movie,Integer> {
    Movie findMovieById(Integer id);

    Movie findMovieByName(String name);

    @Query("select Movie.duration from Movie duration where duration.name=?1 ")
    Movie findDurationByname(String name);

    @Query("select Movie.rating from Movie rating where rating.name=?1 ")
    Movie findratingByname(String name);

    List<Movie> findAllByRatingGreaterThan(Integer rating);

    List<Movie> findAllByGenreEquals(String genre);
    @Query("select Movie.directorID from Movie directorID where directorID.name=?1 ")
    Movie findDirectorbyname(String name);

    List<Movie> findMovieByDirectorID(Integer id);




}
