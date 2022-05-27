package com.mjcl.RegForm.dtos;

import com.mjcl.RegForm.entities.Aluna;
import com.mjcl.RegForm.entities.Formacao;
import com.mjcl.RegForm.entities.Nota;

import java.util.ArrayList;
import java.util.List;

public class AlunaDTO {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String city;
    private Integer contact;
    private List<NotaDTO> results = new ArrayList<>();

    public AlunaDTO() {
    }

    public AlunaDTO(Aluna aluna) {
        this.id = aluna.getId();
        this.firstname = aluna.getFirstName();
        this.lastname = aluna.getLastname();
        this.email = aluna.getEmail();
        this.city = aluna.getCity();
        this.contact = aluna.getContact();
        setResults(aluna.getResults());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public List<NotaDTO> getClasses() {
        return results;
    }

    public void setResults(List<Nota> list) {
        for(Nota res : list){
            NotaDTO notaDTO = new NotaDTO(res);
            results.add(notaDTO);
        }
    }
}
