package com.Service;

import java.util.List;

import com.entities.BooksReturned;

public interface BooksReturnedService {
	public BooksReturned returnBooks(BooksReturned returned);
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned) throws Throwable;
	public List<BooksReturned> viewReturnedBooksList();
	public List<BooksReturned> viewDelayedBooksList();
}
