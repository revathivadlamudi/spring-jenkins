package com.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.spring.persistence.Book;

@Component
public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findByTitle(String title);
}
