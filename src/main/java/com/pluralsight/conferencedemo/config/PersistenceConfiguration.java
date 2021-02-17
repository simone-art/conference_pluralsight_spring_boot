package com.pluralsight.conferencedemo.config;

//Clase que funciona para cria ou configurar modificações na database

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration

public class PersistenceConfiguration {

    //@Bean //Anotacão que permite a customizacão de objetos/ No momento de rodar printa o seguinte erro:
    //Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment] por isso tireo o Bean
    //Método que retorna dados de origem

//
//    @Bean
//    public DataSource datasource(){
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.url("jdbc:mysql://localhost:3306/conference_app?createDatabaseIfNotExist=true&serverTimezone=UTC");
//        builder.username("root");
//        builder.password("simone23");
//        System.out.println("My custom datasource bean has been initialized and set");
//        return builder.build();
//    }
//
//    //Tem a responsabilidade de criar o hibernate session factory
//    @Bean(name="entityManagerFactory")
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(datasource());
//        //Scaneia o pacote das entidades que estão na pasta models
//        sessionFactory.setPackagesToScan(new String[]{"com.pluralsight.conferencedemo.models"});
//        return sessionFactory;
//    }
//
//    @Bean
//    @Autowired
//    //Deletado o hibernate porque está dando erro e incluido o JpaTransactionManager
//    //Com o JPA rodou com sucesso e consegui ver a api na tela
//    public JpaTransactionManager transactionManager(final SessionFactory sessionFactory){
//        final JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(sessionFactory);
//        return txManager;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
//        entityManager.setDataSource(datasource());
//        entityManager.setPackagesToScan(new String[] { "com.pluralsight.conferencedemo.models\"" });
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        entityManager.setJpaVendorAdapter(vendorAdapter);
//        //entityManager.setJpaProperties(additionalProperties());
//
//        return entityManager;
//    }
//

}
