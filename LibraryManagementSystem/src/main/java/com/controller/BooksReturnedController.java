package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.BooksReturnedService;
import com.entities.BooksReturned;

@RestController
@RequestMapping("/lms")
public class BooksReturnedController {
	@Autowired
	BooksReturnedService bookreturnservice;
	
	@PostMapping("/returnbooks")
	public ResponseEntity<BooksReturned> returnBooks(@RequestBody BooksReturned returned)
	{
		 BooksReturned b1=bookreturnservice.returnBooks(returned);
		 ResponseEntity re=new ResponseEntity<BooksReturned>(b1,HttpStatus.OK);
		 return re;
	}
	
	@PutMapping("/updatereturnbdetails")
	public ResponseEntity<BooksReturned> updateReturnedBookDetails(BooksReturned booksReturned) throws Throwable
	{
         BooksReturned e1=bookreturnservice.updateReturnedBookDetails(booksReturned);
		
		ResponseEntity re=new ResponseEntity<BooksReturned>(e1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/viewbooklist")
	public ResponseEntity<List<BooksReturned>> viewReturnedBooksList()
	{
		List<BooksReturned> v1=bookreturnservice.viewReturnedBooksList();
		ResponseEntity re=new ResponseEntity<List<BooksReturned>>(v1,HttpStatus.OK);
		return re;

	}
	
	@GetMapping("/viewdelayedbooks")
	  public ResponseEntity<List<BooksReturned>> ViewDelayedBooksList() {
	  List<BooksReturned> l1=bookreturnservice.viewDelayedBooksList();
	  ResponseEntity re=new ResponseEntity<List<BooksReturned>>(l1,HttpStatus.OK);
	  return re;
	  }
	 
}
