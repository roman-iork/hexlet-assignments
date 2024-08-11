package exercise.controller;

import java.util.List;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @GetMapping("")
    public ResponseEntity<List<BookDTO>> index() {
        var booksDto = bookService.findAll();
        return ResponseEntity.ok(booksDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> show(@PathVariable long id) {
        var bookDto = bookService.find(id);
        return ResponseEntity.ok(bookDto);
    }

    @PostMapping("")
    public ResponseEntity<BookDTO> create(@Valid @RequestBody BookCreateDTO bookData) {
        var bookDto = bookService.create(bookData);
        return ResponseEntity.status(201).body(bookDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable long id,
                                          @Valid @RequestBody BookUpdateDTO bookData) {
        var bookDto = bookService.update(id, bookData);
        return ResponseEntity.ok(bookDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        bookService.delete(id);
        return ResponseEntity.status(200).build();
    }
    // END
}
