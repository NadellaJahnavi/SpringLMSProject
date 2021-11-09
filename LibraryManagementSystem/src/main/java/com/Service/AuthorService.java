package com.Service;

import java.util.List;

import com.entities.Author;

public interface AuthorService {
	public Author addAuthorDetails(Author author);
	public Author updateAuthorDetails(Author author) throws Throwable;
	public String deleteAuthorDetails(int authorId) throws Throwable;
	public List<Author> viewAuthorsList();
	public Author viewAuthorById(int authorId) throws Throwable;
	public Author getAuthorByFirstName(String firstName) throws Throwable;
	public Author getByEmail(String email) throws Throwable;
}
