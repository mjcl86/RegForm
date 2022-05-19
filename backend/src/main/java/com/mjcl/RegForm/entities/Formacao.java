package com.mjcl.RegForm.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "formacoes")
public class Formacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String start;
    private String end;

    public Formacao() {
    }

    public Formacao(Integer id, String name, String start, String end) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

}
