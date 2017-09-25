package com.brovada.old.controller;

import com.brovada.old.document.config.FormConfig;
import com.brovada.old.repository.FormConfigRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(value = "/form")
public class FormConfigController {

    private @Inject
    FormConfigRepository repository;


    @RequestMapping(value = "/all")
    public List<FormConfig> all() {
        return repository.findAll();
    }


    @RequestMapping(value = "/{id}")
    public FormConfig get(@PathVariable String id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "latest/{id}")
    public FormConfig getLatest(@PathVariable String id) {
        return repository.findLatestById(id);
    }

    @RequestMapping(method = RequestMethod.POST)   // TODO : change to PUT??
    ResponseEntity<?> add(@RequestBody FormConfig input) {
        System.out.print(input + " --> ");
        FormConfig x = this.repository.save(input);
        System.out.println("saved " + x);
        return new ResponseEntity<Object>(null, HttpStatus.CREATED);
    }

}


