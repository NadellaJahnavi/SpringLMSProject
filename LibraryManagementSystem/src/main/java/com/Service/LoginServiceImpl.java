package com.Service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.IDNotFoundException;
import com.entities.Login;
import com.repository.LoginRepository;
import com.repository.UsersRepository;
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginRepository loginrepo;
	//@Autowired
	//UsersRepository usersrepo;
	
	@Override
	public Login addLoginDetails(Login login) {
		return loginrepo.save(login);
	}

	@Override
	public Login updateLoginDetails(Login login) throws Throwable {
		int loginid=login.getLoginId();
		Supplier s1=()->new IDNotFoundException("userId doesnot exist in the database");
		Login L=loginrepo.findById(loginid).orElseThrow(s1);
		L.setLoginId(L.getLoginId());
		//L.setUserName(L.getUserName());
		L.setPassword(L.getPassword());
		loginrepo.save(login);
		return login;
	}

	@Override
	public String deleteLoginDetails(Login login) {
		loginrepo.delete(login);
		return "deleted";
	}

	@Override
	public List<Login> viewloginList() {
		List<Login> LC=loginrepo.findAll();
		return LC;
	}

	@Override
	public Login viewusersbyid(int loginid) throws Throwable {
		Supplier s1=()->new IDNotFoundException("userId doesnot exist in the database");
		Login Lm= loginrepo.findById(loginid).orElseThrow(s1);
		return Lm;
	}

	@Override
	public Login getuserByName(String userName) {
		Login UN=loginrepo.findByUserName(userName);
		return UN;
	}

}
