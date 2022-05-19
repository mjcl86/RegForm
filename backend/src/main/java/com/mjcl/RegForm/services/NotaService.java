package com.mjcl.RegForm.services;

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

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepo;

    @Autowired
    private AlunaRepository alunaRepo;

    @Autowired
    private FormacaoRepository formaRepo;

    public void saveNota(NotaDTO dto){
        Aluna aluna = alunaRepo.getById(dto.getAluna_id());
        Formacao formacao = formaRepo.getById(dto.getFormacao_id());
        Nota nota = new Nota();
        nota.setResult(dto.getResult());
        nota.setAluna(aluna);
        nota.setFormacao(formacao);
    }

    public Integer findById(Integer aluna_id, Integer formacao_id) {
        NotaPK notaPK = new NotaPK();
        notaPK.setAluna(alunaRepo.getById(aluna_id));
        notaPK.setFormacao(formaRepo.getById(formacao_id));
        return notaRepo.findById(notaPK).get().getResult();
    }

}
