package com.example.movie.Conroller;

import com.example.movie.Module.Movie;
import com.example.movie.Repositry.MovieRepositry;
import com.example.movie.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movie")
public class MovieConroller {
    private final MovieService movieService;
    @GetMapping("/get")
    public ResponseEntity getMovie(){
        List<Movie> movies=movieService.getMovie();
        return ResponseEntity.status(200).body(movies);
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("movie added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id,@Valid @RequestBody Movie movie) {
        movieService.UpdateMovie(id, movie);
        return ResponseEntity.status(200).body("movie updated");

    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);

        return ResponseEntity.status(200).body("movie deleted");


    }

    @GetMapping("/byname/{name}")
    public ResponseEntity findbyname(@PathVariable String name){
        Movie movie=movieService.findbyname(name);
        return ResponseEntity.status(200).body(movie);

    }
    @GetMapping("/ratingbyname/{name}")
    public ResponseEntity findratingByname(@PathVariable String name){
        Movie movie=movieService.findratingByname(name);
        return ResponseEntity.status(200).body(movie);

    }

    @GetMapping("/findduration/{name}")
    public ResponseEntity findDurationByname(@PathVariable String name){
        Movie movie=movieService.findDurationByname(name);
        return ResponseEntity.status(200).body(movie);

    }
    @GetMapping("/ratinggreater/{rating}")
    public ResponseEntity findAllByRatingGreaterThan(@PathVariable Integer rating){
        List<Movie> movie=movieService.findAllByRatingGreaterThan(rating);
        return ResponseEntity.status(200).body(movie);

    }
    @GetMapping("/genre/{genre}")
    public ResponseEntity findAllByGenreEquals(@PathVariable String genre){
        List<Movie> movie=movieService.findAllByGenreEquals(genre);
        return ResponseEntity.status(200).body(movie);

    }

    @GetMapping("/finddirector/{name}")
    public ResponseEntity findDirectorbyname(@PathVariable String name){
        String director=movieService.findDirectorbyname(name);
        return ResponseEntity.status(200).body(director);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity findMovieByDirectorID(@PathVariable Integer id){
        List<Movie>movies=movieService.findMovieByDirectorID(id);
        return ResponseEntity.status(200).body(movies);
    }

}
