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

import com.entities.BooksReturned;
import com.repository.BooksReturnedRepository;
@SpringBootTest
class BooksReturnedServiceImplTest {
	@Autowired
	BooksReturnedService bookreturnservice;
	@MockBean
	BooksReturnedRepository booksreturnrepo;
	@Test
	void testReturnBooks() {
        BooksReturned br = new BooksReturned();
	    br.setId(1);
		br.setReturnedDate(null);
		br.setPenalty(0);
		br.setPenalty_Status("nill");
		br.setDelayed_Days(0);
		Mockito.when(booksreturnrepo.save(br)).thenReturn(br);
		assertThat(bookreturnservice.returnBooks(br)).isEqualTo(br);
	}

	@Test
	void testUpdateReturnedBookDetails() throws Throwable {
		BooksReturned br = new BooksReturned();
	    br.setId(1);
	    br.setReturnedDate(null);
	    br.setDelayed_Days(0);
	    br.setPenalty(0);
	    br.setPenalty_Status("nill");
	    Optional<BooksReturned> c2 =  Optional.of(br);
		Mockito.when(booksreturnrepo.findById(1)).thenReturn(c2);
		Mockito.when(booksreturnrepo.save(br)).thenReturn(br);
	    br.setReturnedDate(null);
	    br.setDelayed_Days(2);
	    br.setPenalty(10);
	    br.setPenalty_Status("paid");
		assertThat(bookreturnservice.updateReturnedBookDetails(br)).isEqualTo(br);
	}

	@Test
	void testViewReturnedBooksList() {
		BooksReturned br = new BooksReturned();
		br.setId(1);
	  	br.setReturnedDate(null);
		br.setPenalty(0);
		br.setPenalty_Status("nill");
		br.setDelayed_Days(0);
			
	    BooksReturned br1 = new BooksReturned();	
		br1.setId(1);
		br1.setReturnedDate(null);
		br1.setPenalty(0);
		br1.setPenalty_Status("nill");
		br1.setDelayed_Days(0);
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
		br.setPenalty_Status("paid");
		br.setDelayed_Days(2);
		
        BooksReturned br1 = new BooksReturned();
		br1.setId(1);
		br1.setReturnedDate(null);
		br1.setPenalty(15);
		br1.setPenalty_Status(null);
		br1.setDelayed_Days(3);
		List<BooksReturned> bookList = new ArrayList<BooksReturned>();
		bookList.add(br);
		bookList.add(br1);
		
		Mockito.when(booksreturnrepo.findAll()).thenReturn(bookList);
		assertThat(bookreturnservice.viewDelayedBooksList()).isEqualTo(bookList);
	}

}
