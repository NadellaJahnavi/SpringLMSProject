package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.AdminService;
import com.entities.Admin;

@RestController
@RequestMapping("/lms")
public class AdminController {
	@Autowired
	private AdminService adminservice;
	
	@PostMapping("/admindetails")
	public ResponseEntity<Admin> addAdminDetails(@RequestBody Admin admin)
	{
		Admin b1 = adminservice.addAdminDetails(admin);
		ResponseEntity<Admin> re = new ResponseEntity<Admin>(b1, HttpStatus.OK);
		return re;
	}
}
