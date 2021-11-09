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

import com.Service.AdminService;
import com.entities.Admin;
import com.entities.Books;
import com.entities.BooksOrder;
import com.entities.DamagedBooks;
import com.entities.Users;

@RestController
@RequestMapping("/lms")
public class AdminController {
	@Autowired
	private AdminService adminservice;
	
	@PostMapping("/admindetails")
	public ResponseEntity<Books> addAdminDetails(@RequestBody Admin admin)
	{
		Admin b1 = adminservice.addAdminDetails(admin);
		ResponseEntity re = new ResponseEntity<Admin>(b1, HttpStatus.OK);
		return re;
	}

	@PostMapping("/usersvalidate")
	public ResponseEntity<Users> ValidateUserDetails(@RequestBody Users user) throws Throwable
	{
		Users login=adminservice.ValidateUserDetails(user);
		ResponseEntity re = new ResponseEntity<Users>(login,HttpStatus.OK);
		return re;
    }
	 	
	 @PostMapping("/AddBooks")
	 public ResponseEntity<Books> addbooks(@RequestBody Books book)
	 {
		Books b1 = adminservice.addBooks(book);
		ResponseEntity re = new ResponseEntity<Books>(b1, HttpStatus.OK);
		return re;
	 }

	@PutMapping(path = "/UpdateBooks")
	public ResponseEntity<Books> updatebooks(@RequestBody Books book) throws Throwable
	{
		Books b1 = adminservice.updateBooks(book);
		ResponseEntity re = new ResponseEntity<Books>(b1, HttpStatus.OK);
		return re;
	}

	@DeleteMapping(path = "/deleteBooks/{bookid}")
	public ResponseEntity<String> deleteById(@PathVariable long bookid)
	{
		adminservice.removeBooks(bookid);
		ResponseEntity re = new ResponseEntity<String>("Deleted", HttpStatus.OK);
		return re;
	}

	@PostMapping("/AddBooksOrder")
	public ResponseEntity<BooksOrder> addbooksorder(@RequestBody BooksOrder booksOrder)
	{
		BooksOrder b1 = adminservice.addBookorder(booksOrder);
		ResponseEntity re = new ResponseEntity<BooksOrder>(b1, HttpStatus.OK);
		return re;
	}

	@PutMapping(path = "/UpdateBooksOrder")
	public ResponseEntity<BooksOrder> updatebooksorder(@RequestBody BooksOrder booksOrder) throws Throwable 
	{
		BooksOrder b1 = adminservice.updateBookorder(booksOrder);
		ResponseEntity re = new ResponseEntity<BooksOrder>(b1, HttpStatus.OK);
		return re;
	}

	@DeleteMapping(path = "/deleteBooksOrder/{orderId}")
	public ResponseEntity<String> deleteById1(@PathVariable int orderId) 
	{
		adminservice.removeBookorder(orderId);
		ResponseEntity re = new ResponseEntity<String>("Deleted", HttpStatus.OK);
		return re;
	}

	@GetMapping("/SearchBookTitle/{title}")
	public ResponseEntity<List<Books>> SearchBookByTitle(@PathVariable String title)
	{
		List<Books> c = adminservice.getBookByTitle(title);
		ResponseEntity re = new ResponseEntity<List<Books>>(c, HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/SearchBookSubject/{subject}")
	public ResponseEntity<List<Books>> SearchBookBySubject(@PathVariable String subject) 
	{
		List<Books> c = adminservice.getBookBySubject(subject);
		ResponseEntity re = new ResponseEntity<List<Books>>(c, HttpStatus.OK);
		return re;
		
	}
	
	@PostMapping("/AddDamagedBooks")
	public ResponseEntity<DamagedBooks> adddamagedbooks(@RequestBody DamagedBooks DamagedBooks)
	{
		DamagedBooks b1 = adminservice.addDamagedBooks(DamagedBooks);
		ResponseEntity re = new ResponseEntity<DamagedBooks>(b1, HttpStatus.OK);
		return re;
	}

	@GetMapping("/getDamagedBooks")
	public ResponseEntity<List<DamagedBooks>> getDamagedBooks()
	{
		List<DamagedBooks> lc1 = adminservice.viewDamagedBooksList();
		ResponseEntity re = new ResponseEntity<List<DamagedBooks>>(lc1, HttpStatus.OK);
		return re;
	}

	@GetMapping(path = "/getDamagedBooks/{id}")
	public ResponseEntity<DamagedBooks> getDamagedBooksId(@PathVariable int id) throws Throwable
	{
		DamagedBooks c1 = adminservice.viewDamagedBookById(id);
		ResponseEntity re = new ResponseEntity<DamagedBooks>(c1, HttpStatus.OK);
		return re;
	}

}
