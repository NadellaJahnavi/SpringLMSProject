package com.Service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.BookNotFoundException;
import com.entities.Books;
import com.repository.AdminRepository;
import com.repository.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService{
@Autowired
private BooksRepository repo;
@Override
public Books addBook(Books book) {
	repo.save(book);
	return book;
}

@Override
public Books updateBookDetails(Books book)  throws Throwable {
    long bid = book.getBookid();
	Supplier s1 = ()-> new BookNotFoundException("Book Does Not Exist in the Database");
	Books b1 = repo.findById(bid).orElseThrow(s1);
	b1.setTitle(book.getTitle());
	b1.setSubject(book.getSubject());
	//b1.setAuthor(book.getAuthor());
	b1.setPublished_year(book.getPublished_year());
	b1.setPublished_year(book.getPublished_year());
	b1.setIsbn_code(book.getIsbn_code());
	b1.setQuantity(book.getQuantity());
	b1.setBook_cost(book.getBook_cost());
	b1.setShelf_details(book.getShelf_details());
	repo.save(b1);
	
	
	return b1;
}

@Override
public String removeBook(Books books) {
	repo.delete(books);
	return "Book Removed";
}

@Override
public List<Books> getBookByTitle(String title) {
	List<Books> lb = repo.findBookByTitle(title);
	return lb;
}

@Override
public List<Books> getBookBySubject(String subject) {
	 List<Books> lb1 = repo.findBookBySubject(subject);
		return lb1;
}

@Override
public List<Books> viewAllBooks() {
	List<Books> lb2 = repo.findAll();
	return lb2;
}

}
