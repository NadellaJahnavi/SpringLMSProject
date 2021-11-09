package com.Service;

import java.util.List;

import com.entities.Books;

public interface BooksService {
	public Books addBook(Books book);
	public Books updateBookDetails(Books book) throws Throwable;
	public String removeBook(Books book);
	public List<Books> getBookByTitle(String title);
	public List<Books> getBookBySubject(String subject);
	public List<Books> viewAllBooks();
}
