package com.mjcl.RegForm.services;

import com.mjcl.RegForm.dtos.AlunaDTO;
import com.mjcl.RegForm.dtos.FormacaoDTO;
import com.mjcl.RegForm.entities.Aluna;
import com.mjcl.RegForm.entities.Formacao;
import com.mjcl.RegForm.repositories.FormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormacaoService {

    @Autowired
    private FormacaoRepository repository;

    @Transactional(readOnly = true)
    public List<FormacaoDTO> listAll() {
        List<Formacao> result = repository.findAll();
        List<FormacaoDTO> dto = new ArrayList<>();
        for(Formacao form: result){
            dto.add(new FormacaoDTO(form));
        }
        return dto;
    }

    @Transactional(readOnly = true)
    public FormacaoDTO findById(Integer id) {
        if(repository.existsById(id)) {
            Formacao form = repository.getById(id);
            return new FormacaoDTO(form);
        }
        return null;
    }
}
