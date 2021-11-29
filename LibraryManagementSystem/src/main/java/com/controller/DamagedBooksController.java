package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.DamagedBooksService;
import com.dto.DamagedBooksDto;
import com.entities.DamagedBooks;
@CrossOrigin
@RestController
@RequestMapping("/lms")
public class DamagedBooksController {
	@Autowired
	DamagedBooksService damagedbookservice;
	
	@GetMapping(path="/viewDamagedBookById/{id}")
	public ResponseEntity<DamagedBooksDto> viewDamagedBookById(@PathVariable int id) throws Throwable
	{
	    DamagedBooksDto db =damagedbookservice.viewDamagedBookById(id);
		ResponseEntity<DamagedBooksDto> re = new ResponseEntity<DamagedBooksDto>(db,HttpStatus.OK);
		return re;
		
	}
	@PostMapping(path="/addDamagedBooks")
	public ResponseEntity<DamagedBooks> addDamagedBooks(@RequestBody DamagedBooksDto dbookid) {
		
		DamagedBooks db1=damagedbookservice.addDamagedBooks(dbookid);
		ResponseEntity<DamagedBooks> re=new ResponseEntity<DamagedBooks>(db1,HttpStatus.OK);
		return re;
		
	}
	@PutMapping(path="/updateDamagedBooks")
	public ResponseEntity<DamagedBooks> updateDamagedBookDetails(@RequestBody DamagedBooksDto dbookid) throws Throwable
	{
		DamagedBooks db2 = damagedbookservice.updateDamagedBookDetails(dbookid);
		ResponseEntity<DamagedBooks> re = new ResponseEntity<DamagedBooks>(db2,HttpStatus.OK);
		return re;
	}
	@GetMapping(path="/viewDamagedBooksList")
	public ResponseEntity<List<DamagedBooks>> viewDamagedBooksList() {
		
		List<DamagedBooks> db3=damagedbookservice.viewDamagedBooksList();
		ResponseEntity<List<DamagedBooks>> re = new ResponseEntity<List<DamagedBooks>>(db3,HttpStatus.OK);
		return re;
		
	}
	@DeleteMapping("/deleteDamagedBooks/{id}")
	public ResponseEntity<String> deleteDamagedBooks(@PathVariable int id) throws Throwable
	{
		damagedbookservice.deleteDamagedBooks(id);
		ResponseEntity<String> re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
}
