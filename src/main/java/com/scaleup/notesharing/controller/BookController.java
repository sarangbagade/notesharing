package com.scaleup.notesharing.controller;

import com.scaleup.notesharing.models.Book;
import com.scaleup.notesharing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/addBook")
    public String addBook(@RequestBody Book book)
    {
        System.out.println(book.getName());
        System.out.println("post req called");
        bookService.save(book);
        return "added";
    }

    @DeleteMapping(value = "/deleteBook/{bookName}")
    public Book deleteBook(@PathVariable String bookName)
    {
        return bookService.deleteByName(bookName);
    }

    //to do : take subject ids from user(admin) and delete all books in that subject
    @GetMapping(value = "/findBySubject")
    public List<Book> findBySubject(@RequestHeader Long id)
    {
        return bookService.findBySubjectId(id);
    }

    @GetMapping(value = "/booksAll")
    public List<Book> check()
    {
        return bookService.findAll();
    }
}
