package com.Service;

import java.util.List;

import com.dto.BooksDto;
import com.entities.Books;

public interface BooksService {
	public Books addBook(BooksDto book);
	public Books updateBookDetails(BooksDto book) throws Throwable;
	public String removeBook(Long bookid) throws Throwable;
	public BooksDto searchBookByTitle(String title) throws Throwable;
	public BooksDto searchBookBySubject(String subject) throws Throwable;
	public List<Books> viewAllBooks();
	public Books viewBookById(Long bookid) throws Throwable;
}
