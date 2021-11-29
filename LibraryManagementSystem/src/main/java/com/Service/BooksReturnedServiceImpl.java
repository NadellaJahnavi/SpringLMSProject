package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.BookNotFoundException;
import com.dto.BooksReturnedDto;
import com.entities.Books;
import com.entities.BooksReturned;
import com.entities.Users;
import com.repository.BooksRepository;
import com.repository.BooksReturnedRepository;
import com.repository.UsersRepository;
@Service
public class BooksReturnedServiceImpl implements BooksReturnedService{
@Autowired
BooksReturnedRepository booksreturnrepo;
@Autowired 
UsersRepository userrepo;
@Autowired
BooksRepository booksrepo;

	@Override
	public BooksReturned returnBooks(BooksReturnedDto returned) {
		BooksReturned r1=new BooksReturned();
		r1.setId(returned.getId());
		r1.setDelayedDays(returned.getDelayedDays());
		r1.setPenalty(returned.getPenalty());
		r1.setPenaltyStatus(returned.getPenaltyStatus());
		r1.setReturnedDate(returned.getReturnedDate());
		//Users user=new Users();
		Optional<Users> user=userrepo.findById(returned.getUserid());
	    Users u1=user.get();
	    r1.setUsers(u1);
	    Optional<Books> books=booksrepo.findById(returned.getBookid());
	    Books b1=books.get();
	    r1.setBooks(b1);
		booksreturnrepo.save(r1);
		return r1;
		
	}

	@Override
	public BooksReturned updateReturnedBookDetails(BooksReturnedDto booksReturned) throws Throwable {
		Optional<BooksReturned> b = booksreturnrepo.findById(booksReturned.getId());
        if(!b.isPresent()) {
            throw new BookNotFoundException("Book not found with given id ");
        }
        BooksReturned std = b.get();
        std.setDelayedDays(booksReturned.getDelayedDays());
        std.setPenalty(booksReturned.getPenalty());
        std.setPenaltyStatus(booksReturned.getPenaltyStatus());
        std.setReturnedDate(booksReturned.getReturnedDate());
	    return booksreturnrepo.save(std);
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
