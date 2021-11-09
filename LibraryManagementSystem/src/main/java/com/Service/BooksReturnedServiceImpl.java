package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.BooksReturned;
import com.repository.BooksReturnedRepository;
@Service
public class BooksReturnedServiceImpl implements BooksReturnedService{
@Autowired
BooksReturnedRepository booksreturnrepo;

	@Override
	public BooksReturned returnBooks(BooksReturned returned) {
		booksreturnrepo.save(returned);	
		return returned;
	}

	@Override
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned) throws Throwable {
		int rid = booksReturned.getId();
		//Supplier s1 = ()-> new ReturnNotFoundException("Book not Returned");
		BooksReturned b1 = booksreturnrepo.findById(rid).orElseThrow();
		//b1.setBooks(booksReturned.getBooks());
		b1.setDelayed_Days(booksReturned.getDelayed_Days());
		b1.setPenalty(booksReturned.getPenalty());
		b1.setPenalty_Status(booksReturned.getPenalty_Status());
		b1.setReturnedDate(booksReturned.getReturnedDate());
		booksreturnrepo.save(b1);
		return b1;
	}

	@Override
	public List<BooksReturned> viewReturnedBooksList() {
		List<BooksReturned> lbr = booksreturnrepo.findAll();
		return lbr;
	}

	@Override
	public List<BooksReturned> viewDelayedBooksList() {
		List<BooksReturned> bo1 = booksreturnrepo.findAll();
		return bo1;
	}

}
