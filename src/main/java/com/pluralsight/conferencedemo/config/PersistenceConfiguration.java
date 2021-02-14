package com.pluralsight.conferencedemo.config;

//Clase que funciona para cria ou configurar modificações na database

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    //@Bean //Anotacão que permite a customizacão de objetos/ No momento de rodar printa o seguinte erro:
    //Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment] por isso tireo o Bean
    //Método que retorna dados de origem
    public DataSource datasource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:mysql://localhost:3306/conference_app?createDatabaseIfNotExist=true&serverTimezone=UTC");
        builder.password("simone23");
        System.out.println("My custom datasource bean has been initialized and set");
        return builder.build();
    }
}
