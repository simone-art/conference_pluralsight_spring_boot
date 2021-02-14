package com.pluralsight.conferencedemo.controllers;


import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerControllers {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    //Método que lista todos os conferencitas
    public List<Speaker> list(){
        return speakerRepository.findAll();

    }

    @GetMapping
    @RequestMapping("{id}")
    //Método que busca um conferencista pelo Id
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

}
