package com.mjcl.RegForm.entities;

import com.mjcl.RegForm.dtos.AlunaDTO;
import com.mjcl.RegForm.dtos.FormacaoDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "formacoes")
public class Formacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String start;
    private String end;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Aluna> students = new ArrayList<>();

    public Formacao() {
    }

    public Formacao(FormacaoDTO dto) {
        this.name = dto.getName();
        this.start = dto.getStart();
        this.end = dto.getEnd();
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

    public List<Aluna> getStudents() {
        return students;
    }

    public void addAluna(Aluna aluna) {
        students.add(aluna);
    }

    public void removeAluna(Integer alunaId) {
        if (students.contains(students.get(alunaId))) {
            students.remove(alunaId);
        }
    }
}
