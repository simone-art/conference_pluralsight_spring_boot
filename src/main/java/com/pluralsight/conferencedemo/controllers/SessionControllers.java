package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionControllers {

    @Autowired
    private SessionRepository sessionRepository;


    @GetMapping
    //Método que lista todas as sessões
    public List<Session> list(){
        return sessionRepository.findAll();

    }

    @GetMapping
    @RequestMapping("{id}")
    //Método que busca uma sessão pelo Id
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }


    @PostMapping
    //saveAndFlush é um método do JPA e tem a mesma funcão do save pertencente ao Crud
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }


}
