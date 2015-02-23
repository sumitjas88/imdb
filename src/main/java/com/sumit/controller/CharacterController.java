package com.sumit.controller;

import com.sumit.model.Character;
import com.sumit.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    CharacterRepository repository;

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET)
    public Iterable<Character> get() {
        return repository.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Character getOne(@PathVariable("id") Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(@RequestBody Character character) {
        repository.save(character);
        return new ResponseEntity<String>("Character Successfully Saved", HttpStatus.OK);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        repository.delete(id);
        return new ResponseEntity<String>("Character Successfully Deleted", HttpStatus.OK);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> put(@PathVariable("id") Long id, @RequestBody Character character) {
        character.setId(id);
        repository.save(character);
        return new ResponseEntity<String>("Character Successfully Updated", HttpStatus.OK);
    }

}
