package com.mjcl.RegForm.controllers;

import com.mjcl.RegForm.dtos.AlunaDTO;
import com.mjcl.RegForm.services.AlunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlunaController {

    @Autowired
    private AlunaService service;

    @GetMapping(value = "/alunas")
    public List<AlunaDTO> listAll() {
        return service.listAll();
    }

    @GetMapping(value = "/alunas/{id}")
    public AlunaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
