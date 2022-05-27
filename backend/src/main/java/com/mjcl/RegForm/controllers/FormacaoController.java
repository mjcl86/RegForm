package com.mjcl.RegForm.controllers;

import com.mjcl.RegForm.dtos.AlunaDTO;
import com.mjcl.RegForm.dtos.FormacaoDTO;
import com.mjcl.RegForm.entities.Formacao;
import com.mjcl.RegForm.services.FormacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/formacoes/new")
    public FormacaoDTO saveFormacao(@RequestBody FormacaoDTO dto) {
        return service.saveFormacao(dto);
    }

    @PostMapping(value = "/formacoes/{id}/newaluna")
    public void addAluna(@PathVariable Integer id, @RequestBody AlunaDTO aluna) {
        service.addAluna(id, aluna.getId());
    }

    @GetMapping(value = "/formacoes/{id}/alunas")
    public List<AlunaDTO> listAlunas(@PathVariable Integer id) {
        return service.listAlunas(id);
    }

    @DeleteMapping(value = "/formacoes/{id}/delete")
    public String deleteFormacao(@PathVariable Integer id) {
        return service.deleteFormacao(id);
    }
}
