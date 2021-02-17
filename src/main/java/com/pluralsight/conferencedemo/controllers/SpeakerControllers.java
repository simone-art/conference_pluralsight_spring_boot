package com.pluralsight.conferencedemo.controllers;


import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return speakerRepository.findById(id).get();
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    // Método para deletar pelo Id
    public String delete(@PathVariable Long id){
        //É preciso checar a existência desse id antes de deletar
        speakerRepository.deleteById(id);
        System.out.println("Deletado com sucesso");
        return "Deletado com sucesso";
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    // Método para atualizar buscando pelo id
    // existingSpeaker é uma variável  que valida antes a existência daquele id
    // A função do BeanUtils é pegar os dados existente daquele id
    //copyProperties = copia os dados da sessão que queremos atualizar
    //SaveAndFlush = salve, vacia e atualiza novamente o dado que estamos atualizando
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        Speaker existingSpeaker = speakerRepository.findById(id).get();
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }


}
