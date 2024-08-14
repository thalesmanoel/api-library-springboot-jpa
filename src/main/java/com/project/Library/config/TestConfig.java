package com.project.Library.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.Library.entities.Books;
import com.project.Library.repository.BooksRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private BooksRepository booksRepository;

	@Override
	public void run(String... args) throws Exception {
		Books b1 = new Books(null, "Name1", "Author1", 100.0);
		Books b2 = new Books(null, "Name2", "Author2", 150.0);
		
		booksRepository.saveAll(Arrays.asList(b1, b2));
	}
}
