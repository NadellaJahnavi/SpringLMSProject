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

import com.Service.UsersService;
import com.dto.UsersDto;
import com.entities.Users;
@CrossOrigin
@RestController
@RequestMapping("/lms")
public class UsersController {
	@Autowired
	UsersService userservice;
	@PostMapping("/addusers")
	public ResponseEntity<Users> registerUserDetails(@RequestBody UsersDto user) throws Throwable 
	{
		Users u1=userservice.registerUserDetails(user); 
		ResponseEntity re = new ResponseEntity<Users>(u1,HttpStatus.OK);	
		return re;		
	}
	@DeleteMapping("/deleteUser/{userid}")
	   public ResponseEntity<String> deleteUserDetails( @PathVariable int userid )throws Throwable{
	 	userservice.deleteUserDetails(userid); 
	 	 ResponseEntity re  = new ResponseEntity<String>("Deleted",HttpStatus.OK);
	    return re;
	    }
   @PutMapping("/updateUser")
   public ResponseEntity<Users> updateUserDetails(@RequestBody UsersDto user)throws Throwable
   {
	   
   Users e1=userservice.updateUserDetails(user);
   ResponseEntity re = new ResponseEntity<Users>(e1,HttpStatus.OK);
   return re;
	   
   }
   @GetMapping("/viewuserslist")
   
	 public ResponseEntity<List<Users>> viewAllUsersList() {
	   List<Users> db3=userservice.viewAllUsers();
		ResponseEntity re = new ResponseEntity<List<Users>>(db3,HttpStatus.OK);
		return re;
   }
   
   @GetMapping("/viewUserById/{userid}")
   public ResponseEntity<Users> viewUserById( @PathVariable int  userid) throws Throwable{
	 Users u =userservice.viewUserById(userid);
	 ResponseEntity<Users>re= new ResponseEntity<Users>(u,HttpStatus.OK);
	 return re;
   }
//   @PostMapping("/loginvalidate")
//   public ResponseEntity<Users> loginValidate(@RequestBody Users user) throws Throwable
//   {
//	   Users login=userservice.loginValidate(user);
//	   ResponseEntity re = new ResponseEntity<Users>(login,HttpStatus.OK);
//	   return re;
//   }
}
