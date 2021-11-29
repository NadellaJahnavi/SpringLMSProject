package com.Service;

import java.util.List;

import com.dto.BooksReturnedDto;
import com.entities.BooksReturned;

public interface BooksReturnedService {
	public BooksReturned returnBooks(BooksReturnedDto returned);
	public BooksReturned updateReturnedBookDetails(BooksReturnedDto booksReturned) throws Throwable;
	public List<BooksReturned> viewReturnedBooksList();
	public List<BooksReturned> viewDelayedBooksList();
}
