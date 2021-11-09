package com.Service;

import java.util.List;

import com.advices.ReaderNotFoundException;
import com.entities.Readers;

public interface ReadersService {
	public Readers register(Readers reader);
	public Readers updateReaderDetails(Readers reader);
	public String deleteReader(int id) ;
	public List<Readers> viewReadersList();
	public Readers viewReaderById(int id);
	public Boolean loginValidate(String Id,String password) throws ReaderNotFoundException;
	public Readers getPassword(String password);
	public Readers getMobileno(String mobileno);
}
