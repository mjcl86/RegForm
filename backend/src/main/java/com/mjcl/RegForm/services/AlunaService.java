package com.mjcl.RegForm.services;

import com.mjcl.RegForm.dtos.AlunaDTO;
import com.mjcl.RegForm.entities.Aluna;
import com.mjcl.RegForm.repositories.AlunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunaService {

    @Autowired
    private AlunaRepository repository;

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
}
