package com.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.BookNotFoundException;
import com.dto.DamagedBooksDto;
import com.entities.Books;
import com.entities.DamagedBooks;
import com.repository.BooksRepository;
import com.repository.DamagedBooksRepository;
@Service
public class DamagedBooksServiceImpl implements DamagedBooksService {
	 @Autowired
	  DamagedBooksRepository damagedbooksrepo;
	 @Autowired
	  BooksRepository booksrepo;
	@Override
	public DamagedBooks addDamagedBooks(DamagedBooksDto dbookid) {
		DamagedBooks d1 = new DamagedBooks();
		  d1.setId(dbookid.getId());
		  d1.setDescription(dbookid.getDescription());
		  d1.setQuantity(dbookid.getQuantity());
		  
		  Optional<Books> books = booksrepo.findById(dbookid.getBookid());
		  Books b2 = books.get();
		  d1.setBooks(b2);
		  damagedbooksrepo.save(d1);
		  return d1;
	}

	@Override
	public DamagedBooks updateDamagedBookDetails(DamagedBooksDto dbookid) throws Throwable {
		Optional<DamagedBooks> b = damagedbooksrepo.findById(dbookid.getId());
        if(!b.isPresent()) {
            throw new BookNotFoundException("Book not found with given id ");
        }
        
        DamagedBooks std = b.get();
        std.setId(dbookid.getId());
        std.setDescription(dbookid.getDescription());
        std.setQuantity(dbookid.getQuantity());
        damagedbooksrepo.save(std);
        return std;
	}

	@Override
	public List<DamagedBooks> viewDamagedBooksList() {
		List<DamagedBooks> b= damagedbooksrepo.findAll();
		return b;
	}

	@Override
	public DamagedBooksDto viewDamagedBookById(int id) throws Throwable {
		Optional<DamagedBooks> bo = damagedbooksrepo.findById(id);
        if(!bo.isPresent()) {
            throw new BookNotFoundException("Book not damaged with given Id "+id);
        }

        DamagedBooks std = bo.get();
        DamagedBooksDto dto = new DamagedBooksDto();
        dto.setId(std.getId());
        dto.setDescription(std.getDescription());
        dto.setQuantity(std.getQuantity());
	return dto;
	}

	@Override
	public String deleteDamagedBooks(int id) throws Throwable {
		Supplier s1= ()->new BookNotFoundException("Book not damaged");		
		 DamagedBooks author = damagedbooksrepo.findById(id).orElseThrow(s1);
		 damagedbooksrepo.delete(author);
		return "deleted";
	}
	 
}
