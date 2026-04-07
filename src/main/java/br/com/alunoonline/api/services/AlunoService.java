package br.com.alunoonline.api.services;

import br.com.alunoonline.api.exceptions.ResourceNotFoundException;
import br.com.alunoonline.api.models.Aluno;
import br.com.alunoonline.api.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Iterable<Aluno> index() {
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno nao encontrado para o id " + id));
    }

    public Aluno create(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno update(Long id, Aluno aluno) {
        Aluno alunoExistente = findById(id);

        if (aluno.getName() != null) {
            alunoExistente.setName(aluno.getName());
        }

        if (aluno.getEmail() != null) {
            alunoExistente.setEmail(aluno.getEmail());
        }

        if (aluno.getCpf() != null) {
            alunoExistente.setCpf(aluno.getCpf());
        }

        return alunoRepository.save(alunoExistente);
    }

    public void delete(Long id) {
        findById(id);
        alunoRepository.deleteById(id);
    }
}
