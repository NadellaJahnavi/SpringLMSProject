package com.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.BookNotFoundException;
import com.advices.UserNotFoundException;
import com.entities.Admin;
import com.entities.Books;
import com.entities.BooksOrder;
import com.entities.DamagedBooks;
import com.entities.Users;
import com.repository.AdminRepository;
import com.repository.BooksOrderRepository;
import com.repository.BooksRepository;
import com.repository.DamagedBooksRepository;
import com.repository.UsersRepository;
@Service
public class AdminServiceImp implements AdminService{
	@Autowired
	private AdminRepository adminrepo;
	@Autowired
	private BooksOrderRepository booksorderrepo;
	@Autowired
	private DamagedBooksRepository damagedbookrepo;
	@Autowired
	private BooksRepository booksrepo;
	@Autowired
	private UsersRepository userrepo;
	
	@Override
	public Admin addAdminDetails(Admin ad)
	{
		adminrepo.save(ad);
		return ad;
	}

	@Override
	public Users ValidateUserDetails(Users user) throws Throwable
	{
		Optional<Users> u1=userrepo.findById(user.getUserid());//.orElseThrow();
		if(!u1.isEmpty())
		{
			if(u1.get().getPassword().equals(user.getPassword()))
			{
				return user;
			}
			else
			{
				throw new UserNotFoundException("Wrong Password");
			}
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public Books addBooks(Books b) {
		booksrepo.save(b);
		return b;
	}

	@Override
	public Books updateBooks(Books books) throws Throwable {
		Supplier s1= ()->new BookNotFoundException("Book Does not exist in the database");
		Books b2 = booksrepo.findById(books.getBookid()).orElseThrow(s1);
		b2.setTitle(books.getTitle());
		b2.setSubject(books.getSubject());
		//b2.setAuthor(books.getAuthor());
		return books;
	}

	@Override
	public Long removeBooks(Long bookid) {
		booksrepo.deleteById(bookid);
	       return bookid;
			//return "deleted";
	}

	@Override
	public BooksOrder addBookorder(BooksOrder booksOrder) {
		booksorderrepo.save(booksOrder);
		return booksOrder;
	}

	@Override
	public BooksOrder updateBookorder(BooksOrder booksOrder) throws Throwable {
		Supplier s1= ()->new BookNotFoundException("Book Does not exist in the database");
		BooksOrder b1 = booksorderrepo.findById(booksOrder.getOrderId()).orElseThrow(s1);
		b1.setOrderId(booksOrder.getOrderId());
		b1.setOrderDate(booksOrder.getOrderDate());
		b1.setQuantity(booksOrder.getQuantity());
		b1.setOrderStatus(booksOrder.getOrderStatus());
		booksorderrepo.save(booksOrder);
		return booksOrder;
	}

	@Override
	public String removeBookorder(int orderId) {
		booksorderrepo.deleteById(orderId);
	      return "deleted";
	}

	@Override
	public List<DamagedBooks> viewDamagedBooksList() {
		List<DamagedBooks> damagedBooks = damagedbookrepo.findAll();
		return damagedBooks;
	}

	@Override
	public DamagedBooks viewDamagedBookById(int id) throws Throwable {
		Supplier s1= ()->new BookNotFoundException("Book Does not exist in the database");
		DamagedBooks damagedBook = damagedbookrepo.findById(id).orElseThrow(s1);
		return damagedBook;
	}

	@Override
	public DamagedBooks addDamagedBooks(DamagedBooks d) {
		return damagedbookrepo.save(d); 
	}

	@Override
	public List<Books> getBookByTitle(String title) {
		List<Books> b4 =booksrepo.findBookByTitle(title);
		return b4;
	}

	@Override
	public List<Books> getBookBySubject(String subject) {
		List<Books> b3 = booksrepo.findBookBySubject(subject);
		return b3;
	}	
}
