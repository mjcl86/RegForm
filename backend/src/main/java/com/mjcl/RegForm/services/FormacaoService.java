package com.mjcl.RegForm.services;

import com.mjcl.RegForm.dtos.AlunaDTO;
import com.mjcl.RegForm.dtos.FormacaoDTO;
import com.mjcl.RegForm.entities.Aluna;
import com.mjcl.RegForm.entities.Formacao;
import com.mjcl.RegForm.repositories.AlunaRepository;
import com.mjcl.RegForm.repositories.FormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FormacaoService {

    @Autowired
    private FormacaoRepository repository;

    @Autowired
    private AlunaRepository alunaRepo;

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

    @Transactional
    public FormacaoDTO saveFormacao(FormacaoDTO dto) {
        Formacao form = new Formacao(dto);
        repository.saveAndFlush(form);
        dto.setId(form.getId());
        return dto;
    }

    @Transactional
    public void addAluna(Integer formacaoId, Integer alunaId) {
        Formacao form = repository.getById(formacaoId);
        Aluna aluna = alunaRepo.getById(alunaId);
        form.addAluna(aluna);
        repository.saveAndFlush(form);
    }

    @Transactional(readOnly = true)
    public List<AlunaDTO> listAlunas(Integer formacaoId) {
        Formacao form = repository.getById(formacaoId);
        List<Aluna> alunas = form.getStudents();
        List<AlunaDTO> dto = new ArrayList<>();
        for(Aluna al : alunas){
            dto.add(new AlunaDTO(al));
        }
        return dto;
    }

    @Transactional
    public String deleteFormacao(Integer id) {
        Optional<Formacao> form = repository.findById(id);
        if(form.isPresent()) {
            repository.delete(form.get());
            return "Formação eliminada com sucesso!";
        }
        return "O id de formação facultado não existe!";
    }
}
