package com.pgs.upskill.upskillrdsservice.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "books")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public Book addBook(@RequestBody CreateBookDTO createBookDTO) {
        return bookRepository.save(new Book(createBookDTO.getName()));
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
