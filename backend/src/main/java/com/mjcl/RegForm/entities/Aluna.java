package com.mjcl.RegForm.entities;

import com.mjcl.RegForm.dtos.AlunaDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alunas")
public class Aluna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String city;
    private Integer contact;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Nota> results = new ArrayList<>();

    public Aluna() {
    }

    public Aluna(Integer id, String firstName, String lastName, String email, String city, Integer contact) {
        this.id = id;
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
        this.city = city;
        this.contact = contact;
    }

    public Aluna(AlunaDTO dto) {
        if(dto.getId() != 0){
            this.id = dto.getId();
        }
        this.firstname = dto.getFirstname();
        this.lastname = dto.getLastname();
        this.email = dto.getEmail();
        this.city = dto.getCity();
        this.contact = dto.getContact();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
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

    public List<Nota> getResults() {
        return results;
    }

    public void addResult(Nota res){
        results.add(res);
    }

    public void removeResult(Nota res){
        if (results.contains(res)) {
            results.remove(res);
        }
    }
}
