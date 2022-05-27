package com.mjcl.RegForm.dtos;

import com.mjcl.RegForm.entities.Formacao;

import java.util.ArrayList;
import java.util.List;

public class FormacaoDTO {

    private Integer id;
    private String name;
    private String start;
    private String end;
    private List<AlunaDTO> students = new ArrayList<>();
    public FormacaoDTO() {
    }

    public FormacaoDTO(Formacao formacao) {
        this.id = formacao.getId();
        this.name = formacao.getName();
        this.start = formacao.getStart();
        this.end = formacao.getEnd();
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
