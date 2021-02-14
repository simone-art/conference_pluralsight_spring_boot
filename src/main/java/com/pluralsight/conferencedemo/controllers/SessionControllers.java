package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
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
    //Também ela guarda e vacia a database
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    // Método para deletar pelo Id
    public void delete(@PathVariable Long id){
        //É preciso checar a existência desse id antes de deletar
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    // Método para atualizar buscando pelo id
    // existingSession é uma variável  que valida antes a existência daquele id
    // A função do BeanUtils é pegar os dados existente daquele id
    //copyProperties = copia os dados da sessão que queremos atualizar
    //SaveAndFlush = salve, vacia e atualiza novamente o dado
    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }


}
