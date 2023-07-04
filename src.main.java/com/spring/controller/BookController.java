package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.customexecption.BookIdMismatchException;
import com.spring.customexecption.BookNotFoundException;
import com.spring.persistence.Book;
import com.spring.repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping
	public Iterable findAll() {
		return bookRepository.findAll();
	}
	
	@GetMapping("title/{bookTitle}")
	public List findTitle(@PathVariable String bookTitle) {
		return bookRepository.findByTitle(bookTitle);
	}
	
	@GetMapping("{/id}")
	public Book findOne(@PathVariable long id) {
		return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Book create(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@DeleteMapping("{/id}")
	public void delete(@PathVariable long id) {
		bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
		bookRepository.deleteById(id);
	}
	
	@PutMapping
	public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
		if (book.getId() != id) {
          throw new BookIdMismatchException();
        }
		bookRepository.findById(id)
          .orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
	}
}