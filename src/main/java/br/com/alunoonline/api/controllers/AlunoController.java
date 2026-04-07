package br.com.alunoonline.api.controllers;

import br.com.alunoonline.api.models.Aluno;
import br.com.alunoonline.api.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping("/")
    public Iterable<Aluno> index() {
        return alunoService.index();
    }

    @GetMapping("/{id}")
    public Aluno findById(@PathVariable Long id) {
        return alunoService.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
        return ResponseEntity.status(201).body(alunoService.create(aluno));
    }

    @PutMapping("/update/{id}")
    public Aluno update(@RequestBody Aluno aluno, @PathVariable Long id) {
        return alunoService.update(id, aluno);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
