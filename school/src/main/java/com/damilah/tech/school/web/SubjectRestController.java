package com.damilah.tech.school.web;

import com.damilah.tech.school.model.Subject;
import com.damilah.tech.school.model.enumerations.SubjectLevel;
import com.damilah.tech.school.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = {"http://localhost:3000"}
)
@RequestMapping({"/subjects"})
public class SubjectRestController {
    private final SubjectService subjectService;

    public SubjectRestController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> findAll(@RequestParam(required=false) String name) {
        if(name!=null){
            return this.subjectService.filterByName(name);
        }
        return this.subjectService.findAll();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Subject> findById(@PathVariable Long id) {
        return this.subjectService.findById(id).map((subject) -> {
            return ResponseEntity.ok().body(subject);
        }).orElseGet(() -> {
            return ResponseEntity.badRequest().build();
        });
    }

}
