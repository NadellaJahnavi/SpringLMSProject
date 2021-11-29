package com.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.BookNotFoundException;
import com.dto.BookIssuedDto;
import com.entities.Books;
import com.entities.BooksIssued;
import com.entities.Users;
import com.repository.BooksIssuedRepository;
import com.repository.BooksRepository;
import com.repository.UsersRepository;
@Service
public class BooksIssuedServiceImpl implements BooksIssuedService{
	@Autowired
	private BooksIssuedRepository brep;
	@Autowired 
	BooksRepository repo;
	@Autowired 
	UsersRepository rep;
	@Override
	public BooksIssued addIssuedBook(BookIssuedDto issued) throws Throwable {
		  BooksIssued std1= new BooksIssued(); 
		  std1.setIssueId(issued.getIssueId());
		  std1.setIssueDate(issued.getIssueDate());
		  std1.setDueDate(issued.getDueDate());
		  Optional<Users> user= rep.findById(issued.getUserid());
		  Users u= user.get();
		  std1.setUsers(u);
		  Optional<Books> books= repo.findById(issued.getBookid()); 
		  Books b=books.get();
		  std1.setBooks(b);
		  brep.save(std1);
		  return std1;		
	}

	@Override
	public BooksIssued updateIssuedBookDetails(BookIssuedDto booksIssued) throws Throwable {

		  Optional<BooksIssued> b=brep.findById(booksIssued.getIssueId());
		  if(!b.isPresent())
		  { 
			  throw new BookNotFoundException("Book Does not exist in the database");
		  } 
		  BooksIssued std=b.get();  
		  std.setIssueDate(booksIssued.getIssueDate());
		  std.setDueDate(booksIssued.getDueDate());	

		  return brep.save(std);		
	}

	@Override
	public List<BooksIssued> viewBooksIssuedList() {
		List<BooksIssued> book = brep.findAll();
		return book;
	}

	@Override
	public BookIssuedDto findByIssueId(int issueId) throws Throwable {
		Optional<BooksIssued> book=brep.findById(issueId);
		if(!book.isPresent())
		{
			throw new  BookNotFoundException("Issued Book Does not exist in the database"+issueId);
		}
		
		 BooksIssued b= book.get();
		 	BookIssuedDto dto=new BookIssuedDto();
		 	dto.setIssueId(b.getIssueId());
		 	dto.setIssueDate(b.getIssueDate());
		 	dto.setDueDate(b.getDueDate()); 
			dto.setBookid(b.getBooks().getBookid());
			dto.setUserid(b.getUsers().getUserid());
		    return dto;
	}

	@Override
	public boolean deleteIssuedBooks(int issueId) throws Throwable {
		Supplier s = () -> new  BookNotFoundException("issued book not found");
		BooksIssued b = brep.findById(issueId).orElseThrow(s);
		if (b != null) {
			brep.deleteById(issueId);
			return true;
		}
		return false;
	}
	

}
