package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.DamagedBooksService;
import com.entities.DamagedBooks;

@RestController
@RequestMapping("/lms")
public class DamagedBooksController {
	@Autowired
	DamagedBooksService damagedbookservice;
	
	@GetMapping(path="/getdamagedbooksbyid/{id}")
	public ResponseEntity<DamagedBooks> viewDamagedBookById(@PathVariable int id) throws Throwable
	{
	    DamagedBooks db =damagedbookservice.viewDamagedBookById(id);
		ResponseEntity re = new ResponseEntity<DamagedBooks>(db,HttpStatus.OK);
		return re;
		
	}
	@PostMapping(path="/addDamagedBooks")
	public ResponseEntity<DamagedBooks> AddDamagedBooks(@RequestBody DamagedBooks dbooks) {
		
		DamagedBooks db1=damagedbookservice.addDamagedBooks(dbooks);
		ResponseEntity re=new ResponseEntity<DamagedBooks>(db1,HttpStatus.OK);
		return re;
		
	}
	@PutMapping(path="/updateDamagedBooks")
	public ResponseEntity<DamagedBooks> updateDamagedBookDetails(@RequestBody DamagedBooks dbooks) throws Throwable
	{
		DamagedBooks db2 = damagedbookservice.updateDamagedBookDetails(dbooks);
		ResponseEntity re = new ResponseEntity<DamagedBooks>(db2,HttpStatus.OK);
		return re;
	}
	@GetMapping(path="/getdamagedbookslist")
	public ResponseEntity<DamagedBooks> viewDamagedBooksList() {
		
		List<DamagedBooks> db3=damagedbookservice.viewDamagedBooksList();
		ResponseEntity re = new ResponseEntity<List<DamagedBooks>>(db3,HttpStatus.OK);
		return re;
		
	}
}
