package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.BooksIssued;

@Repository
public interface BooksIssuedRepository extends JpaRepository<BooksIssued,Integer> 
{
	Optional<BooksIssued> findByIssueId(int issueId);
	
}
