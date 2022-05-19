package com.mjcl.RegForm.controllers.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class NotaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "aluna_id")
    private Aluna aluna;

    @ManyToOne
    @JoinColumn(name = "formacao_id")
    private Formacao formacao;

    public NotaPK() {
    }

    public Aluna getAluna() {
        return aluna;
    }

    public void setAluna(Aluna aluna) {
        this.aluna = aluna;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }
}
