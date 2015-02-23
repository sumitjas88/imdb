package com.sumit.controller;

import com.sumit.model.Artist;
import com.sumit.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonRepository repository;

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET)
    public Iterable<Artist> get() {
        return repository.findAll();
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(@RequestBody Artist artist) {
        repository.save(artist);
        return new ResponseEntity<String>("Person Successfully Saved", HttpStatus.OK);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        repository.delete(id);
        return new ResponseEntity<String>("Person Successfully Deleted", HttpStatus.OK);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> put(@PathVariable("id") Long id, @RequestBody Artist artist) {
        artist.setId(id);
        repository.save(artist);
        return new ResponseEntity<String>("Person Successfully Updated", HttpStatus.OK);
    }


}
