package com.brovada.old.controller;

import com.brovada.old.document.Quote;
import com.brovada.old.repository.QuoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(value = "/quote")
public class QuoteController {

    private @Inject QuoteRepository repository;

    @RequestMapping(value = "/{id}")
    public Quote get(@PathVariable String id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "/all")
    public List<Quote> all() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    // TODO : i wouldn't really use ALICE here...it's just to show how the defaultValue could be used.
    public List<Quote> find(@RequestParam(value="name", defaultValue="alice") String name) {
        return repository.findContains(name);
    }

    // should this be PUT instead.
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> save(@RequestBody Quote input) {
        System.out.print(input + " --> ");
        Quote x = this.repository.save(input);
        System.out.println(x.getId() + " : " + x);
        return new ResponseEntity<Object>(null, HttpStatus.CREATED);
    }

}


