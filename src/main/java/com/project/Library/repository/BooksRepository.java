package com.project.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Library.entities.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

}
