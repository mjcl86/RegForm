package com.mjcl.RegForm.controllers;

import com.mjcl.RegForm.dtos.NotaDTO;
import com.mjcl.RegForm.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotaController {

    @Autowired
    private NotaService service;

    @PutMapping
    public void saveNota(NotaDTO dto) {
        service.saveNota(dto);
    }
}

