package com.brovada.old.controller;

import com.brovada.old.document.Draft;
import com.brovada.old.repository.DraftRepository;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/drafts")
public class DraftController {

    private @Inject DraftRepository repository;


    @RequestMapping(value = "/{id}")
    public Draft get(@PathVariable String id) {
            return repository.findById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    ResponseEntity<?> add(@RequestBody Draft input) {
        System.out.print(new Gson().toJson(input) + " --> ");
        Draft x = this.repository.save(input);
        try {  // for debugging reasons, put in temporary stall.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("saved " + x.getId());
        System.out.println(" -  now there are " +repository.findAll().size() + " drafts");
        return new ResponseEntity<Object>(null, HttpStatus.CREATED);
    }

}


