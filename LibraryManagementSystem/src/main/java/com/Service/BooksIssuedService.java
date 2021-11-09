package com.Service;


import java.util.List;

import com.entities.BooksIssued;

public interface BooksIssuedService  {
	public BooksIssued addIssuedBook(BooksIssued issued);
	public BooksIssued updateIssuedBookDetails(BooksIssued booksIssued) throws Throwable;
	public List<BooksIssued> viewBooksIssuedList();
	List<BooksIssued> findByQuantitySorted(int quantity);
	BooksIssued getByIssueId(int issueId) throws Throwable;
	public String deleteIssuedBooks(BooksIssued book) throws Throwable;

}
