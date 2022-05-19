package com.mjcl.RegForm.dtos;

import com.mjcl.RegForm.entities.Nota;

public class NotaDTO {

    private int result;
    private int aluna_id;
    private int formacao_id;

    public NotaDTO() {
    }

    public NotaDTO(Nota nota) {
        this.result = nota.getResult();
        this.aluna_id = nota.getId().getAluna().getId();
        this.formacao_id = nota.getId().getFormacao().getId();
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getAluna_id() {
        return aluna_id;
    }

    public void setAluna_id(int aluna_id) {
        this.aluna_id = aluna_id;
    }

    public int getFormacao_id() {
        return formacao_id;
    }

    public void setFormacao_id(int formacao_id) {
        this.formacao_id = formacao_id;
    }
}
