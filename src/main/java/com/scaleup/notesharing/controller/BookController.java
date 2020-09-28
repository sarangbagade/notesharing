package com.scaleup.notesharing.controller;

import com.scaleup.notesharing.models.Book;
import com.scaleup.notesharing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping(value = "/books/book")
	public String addBook(@RequestBody Book book) {
		System.out.println(book.getName());
		System.out.println("post req called");
		bookService.save(book);
		return "added";
	}

	@DeleteMapping(value = "/books/{id}")
	public Book deleteBook(@PathVariable long id) {
		return bookService.deleteById(id);
	}

	// to do : take subject ids from user(admin) and delete all books in that
	// subject
	@GetMapping(value = "/findBySubject")
	public List<Book> findBySubject(@RequestHeader Long id) {
		return bookService.findBySubjectId(id);
	}

	@GetMapping(value = "/books")
	public ResponseEntity<Page<Book>> check(@RequestParam(name="offset" ,required=false,defaultValue="0") int offset,
			@RequestParam(name="limit", required=false, defaultValue="10") int limit) {
		
		return  new ResponseEntity<Page<Book>>( bookService.findAll(offset, limit), HttpStatus.OK);
	}
}
