package com.pluralsight.conferencedemo.repository;

import com.pluralsight.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

//Speaker é a clase
//O segundo atributo()Long é a primary key
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
