package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.LoginService;
import com.advices.InvalidCredentialsException;
import com.dto.LoginDto;
import com.entities.Login;
@CrossOrigin
@RestController
@RequestMapping("/lms")
public class LoginController {
	@Autowired
	LoginService loginservice;
	
	@PostMapping("/login")
	public ResponseEntity<LoginDto> login(@RequestBody Login login) throws InvalidCredentialsException
	{
		LoginDto dto=loginservice.login(login);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@PatchMapping("/logout/{email}")
	public ResponseEntity<LoginDto> logout(@PathVariable("email") String email) throws InvalidCredentialsException{
		LoginDto dto=loginservice.logout(email);
		return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}
}
