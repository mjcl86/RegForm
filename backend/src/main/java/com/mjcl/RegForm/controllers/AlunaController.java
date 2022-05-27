package com.mjcl.RegForm.controllers;

import com.mjcl.RegForm.dtos.AlunaDTO;
import com.mjcl.RegForm.dtos.NotaDTO;
import com.mjcl.RegForm.services.AlunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/alunas/new")
    public AlunaDTO newAluna(@RequestBody AlunaDTO dto) {
        return service.save(dto);
    }

    @PostMapping(value = "/alunas/{id}/newresult")
    public void addResult(@PathVariable Integer id, @RequestBody NotaDTO nota) {
        service.newResult(id, nota);
    }

    @GetMapping(value = "/alunas/{id}/results")
    public List<NotaDTO> listResults(@PathVariable Integer id) {
        return service.listResults(id);
    }

    @DeleteMapping(value = "/alunas/{id}/delete")
    public String deleteAluna(@PathVariable Integer id) {
        return service.deleteAluna(id);
    }

    @PostMapping(value = "/alunas/{id}/edit")
    public AlunaDTO updateAluna(@RequestBody AlunaDTO aluna) {
        return service.save(aluna);
    }


    /*
    @GetMapping(value = "/alunas/passed")
    public List<AlunaDTO> listPassed() {
        //return service.listPassed();
    }
    */
}
