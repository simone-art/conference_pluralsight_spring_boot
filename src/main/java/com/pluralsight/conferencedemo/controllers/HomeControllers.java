package com.pluralsight.conferencedemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeControllers {

    //@Value utilizas o valor da variável que está no application.properties pra
    //quanda o programa inicializar, a anotação customizada busque essa variável e
    //seu valor e injecta esse valor no atributo da versão
    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    @RequestMapping("/")
    public Map getStatus(){
        Map map = new HashMap<String,String>();
            map.put("app-version",appVersion);
            return map;
        }

}

