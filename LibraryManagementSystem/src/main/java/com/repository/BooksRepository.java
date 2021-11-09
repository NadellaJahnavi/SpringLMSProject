package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Books;

public interface BooksRepository extends JpaRepository<Books,Long>{

	List<Books> findBookByTitle(String title);

	List<Books> findBookBySubject(String subject);

}
