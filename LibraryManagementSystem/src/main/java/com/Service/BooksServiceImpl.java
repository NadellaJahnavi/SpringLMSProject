package com.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.BookNotFoundException;
import com.dto.BooksDto;
import com.entities.Author;
import com.entities.Books;
import com.entities.Publishers;
import com.repository.AuthorRepository;
import com.repository.BooksRepository;
import com.repository.PublisherRepository;

@Service
public class BooksServiceImpl implements BooksService{
@Autowired
private BooksRepository repo;
@Autowired
AuthorRepository authorrepo;
@Autowired
PublisherRepository publisherrepo;
@Override
public Books addBook(BooksDto book) {
	Books r1 = new Books();
	r1.setBookid(book.getBookid());
	r1.setTitle(book.getTitle());
	r1.setIsbncode(book.getIsbncode());
	r1.setBookcost(book.getBookcost());
	r1.setSubject(book.getSubject());
	r1.setQuantity(book.getQuantity());
	r1.setShelfdetails(book.getShelfdetails());
	r1.setPublishedyear(book.getPublishedyear());
	Optional<Publishers> publisher = publisherrepo.findById(book.getPublisherId());
	Publishers p1 = publisher.get();
	r1.setPublisher(p1);
	Optional<Author> author = authorrepo.findById(book.getAuthorId());
	Author b1 = author.get();
	r1.setAuthor(b1);
	repo.save(r1);
	return r1;
}

@Override
public Books updateBookDetails(BooksDto book) throws Throwable {
	Optional<Books> b = repo.findById(book.getBookid());
	if (!b.isPresent()) {
		throw new BookNotFoundException("Book not found with given id ");
	}
	Books std = b.get();
	std.setBookid(book.getBookid());
	std.setTitle(book.getTitle());
	std.setIsbncode(book.getIsbncode());
	std.setBookcost(book.getBookcost());
	std.setSubject(book.getSubject());
	std.setQuantity(book.getQuantity());
	std.setShelfdetails(book.getShelfdetails());
	std.setPublishedyear(book.getPublishedyear());
	repo.save(std);
	return std;
}

@Override
public String removeBook(Long bookid) throws Throwable {
	Supplier s1 = () -> new BookNotFoundException("Book Does not exist in the database");
	Books book = repo.findById(bookid).orElseThrow(s1);
	repo.delete(book);
	return "deleted";
}

@Override
public BooksDto searchBookByTitle(String title) throws Throwable {
	Optional<Books> book = repo.findBookByTitle(title);
	if (!book.isPresent()) {
		throw new BookNotFoundException("Book Does not exist with given title " + title);
	}

	Books std = book.get();

	BooksDto dto = new BooksDto();
	dto.setBookid(std.getBookid());
	dto.setTitle(std.getTitle());
	dto.setIsbncode(std.getIsbncode());
	dto.setBookcost(std.getBookcost());
	dto.setSubject(std.getSubject());
	dto.setQuantity(std.getQuantity());
	dto.setShelfdetails(std.getShelfdetails());
	dto.setPublishedyear(std.getPublishedyear());
	dto.setAuthorId(std.getAuthor().getAuthorId());

	return dto;
}

@Override
public BooksDto searchBookBySubject(String subject) throws Throwable {
	Optional<Books> book = repo.findBookBySubject(subject);
	if (!book.isPresent()) {
		throw new BookNotFoundException("Book Does not exist with given subject " + subject);
	}

	Books std = book.get();

	BooksDto dto = new BooksDto();
	dto.setBookid(std.getBookid());
	dto.setTitle(std.getTitle());
	dto.setIsbncode(std.getIsbncode());
	dto.setBookcost(std.getBookcost());
	dto.setSubject(std.getSubject());
	dto.setQuantity(std.getQuantity());
	dto.setShelfdetails(std.getShelfdetails());
	dto.setPublishedyear(std.getPublishedyear());
	dto.setAuthorId(std.getAuthor().getAuthorId());
	dto.setPublisherId(std.getPublisher().getPublisherId());
	return dto;
}

@Override
public List<Books> viewAllBooks() {
	List<Books> lb2 = repo.findAll();
	return lb2;
}

@Override
public Books viewBookById(Long bookid) throws Throwable {
	Supplier s1 = () -> new BookNotFoundException("Book Does not exist in the database");
	Books b1 = repo.findById(bookid).orElseThrow(s1);
	return b1;
}


}
