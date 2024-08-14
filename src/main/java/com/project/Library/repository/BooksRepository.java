package com.project.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Library.entities.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {

}
