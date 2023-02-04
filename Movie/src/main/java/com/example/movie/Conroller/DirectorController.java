package com.example.movie.Conroller;

import com.example.movie.Module.Director;
import com.example.movie.Module.Movie;
import com.example.movie.Service.DirectoryService;
import com.example.movie.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/director")
public class DirectorController {

    private final DirectoryService directoryService;

    @GetMapping("/get")
    public ResponseEntity getDirector(){
        List<Director> directors=directoryService.getDirectory();
        return ResponseEntity.status(200).body(directors);
    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid @RequestBody Director director){
        directoryService.addDirector(director);
        return ResponseEntity.status(200).body("director added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector(@PathVariable Integer id, @Valid @RequestBody Director director) {
        directoryService.Updatedirector(id, director);
        return ResponseEntity.status(200).body("director updated");

    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletDirector(@PathVariable Integer id){
        directoryService.deletedirector(id);

        return ResponseEntity.status(200).body("director deleted");


    }
}
