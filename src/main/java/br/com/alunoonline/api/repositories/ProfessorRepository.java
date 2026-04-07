package br.com.alunoonline.api.repositories;

import br.com.alunoonline.api.models.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long>  {
}
