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

import com.Service.BooksOrderService;
import com.dto.BooksorderDto;
import com.entities.BooksOrder;
@CrossOrigin
@RestController
@RequestMapping("/lms")
public class BooksOrderController {
	@Autowired
	BooksOrderService bookorderservice;
	@PostMapping(path="/placeOrder")
	public ResponseEntity<BooksOrder> placeBooksOrder(@RequestBody BooksorderDto orderdetails) {
		
		BooksOrder ord1 =bookorderservice.placeBooksOrder(orderdetails);
		ResponseEntity re=new ResponseEntity<BooksOrder>(ord1,HttpStatus.OK);
		return re;
		
	}
	@DeleteMapping(path="/cancelOrder/{orderId}")
	public ResponseEntity<String> cancelOrder(@PathVariable int orderId) throws Throwable
	{
		    bookorderservice.cancelOrder(orderId);
		     ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
		     return re;
	}
	@PutMapping(path="/updateOrder")
	public ResponseEntity<BooksOrder> updateOrder(@RequestBody BooksorderDto order) throws Throwable
	{
		BooksOrder ord1 = bookorderservice.updateOrder(order);
		ResponseEntity re = new ResponseEntity<BooksOrder>(ord1,HttpStatus.OK);
		return re;
	}
	@GetMapping(path="/viewOrderList")
	public ResponseEntity<List<BooksOrder>> viewOrdersList() {
		
		List<BooksOrder> v1=bookorderservice.viewOrdersList();
		ResponseEntity re=new ResponseEntity<>(v1,HttpStatus.OK);
		return re;
		
	}
	@GetMapping(path="/viewOrderById/{orderId}")
	public ResponseEntity<BooksorderDto> viewOrderById(@PathVariable int orderId) throws Throwable
	{
		BooksorderDto bo2=bookorderservice.viewOrderById(orderId);
		ResponseEntity re = new ResponseEntity<BooksorderDto>(bo2,HttpStatus.OK);
		return re;
		
	}


}
