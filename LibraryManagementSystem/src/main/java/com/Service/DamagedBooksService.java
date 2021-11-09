package com.Service;

import java.util.List;

import com.entities.DamagedBooks;

public interface DamagedBooksService {
	public DamagedBooks addDamagedBooks(DamagedBooks dbook);
	public DamagedBooks updateDamagedBookDetails(DamagedBooks dbook) throws Throwable;
	public List<DamagedBooks> viewDamagedBooksList();
	public DamagedBooks viewDamagedBookById(int id) throws Throwable;

}
