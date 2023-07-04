package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.repository.BookRepository;

@Service
public class BookService {
	private BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}
	
}
