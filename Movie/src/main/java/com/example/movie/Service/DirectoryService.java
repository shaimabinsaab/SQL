package com.example.movie.Service;

import com.example.movie.Exeption.Api;
import com.example.movie.Module.Director;
import com.example.movie.Module.Movie;
import com.example.movie.Repositry.DirectoryRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.List;
@RequiredArgsConstructor
@Service
public class DirectoryService {

    private final DirectoryRepositry directoryRepositry;
    public List<Director> getDirectory(){
        return directoryRepositry.findAll();
    }

    public void addDirector(Director director){
        directoryRepositry.save(director);
    }

    public void Updatedirector(Integer id,Director director){
        Director d=directoryRepositry.findDirectorById(id);

        if(d==null){
            throw new Api("this id is not here");
        }

        d.setName(d.getName());
        directoryRepositry.save(director);
    }
    public void deletedirector(Integer id) {
        Director d = directoryRepositry.findDirectorById(id);

        if (d == null) {
            throw new Api("id not here");

        }

        directoryRepositry.delete(d);

    }

}
