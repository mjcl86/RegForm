package com.mjcl.RegForm.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "notas")
public class Nota {

    @EmbeddedId

    private NotaPK id = new NotaPK();
    private Integer result;

    public Nota() {
    }

    public Nota(NotaPK id, Integer result) {
        this.id = id;
        this.result = result;
    }

    public NotaPK getId() {
        return id;
    }

    public void setId(NotaPK id) {
        this.id = id;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public void setAluna(Aluna aluna) {
        id.setAluna(aluna);
    }

    public void setFormacao(Formacao formacao) {
        id.setFormacao(formacao);
    }
}
