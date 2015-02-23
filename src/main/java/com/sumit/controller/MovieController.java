package com.sumit.controller;

import com.sumit.model.Movie;
import com.sumit.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieRepository repository;

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET)
    public Iterable<Movie> get() {
        return repository.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Movie getOne(@PathVariable("id") Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(@RequestBody Movie movie) {
        repository.save(movie);
        return new ResponseEntity<String>("Movie Successfully Saved", HttpStatus.OK);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        repository.delete(id);
        return new ResponseEntity<String>("Movie Successfully Deleted", HttpStatus.OK);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> put(@PathVariable("id") Long id, @RequestBody Movie movie) {
        movie.setId(id);
        repository.save(movie);
        return new ResponseEntity<String>("Movie Successfully Updated", HttpStatus.OK);
    }


}
