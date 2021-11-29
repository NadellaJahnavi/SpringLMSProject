package com.Service;


import java.util.List;

import com.dto.BookIssuedDto;
import com.entities.BooksIssued;

public interface BooksIssuedService  {
	public BooksIssued addIssuedBook(BookIssuedDto issued) throws Throwable;
	public BooksIssued updateIssuedBookDetails(BookIssuedDto booksIssued) throws Throwable;
	
	public List<BooksIssued> viewBooksIssuedList();
	
  
    public 	BookIssuedDto findByIssueId(int issueId) throws Throwable;
	
	 public boolean deleteIssuedBooks(int issueId) throws Throwable;
	
}
