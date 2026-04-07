package br.com.alunoonline.api.services;

import br.com.alunoonline.api.exceptions.ResourceNotFoundException;
import br.com.alunoonline.api.models.Professor;
import br.com.alunoonline.api.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Iterable<Professor> index() {
        return professorRepository.findAll();
    }

    public Professor findById(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado para o id " + id));
    }

    public Professor create(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor update(Long id, Professor professor) {
        Professor professorExistente = findById(id);

        if (professor.getName() != null) {
            professorExistente.setName(professor.getName());
        }

        if (professor.getEmail() != null) {
            professorExistente.setEmail(professor.getEmail());
        }

        if (professor.getCpf() != null) {
            professorExistente.setCpf(professor.getCpf());
        }

        return professorRepository.save(professorExistente);
    }

    public void delete(Long id) {
        findById(id);
        professorRepository.deleteById(id);
    }
}
