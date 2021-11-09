package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer>
{
	
	Login findByUserName(String userName);
}
