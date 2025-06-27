package com.damilah.tech.school.web;

import com.damilah.tech.school.model.User;
import com.damilah.tech.school.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = {"http://localhost:3000"}
)
@RequestMapping({"/user"})
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @GetMapping({"/chosen-subjects"})
    public ResponseEntity<User> findByUsername() {
        String username = "ena.stojmenovska";
        return this.userService.findByUsername(username).map((user) -> {
            return ResponseEntity.ok().body(user);
        }).orElseGet(() -> {
            return ResponseEntity.badRequest().build();
        });
    }

    @PutMapping({"/add-subject/{id}"})
    public ResponseEntity<User> addSubjectToUser(@PathVariable Long id) {
        String username = "ena.stojmenovska";
        //System.out.println(username);
        return this.userService.findByUsername(username)
                .flatMap(user -> this.userService.addSubjectToUser(id, username))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping({"/delete-subject/{id}"})
    public ResponseEntity<User> removeSubjectFromUser(@PathVariable Long id) {
        String username = "ena.stojmenovska";
        return this.userService.findByUsername(username)
                .flatMap(user -> {
                    this.userService.removeSubjectFromUser(id,username);
                    return this.userService.findByUsername(username);
                })
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}


