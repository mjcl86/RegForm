package com.mjcl.RegForm.controllers;

import com.mjcl.RegForm.dtos.AlunaDTO;
import com.mjcl.RegForm.dtos.NotaDTO;
import com.mjcl.RegForm.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NotaController {

    @Autowired
    private NotaService service;

    @PutMapping(value = "/nota")
    public void saveNota(@RequestBody NotaDTO dto) {
        service.saveNota(dto);
    }

    @GetMapping(value = "/formacoes/{id}/notas")
    public List<NotaDTO> listNotas(@PathVariable Integer id) {
        return service.getNotas(id);
    }

    @DeleteMapping(value = "/formacoes/{fid}/alunas/{aid}")
    public void deleteNota(@PathVariable Integer fid, Integer aid) {
        service.deleteNota(fid, aid);
    }
}

