package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> 
{
	
   Optional<Author> findByFirstName(String firstName) ;
   
   Optional<Author> findByEmail(String email);
}
