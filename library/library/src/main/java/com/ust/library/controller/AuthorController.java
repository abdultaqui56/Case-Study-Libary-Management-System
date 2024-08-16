
package com.ust.library.controller;

import com.ust.library.entity.Author;
import com.ust.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping //
    public List<Author> getAllAuthors() {
        return libraryService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable Long id) {
        return libraryService.getAuthorById(id);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return libraryService.saveAuthor(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        Optional<Author> existingAuthor = libraryService.getAuthorById(id);
        if (existingAuthor.isPresent()) {
            existingAuthor.get().setName(author.getName());
            existingAuthor.get().setBooks(author.getBooks());
            return libraryService.saveAuthor(existingAuthor.orElse(null));
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        libraryService.deleteAuthor(id);
    }
}
