package com.project.Library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Library.entities.Books;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

	@GetMapping
	public ResponseEntity<Books> findAll(){
		Books b = new Books(null, "Harry Potter", "Fulano", 100.0);
		return ResponseEntity.ok().body(b);
	}
}
