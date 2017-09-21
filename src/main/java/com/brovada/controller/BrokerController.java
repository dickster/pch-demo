package com.brovada.controller;

import com.brovada.document.Broker;
import com.brovada.repository.BrokerRepository;
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
@RequestMapping(value = "/broker")
public class BrokerController {

    private @Inject BrokerRepository repository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Broker> all() {
        return repository.findAll();
    }

    @RequestMapping(value = "/demo")
    public List<Broker> findByNameWithDemoData(@RequestParam(value="search", defaultValue="") String search) {
        List<Broker> brokers = findByName(search);
        brokers.add(new Broker("Anu", "Start"));
        brokers.add(new Broker("Billy", "Smith"));
        brokers.add(0, new Broker("Aaron", "Aardvark"));
        brokers.add(new Broker(search, "Le Bogus"));
        return brokers;
    }

    @RequestMapping(value = "/{id}")
    public Broker employee(@PathVariable String id) {
        return repository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Broker> findByName(@RequestParam(value="search", defaultValue="") String search) {
        return repository.find(search);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody Broker input) {
        Broker x = this.repository.save(input);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setCacheControl("public, max-age=290304000");
        return new ResponseEntity<Object>(null, HttpStatus.CREATED);
    }

}


