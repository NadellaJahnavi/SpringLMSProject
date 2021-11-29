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

import com.Service.BooksIssuedService;
import com.dto.BookIssuedDto;
import com.entities.BooksIssued;
@CrossOrigin
@RestController
@RequestMapping("/lms")
public class BooksIssuedController {
	@Autowired 
	BooksIssuedService bookissuedservice;
	
	@PostMapping("/add")
	public ResponseEntity<BooksIssued> add(@RequestBody BookIssuedDto issued) throws Throwable
	{
		 BooksIssued b1=bookissuedservice.addIssuedBook(issued);
		 ResponseEntity re=new ResponseEntity<BooksIssued>(b1,HttpStatus.OK);
		return re;
		  
	}
	
	@PutMapping("/update")
	public ResponseEntity<BooksIssued> updateIssuedBookDetails(@RequestBody BookIssuedDto booksIssued) throws Throwable 
	{
		BooksIssued  e1=bookissuedservice.updateIssuedBookDetails(booksIssued);
		
		ResponseEntity<BooksIssued> re=new ResponseEntity<BooksIssued>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping("/delete/{issueId}")
	public ResponseEntity<BooksIssued> deleteIssuedBooks(@PathVariable int issueId) throws Throwable
	{
		bookissuedservice.deleteIssuedBooks(issueId);
		
		ResponseEntity re=new ResponseEntity<String>("deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<BooksIssued>> viewBooksIssuedList()
	{
		List<BooksIssued> v1=bookissuedservice.viewBooksIssuedList();
		ResponseEntity re=new ResponseEntity<List<BooksIssued>>(v1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/viewByIssuedId/{issueId}")
	public  ResponseEntity<BooksIssued> findByIssuedId(@PathVariable int issueId) throws Throwable
	{
		BookIssuedDto c=bookissuedservice.findByIssueId(issueId);
		ResponseEntity re=new ResponseEntity<BookIssuedDto>(c,HttpStatus.OK);
		return re;
	}

}
