package com.project.Library.controller;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.Library.entities.Books;
import com.project.Library.service.BooksService;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

	@Autowired
	private BooksService booksService;

	@GetMapping
	public ResponseEntity<List<Books>> findAll() {

		List<Books> list = booksService.listBooks();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Books> findById(@PathVariable Long id) {
		Books obj = booksService.findBooksById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Books> insert(@RequestBody Books obj) {
		obj = booksService.saveBooks(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		booksService.deleteBooks(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Books> update(@PathVariable Long id, @RequestBody Books obj) {
		obj = booksService.updateBooks(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
