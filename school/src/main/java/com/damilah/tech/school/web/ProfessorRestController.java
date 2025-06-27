package com.damilah.tech.school.web;

import com.damilah.tech.school.model.Professor;
import com.damilah.tech.school.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = {"http://localhost:3000"}
)
@RequestMapping({"/professors"})
public class ProfessorRestController {
    private final ProfessorService professorService;

    public ProfessorRestController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> findAll() {
        return this.professorService.findAll();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Professor> findById(@PathVariable Long id) {
        return this.professorService.findById(id).map((professor) -> {
            return ResponseEntity.ok().body(professor);
        }).orElseGet(() -> {
            return ResponseEntity.badRequest().build();
        });
    }
}
