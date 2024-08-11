package exercise.controller;

import exercise.dto.AuthorDTO;
import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @GetMapping("")
    public ResponseEntity<List<AuthorDTO>> index() {
        var authorsDto = authorService.findAll();
        return ResponseEntity.ok(authorsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> show(@PathVariable long id) {
        var authorDto = authorService.find(id);
        return ResponseEntity.ok(authorDto);
    }

    @PostMapping("")
    public ResponseEntity<AuthorDTO> create(@Valid @RequestBody AuthorCreateDTO authorData) {
        var authorDto = authorService.create(authorData);
        return ResponseEntity.status(201).body(authorDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> update(@PathVariable long id,
                                            @Valid @RequestBody AuthorUpdateDTO authorData) {
        var authorDto = authorService.update(id, authorData);
        return ResponseEntity.ok(authorDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        authorService.delete(id);
        return ResponseEntity.status(200).build();
    }
    // END
}
