package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.BooksService;
import com.entities.Books;


@RestController
@RequestMapping(path="/lms")
public class BooksController {
	
	@Autowired
	BooksService booksservice;
	
	@PostMapping(path="/addBooks")
	public ResponseEntity<Books> addBook(@RequestBody Books book)
	{
		Books b1 = booksservice.addBook(book);
		ResponseEntity re = new ResponseEntity<Books>(b1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateBookDetails")
	public ResponseEntity<Books> UpdateBookDetails(@RequestBody Books book) throws Throwable
	{
		Books b2 = booksservice.updateBookDetails(book);
		ResponseEntity re = new ResponseEntity<Books>(b2,HttpStatus.OK);
		return  re;
		
	}
	
	@DeleteMapping(path="/RemoveBook")
	public ResponseEntity<Books> RemoveBooks(@RequestBody Books book)
	{
		 booksservice.removeBook(book);
	     ResponseEntity re = new ResponseEntity<String>("Books removed",HttpStatus.OK);
	     return re;
		
	}
	
	@GetMapping("/searchBookByTitle/{title}")
	public ResponseEntity<List<Books>> SearchBookByTitle(@PathVariable String title) 
	{
		List<Books> b3=booksservice.getBookByTitle(title);
		ResponseEntity re=new ResponseEntity<List<Books>>(b3,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/searchBookBySubject/{subject}")
	public ResponseEntity<List<Books>> SearchBookBySubject(@PathVariable String subject) 
	{
		List<Books> b3=booksservice.getBookBySubject(subject);
		ResponseEntity re=new ResponseEntity<List<Books>>(b3,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/viewAllBooks")
	public ResponseEntity<Books> ViewAllBooks()
	{
		List<Books> lb = booksservice.viewAllBooks();
		ResponseEntity re=new ResponseEntity<List<Books>>(lb,HttpStatus.OK);
		return re;	
	}
}