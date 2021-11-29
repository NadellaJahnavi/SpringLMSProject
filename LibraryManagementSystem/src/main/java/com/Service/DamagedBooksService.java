package com.Service;

import java.util.List;

import com.dto.DamagedBooksDto;
import com.entities.DamagedBooks;

public interface DamagedBooksService {
	public DamagedBooks addDamagedBooks(DamagedBooksDto dbookid);
	public DamagedBooks updateDamagedBookDetails(DamagedBooksDto dbookid) throws Throwable;
	public List<DamagedBooks> viewDamagedBooksList();
	public DamagedBooksDto viewDamagedBookById(int id) throws Throwable;
	public String deleteDamagedBooks(int id) throws Throwable;


}
