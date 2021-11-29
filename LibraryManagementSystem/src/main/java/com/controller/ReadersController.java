package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Service.ReadersService;
import com.advices.ReaderNotFoundException;
import com.entities.Readers;
@CrossOrigin
@RestController
@RequestMapping("/lms")
public class ReadersController {
	@Autowired
	ReadersService readerserv;
	
	@PostMapping("/register")	
	public ResponseEntity<Readers> register(@RequestBody Readers r)
	{
	   Readers r1=readerserv.register(r);
	   ResponseEntity re=new ResponseEntity<Readers>(r1,HttpStatus.OK);
	   return re;
	}
	
	@DeleteMapping("/deleteReader/{id}")
	public ResponseEntity<String> deleteReader(@PathVariable  int id) throws Throwable
	{
		readerserv.deleteReader(id);
		ResponseEntity<String> re = new ResponseEntity<String>("deleted",HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/updateReader")
	public ResponseEntity<Readers> updateReaderDetails(@RequestBody Readers reader)throws Throwable
	{
		Readers e1=readerserv.updateReaderDetails(reader);
		ResponseEntity re = new ResponseEntity<Readers>(e1,HttpStatus.OK);
		return re;
	}
	
	@PatchMapping(path = "/login")
	public String loginvalidate(@RequestParam String id, String password) throws ReaderNotFoundException
	{	
		readerserv.loginvalidate(id, password);
		return "Login Successful!!!";
	}
	
	@GetMapping("/viewreaderlist")
	public ResponseEntity<List<Readers>> viewReadersList() 
	{
		List<Readers> r3 = readerserv.viewReadersList();
		ResponseEntity re = new ResponseEntity<List<Readers>>(r3,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/viewreaderbyid/{id}")
	public ResponseEntity<Readers> viewReaderById(@PathVariable int id)
	{
		
		Readers m1=readerserv.viewReaderById(id);
		ResponseEntity re = new ResponseEntity<Readers>(m1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getPassword")
	public ResponseEntity<Readers> getPassword(@RequestBody String password)
	{
		Readers r1=readerserv.getPassword(password);
		ResponseEntity re = new ResponseEntity<Readers>(r1,HttpStatus.OK);
		return re;
		
	}
	
	@GetMapping("/getMobileno")
	public ResponseEntity<Readers> getMobileno(@RequestBody String mobileno)
	{
		Readers re=readerserv.getMobileno(mobileno);
		ResponseEntity rm = new ResponseEntity<Readers>(re,HttpStatus.OK);
		return rm;
	}
}
