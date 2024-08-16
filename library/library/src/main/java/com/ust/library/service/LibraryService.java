
package com.ust.library.service;

import com.ust.library.entity.Author;
import com.ust.library.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LibraryService {

    //For Author
    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Long id);

    Author saveAuthor(Author author);

    void deleteAuthor(Long id);


    // for books
    List<Book> getAllBooks();

    Optional<Book> getBookById(Long id);

    Book saveBook(Book book);

    void deleteBook(Long id);
}
