package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.DamagedBooks;

@Repository
public interface DamagedBooksRepository extends JpaRepository<DamagedBooks,Integer>
{

}
