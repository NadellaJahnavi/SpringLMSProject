package com.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.entities.BooksIssued;
import com.repository.BooksIssuedRepository;
@SpringBootTest
class BooksIssuedServiceImplTest {
	@Autowired 
	BooksIssuedService bookissuedservice;
	@MockBean
	BooksIssuedRepository bookissuerepo;
	
//	@Test
//	void testAddIssuedBook() {
//		BooksIssued bi = new BooksIssued();
//		bi.setIssueId(1);
//		bi.setIssueDate(null);
//		bi.setDueDate(null);
//		Mockito.when(bookissuerepo.save(bi)).thenReturn(bi);
//		assertThat(bookissuedservice.addIssuedBook(bi)).isEqualTo(bi);
//	}
//
//	@Test
//	void testUpdateIssuedBookDetails() throws Throwable {
//		BooksIssued bi = new BooksIssued();
//		bi.setIssueId(1);
//		bi.setIssueDate(null);
//		bi.setDueDate(null);
//		
//		
//		
//		Optional<BooksIssued> b2 =  Optional.of(bi);
//		Mockito.when(bookissuerepo.findById(1)).thenReturn(b2);
//		Mockito.when(bookissuerepo.save(bi)).thenReturn(bi);
//		
//		
//		assertThat(bookissuedservice.updateIssuedBookDetails(bi)).isEqualTo(bi);
//	}

	@Test
	void testViewBooksIssuedList() {
		BooksIssued bi = new BooksIssued();
		bi.setIssueId(1);
		bi.setIssueDate(null);
		bi.setDueDate(null);
		
		
		BooksIssued bi1 = new BooksIssued();
		bi1.setIssueId(1);
		bi1.setIssueDate(null);
		bi1.setDueDate(null);
	
		
		
		List<BooksIssued> bookissueList = new ArrayList<BooksIssued>();
		bookissueList.add(bi);
		bookissueList.add(bi1);
		
		Mockito.when(bookissuerepo.findAll()).thenReturn(bookissueList);
		assertThat(bookissuedservice.viewBooksIssuedList()).isEqualTo(bookissueList);
	}

	
	
	  @Test
	  void testGetByIssueId() throws Throwable 
	  {
		   BooksIssued bi = new BooksIssued();
	       bi.setIssueId(1);
	       bi.setIssueDate(null); 
	       bi.setDueDate(null);
	       
	      Optional<BooksIssued> bi1 = Optional.of(bi);
	      Mockito.when(bookissuerepo.findByIssueId(1)).thenReturn(bi1);
	      assertThat(bookissuedservice.findByIssueId(1)).isEqualTo(bi); 
	   }
	 

	@Test
	void testDeleteIssuedBooks() {
		BooksIssued bi = new BooksIssued();
		bi.setIssueId(1);
		bi.setIssueDate(null);
		bi.setDueDate(null);
	
		Optional<BooksIssued> b2=Optional.of(bi);
		Mockito.when(bookissuerepo.findById(1)).thenReturn(b2);
		Mockito.when(bookissuerepo.existsById(bi.getIssueId())).thenReturn(false);
		assertFalse(bookissuerepo.existsById(bi.getIssueId()));
	}

}
