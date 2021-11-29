package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Books;

public interface BooksRepository extends JpaRepository<Books,Long>{

	Optional<Books> findBookByTitle(String title);

	Optional<Books> findBookBySubject(String subject);

}
