package com.mjcl.RegForm.services;

import com.mjcl.RegForm.dtos.AlunaDTO;
import com.mjcl.RegForm.dtos.NotaDTO;
import com.mjcl.RegForm.entities.Aluna;
import com.mjcl.RegForm.entities.Formacao;
import com.mjcl.RegForm.entities.Nota;
import com.mjcl.RegForm.entities.NotaPK;
import com.mjcl.RegForm.repositories.AlunaRepository;
import com.mjcl.RegForm.repositories.FormacaoRepository;
import com.mjcl.RegForm.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunaService {

    @Autowired
    private AlunaRepository repository;

    @Autowired
    private FormacaoRepository formRepo;

    @Autowired
    private NotaRepository notaRepo;

    @Transactional(readOnly = true)
    public List<AlunaDTO> listAll() {
        List<Aluna> result = repository.findAll();
        List<AlunaDTO> dto = new ArrayList<>();
        for(Aluna aluna : result){
            dto.add(new AlunaDTO(aluna));
        }
        return dto;
    }

    @Transactional(readOnly = true)
    public AlunaDTO findById(Integer id) {
        if(repository.existsById(id)) {
            Aluna aluna = repository.getById(id);
            return new AlunaDTO(aluna);
        }
        return null;
    }

    @Transactional
    public AlunaDTO save(AlunaDTO dto) {
        Aluna aluna = new Aluna(dto);
        repository.saveAndFlush(aluna);
        dto.setId(aluna.getId());
        return dto;
    }

    @Transactional
    public void newResult(Integer alunaId, NotaDTO dto) {
        Aluna aluna = repository.getById(alunaId);
        Formacao form = formRepo.getById(dto.getFormacao_id());
        NotaPK notaPK = new NotaPK();
        notaPK.setAluna(aluna);
        notaPK.setFormacao(form);
        Nota nota = new Nota(notaPK, dto.getResult());
        notaRepo.save(nota);
        aluna.addResult(nota);
        repository.save(aluna);
    }

    @Transactional(readOnly = true)
    public List<NotaDTO> listResults(Integer id) {
        Aluna aluna = repository.getById(id);
        List<Nota> notas = aluna.getResults();
        List<NotaDTO> dto = (List<NotaDTO>) notas.stream().map(x -> (new NotaDTO(x)));
        return dto;
    }

    @Transactional
    public String deleteAluna(Integer id) {
        Optional<Aluna> aluna = repository.findById(id);
        if(aluna.isPresent()) {
            repository.delete(aluna.get());
            return "Aluna eliminada com sucesso!";
        }
        return "O id de aluna facultado não existe!";
    }

}
