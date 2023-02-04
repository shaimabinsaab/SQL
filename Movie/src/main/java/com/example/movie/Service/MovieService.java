package com.example.movie.Service;

import com.example.movie.Exeption.Api;
import com.example.movie.Module.Director;
import com.example.movie.Module.Movie;
import com.example.movie.Repositry.DirectoryRepositry;
import com.example.movie.Repositry.MovieRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepositry movieRepositry;
    private final DirectoryRepositry directoryRepositry;

    public List<Movie> getMovie(){
        return movieRepositry.findAll();
    }

    public void addMovie(Movie movie){
        movieRepositry.save(movie);
    }

    public void UpdateMovie(Integer id,Movie movie){
        Movie m=movieRepositry.findMovieById(id);

        if(m==null){
            throw new Api("this id is not here");
        }

        m.setName(movie.getName());
        m.setDuration(movie.getDuration());
        m.setRating(m.getRating());
        m.setGenre(m.getGenre());
        m.setDirectorID(movie.getDirectorID());

    }
    public void deleteMovie(Integer id) {
        Movie m = movieRepositry.findMovieById(id);

        if (m == null) {
            throw new Api("id not here");

        }

        movieRepositry.delete(m);

    }

    public Movie findbyname(String name){
        Movie movie=movieRepositry.findMovieByName(name);
        if (movie==null){
            throw new Api("move is not here");
        }
        return movie;
    }

    public Movie findDurationByname(String name){
        Movie movie=movieRepositry.findDurationByname(name);
        if(movie==null){
            throw new Api("duration does not exist");
        }
        return movie;
    }
    public Movie findratingByname(String name){
        Movie movie=movieRepositry.findratingByname(name);
        if(movie==null){
            throw new Api("rating does not exist");
        }
        return movie;
    }
    public List<Movie> findAllByRatingGreaterThan(Integer rating) {
        List<Movie> movies = movieRepositry.findAllByRatingGreaterThan(rating);
        if (movies == null) {
            throw new Api("this age is not here");
        }
        return movies;
    }

    public List<Movie> findAllByGenreEquals(String genre) {
        List<Movie> movies = movieRepositry.findAllByGenreEquals(genre);
        if (movies == null) {
            throw new Api("this genre is not here");
        }
        return movies;
    }

    public String findDirectorbyname(String name){
        Movie movie=movieRepositry.findDirectorbyname(name);
        if(movie==null){
            throw new Api("there is no director id ");
        }
        Director director=directoryRepositry.findDirectorById(movie.getDirectorID());

        return director.getName();
    }

    public List<Movie> findMovieByDirectorID(Integer id){
        List<Movie>movies=movieRepositry.findMovieByDirectorID(id);

        if (movies==null){
            throw new Api("there is no movie with this director ");
        }

        return movies;
    }









}
