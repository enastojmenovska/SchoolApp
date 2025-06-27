package com.damilah.tech.school.web;

import com.damilah.tech.school.model.Literature;
import com.damilah.tech.school.service.LiteratureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = {"http://localhost:3000"}
)
@RequestMapping({"/literature"})
public class LiteratureRestController {
    private final LiteratureService literatureService;

    public LiteratureRestController(LiteratureService literatureService) {
        this.literatureService = literatureService;
    }

    @GetMapping
    public List<Literature> findAll() {
        return this.literatureService.findAll();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Literature> findById(@PathVariable Long id) {
        return this.literatureService.findById(id).map((literature) -> {
            return ResponseEntity.ok().body(literature);
        }).orElseGet(() -> {
            return ResponseEntity.badRequest().build();
        });
    }

}
