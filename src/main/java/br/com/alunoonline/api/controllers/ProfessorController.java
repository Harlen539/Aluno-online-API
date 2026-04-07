package br.com.alunoonline.api.controllers;

import br.com.alunoonline.api.models.Professor;
import br.com.alunoonline.api.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/")
    public Iterable<Professor> index() {
        return professorService.index();
    }

    @GetMapping("/{id}")
    public Professor findById(@PathVariable Long id) {
        return professorService.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Professor> create(@RequestBody Professor professor) {
        return ResponseEntity.status(201).body(professorService.create(professor));
    }

    @PutMapping("/update/{id}")
    public Professor update(@RequestBody Professor professor, @PathVariable Long id) {
        return professorService.update(id, professor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
