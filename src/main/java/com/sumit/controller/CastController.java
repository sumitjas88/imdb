package com.sumit.controller;

import com.sumit.model.CastMember;
import com.sumit.repository.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cast")
public class CastController {

    @Autowired
    CastRepository repository;

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET)
    public Iterable<CastMember> get() {
        return repository.findAll();
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(@RequestBody CastMember castMember) {
        repository.save(castMember);
        return new ResponseEntity<String>("Cast Successfully Saved", HttpStatus.OK);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        repository.delete(id);
        return new ResponseEntity<String>("Cast Successfully Deleted", HttpStatus.OK);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> put(@PathVariable("id") Long id, @RequestBody CastMember castMember) {
        castMember.setId(id);
        repository.save(castMember);
        return new ResponseEntity<String>("Cast Successfully Updated", HttpStatus.OK);
    }


}
