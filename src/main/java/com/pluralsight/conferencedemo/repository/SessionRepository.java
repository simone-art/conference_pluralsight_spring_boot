package com.pluralsight.conferencedemo.repository;

import com.pluralsight.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

//Session é a clase
//O segundo atributo()Long é a primary key
public interface SessionRepository extends JpaRepository<Session, Long> {

}
