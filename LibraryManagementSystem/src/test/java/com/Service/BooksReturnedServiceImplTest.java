package com.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dto.BooksReturnedDto;
import com.entities.Books;
import com.entities.BooksReturned;
import com.entities.Users;
import com.repository.BooksRepository;
import com.repository.BooksReturnedRepository;
import com.repository.UsersRepository;
@SpringBootTest
class BooksReturnedServiceImplTest {
	@Autowired
	BooksReturnedService bookreturnservice;
	@MockBean
	BooksReturnedRepository booksreturnrepo;
	@MockBean
	UsersRepository usersrepo;
	@MockBean
	BooksRepository booksrepo;
	@Test
	void testReturnBooks() {
        BooksReturned br = new BooksReturned();
	    br.setId(1);
		br.setReturnedDate(null);
		br.setPenalty(0);
		br.setPenaltyStatus("nill");
		br.setDelayedDays(0);
        BooksReturnedDto b1=new BooksReturnedDto(); 
        b1.setId(1);
		Users user=new Users();
		Mockito.when(usersrepo.findById(user.getUserid())).thenReturn(Optional.of(user));
		Books books=new Books();
		Mockito.when(booksrepo.findById(books.getBookid())).thenReturn(Optional.of(books));
		Mockito.when(booksreturnrepo.save(br)).thenReturn(br);
		BooksReturned b=bookreturnservice.returnBooks(b1);
		System.out.println(b);
		assertEquals(b.getId(),1);
	}

//	@Test
//	void testUpdateReturnedBookDetails() throws Throwable {
//		BooksReturnedDto br = new BooksReturnedDto();
//	    br.setId(1);
//	    br.setReturnedDate(null);
//	    br.setDelayedDays(0);
//	    br.setPenalty(0);
//	    br.setPenaltyStatus("nill");
//	    Optional<BooksReturnedDto> c2 =  Optional.of(br);
//		Mockito.when(booksreturnrepo.findById(1)).thenReturn(c2);
//		Mockito.when(booksreturnrepo.save(br)).thenReturn(br);
//	    br.setReturnedDate(null);
//	    br.setDelayedDays(2);
//	    br.setPenalty(10);
//	    br.setPenaltyStatus("paid");
//		assertThat(bookreturnservice.updateReturnedBookDetails(br)).isEqualTo(br);
//	}

	@Test
	void testViewReturnedBooksList() {
		BooksReturned br = new BooksReturned();
		br.setId(1);
	  	br.setReturnedDate(null);
		br.setPenalty(0);
		br.setPenaltyStatus("nill");
		br.setDelayedDays(0);
			
	    BooksReturned br1 = new BooksReturned();	
		br1.setId(1);
		br1.setReturnedDate(null);
		br1.setPenalty(0);
		br1.setPenaltyStatus("nill");
		br1.setDelayedDays(0);
		List<BooksReturned> bookList = new ArrayList<BooksReturned>();
		bookList.add(br);
		bookList.add(br1);
			
		Mockito.when(booksreturnrepo.findAll()).thenReturn(bookList);
		assertThat(bookreturnservice.viewReturnedBooksList()).isEqualTo(bookList);
	}

	@Test
	void testViewDelayedBooksList() {
		BooksReturned br = new BooksReturned();
		br.setId(1);
		br.setReturnedDate(null);
		br.setPenalty(10);
		br.setPenaltyStatus("paid");
		br.setDelayedDays(2);
		
        BooksReturned br1 = new BooksReturned();
		br1.setId(1);
		br1.setReturnedDate(null);
		br1.setPenalty(15);
		br1.setPenaltyStatus(null);
		br1.setDelayedDays(3);
		List<BooksReturned> bookList = new ArrayList<BooksReturned>();
		bookList.add(br);
		bookList.add(br1);
		
		Mockito.when(booksreturnrepo.findAll()).thenReturn(bookList);
		assertThat(bookreturnservice.viewDelayedBooksList()).isEqualTo(bookList);
	}

}
