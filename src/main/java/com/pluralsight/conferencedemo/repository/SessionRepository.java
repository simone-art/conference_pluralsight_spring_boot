package com.pluralsight.conferencedemo.repository;

import com.pluralsight.conferencedemo.models.Session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Session é a clase
//O segundo atributo()Long é a primary key
@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

}
