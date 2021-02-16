package com.pluralsight.conferencedemo.repository;

import com.pluralsight.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Speaker é a clase
//O segundo atributo()Long é a primary key
@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
