package com.pluralsight.conferencedemo.models;

import javax.persistence.*;
import java.util.List;

//Name "" é o nome da tabela na database
// O nome da tabela deve ser em plural
// O nome da classe é em singular porque representa uma fila dessa tabela
@Entity(name="sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long session_id;
    private String session_name;
    private String session_description;
    private String session_length;

    //JPA relationship
    @ManyToMany
    @JoinTable(
            name = "session_speakers",
            joinColumns = @JoinColumn(name= "session_id"),
            inverseJoinColumns = @JoinColumn(name= "speaker_id")
    )
    private List<Speaker>Speakers;

    public Session() {
    }

    public List<Speaker> getSpeakers() {
        return Speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        Speakers = speakers;
    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSession_description() {
        return session_description;
    }

    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }

    public String getSession_length() {
        return session_length;
    }

    public void setSession_length(String session_length) {
        this.session_length = session_length;
    }
}
