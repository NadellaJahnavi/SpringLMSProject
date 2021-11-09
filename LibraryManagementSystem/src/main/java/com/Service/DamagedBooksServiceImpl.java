package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.DamagedBooks;
import com.repository.DamagedBooksRepository;
@Service
public class DamagedBooksServiceImpl implements DamagedBooksService {
	 @Autowired
	  DamagedBooksRepository damagedbooksrepo;
	 
	@Override
	public DamagedBooks addDamagedBooks(DamagedBooks dbook) {
		damagedbooksrepo.save(dbook);
		return dbook;
	}

	@Override
	public DamagedBooks updateDamagedBookDetails(DamagedBooks dbook) throws Throwable {
		 int did = dbook.getId();
		 //Supplier s1 = ()-> new  DamageNotFoundException("Book is not Damaged");
		 DamagedBooks db = damagedbooksrepo.findById(did).orElseThrow();
		 //db.setBooks(dbook.getBooks());
		 db.setDescription(dbook.getDescription());
		 db.setQuantity(dbook.getQuantity());
		 damagedbooksrepo.save(db);
   		 return db;
	}

	@Override
	public List<DamagedBooks> viewDamagedBooksList() {
		//Supplier s1 = ()-> new DamageNotFoundException("Book is not Damaged");
		List<DamagedBooks> b= damagedbooksrepo.findAll();//.orElseThrow();
		return b;
	}

	@Override
	public DamagedBooks viewDamagedBookById(int id) throws Throwable {
		//Supplier s1 = ()-> new DamageNotFoundException("Book is not Damaged");
		DamagedBooks b= damagedbooksrepo.findById(id).orElseThrow();
		return b;
	}

}
