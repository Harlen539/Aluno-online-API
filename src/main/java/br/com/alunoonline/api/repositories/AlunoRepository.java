package br.com.alunoonline.api.repositories;

import br.com.alunoonline.api.models.Aluno;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {}
