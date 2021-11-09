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

import com.Service.AuthorService;
import com.entities.Author;

@RestController
@RequestMapping("/lms")
public class AuthorController {
@Autowired
AuthorService authorservice;

@PostMapping("/addAuthor")
public ResponseEntity<Author> addAuthorDetails(@RequestBody Author a){
	Author a1=authorservice.addAuthorDetails(a);
	ResponseEntity re=new ResponseEntity<Author>(a1,HttpStatus.OK);
	return re;
}

@PutMapping("/updateAuthor")
public ResponseEntity<Author> updateAuthorDetails(@RequestBody Author a) throws Throwable{
	Author a2=authorservice.updateAuthorDetails(a);
	ResponseEntity re=new ResponseEntity<Author>(a2,HttpStatus.OK);
	return re;
}

@DeleteMapping("/deleteAuthor/{authorId}")
public ResponseEntity<String> deleteAuthorDetails(@PathVariable int authorId) throws Throwable{
	authorservice.deleteAuthorDetails(authorId);
	ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
	return re;
}

@GetMapping("/viewAuthor")
public ResponseEntity<List<Author>> viewAuthorsList(){
	List<Author> list=authorservice.viewAuthorsList();
	ResponseEntity re=new ResponseEntity<List<Author>>(list,HttpStatus.OK);
	return re;
}

@GetMapping("/viewAuthorbyId/{authorId}")
public ResponseEntity<Author> viewAuthorById(@PathVariable int authorId) throws Throwable{
	Author a1=authorservice.viewAuthorById(authorId);
	ResponseEntity re=new ResponseEntity<Author>(a1,HttpStatus.OK);
	return re;
}

@GetMapping("/getAuthors/{firstName}")
public ResponseEntity<Author> getAuthorByFname(@PathVariable String firstName) throws Throwable{
	Author a2=authorservice.getAuthorByFirstName(firstName);
	ResponseEntity re=new ResponseEntity<Author>(a2,HttpStatus.OK);
	return re;
}

@GetMapping("/getAuthor/{email}")
public ResponseEntity<Author> getByemail(@PathVariable String email) throws Throwable {
	Author l1=authorservice.getByEmail(email);
	ResponseEntity re=new ResponseEntity<Author>(l1,HttpStatus.OK);
	return re;
}
}
