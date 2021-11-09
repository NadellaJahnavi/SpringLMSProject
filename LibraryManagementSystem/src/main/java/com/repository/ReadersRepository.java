package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Readers;
@Repository
public interface ReadersRepository extends JpaRepository<Readers,Integer> {
	
	Readers findByPassword(String password);
	
	Readers findByMobileno(String mobileno);
}
