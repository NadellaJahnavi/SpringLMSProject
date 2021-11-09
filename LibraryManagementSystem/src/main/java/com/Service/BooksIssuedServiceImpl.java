package com.Service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.BookNotFoundException;
import com.entities.BooksIssued;
import com.repository.BooksIssuedRepository;
@Service
public class BooksIssuedServiceImpl implements BooksIssuedService{
	@Autowired
	private BooksIssuedRepository bookissuerepo;
	@Override
	public BooksIssued addIssuedBook(BooksIssued issued) {
		return bookissuerepo.save(issued);	
		}

	@Override
	public BooksIssued updateIssuedBookDetails(BooksIssued booksIssued) throws Throwable {
		int issueId = booksIssued.getIssueId();
		  Supplier s1= ()->new BookNotFoundException("Book Does not exist in the database");
		  BooksIssued  b1=bookissuerepo.findById(issueId).orElseThrow(s1);
		  b1.setIssueId(booksIssued.getIssueId());
		  b1.setIssueDate(booksIssued.getIssueDate());
		  b1.setDueDate(booksIssued.getDueDate());
		  b1.setQuantity(booksIssued.getQuantity());
		  bookissuerepo.save(b1) ;
		  return b1;
	}

	@Override
	public List<BooksIssued> viewBooksIssuedList() {
		List<BooksIssued> lc1 = bookissuerepo.findAll();
		return lc1;

	}

	@Override
	public List<BooksIssued> findByQuantitySorted(int quantity) {
		 List<BooksIssued> lc=bookissuerepo.findByQuantitySorted(quantity);
		  return lc;	
		  }

	@Override
	public BooksIssued getByIssueId(int issueId) throws Throwable{
		Supplier s1= ()->new BookNotFoundException("Book Does not exist in the database");
		BooksIssued b=bookissuerepo.findByIssueId(issueId).orElseThrow(s1);
		  return b;
		
	}

	@Override
	public String deleteIssuedBooks(BooksIssued book) throws Throwable {
		  //int issueId = bookid.getIssueId();
		  Supplier s1= ()->new BookNotFoundException("Book Does not exist in the database");		
		  bookissuerepo.delete(book);
		  return "deleted";

	}

}
