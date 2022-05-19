package com.mjcl.RegForm.controllers;

import com.mjcl.RegForm.dtos.FormacaoDTO;
import com.mjcl.RegForm.services.FormacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FormacaoController {

    @Autowired
    private FormacaoService service;

    @GetMapping(value = "/formacoes")
    public List<FormacaoDTO> listAll() {
        return service.listAll();
    }

    @GetMapping(value = "/formacoes/{id}")
    public FormacaoDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
