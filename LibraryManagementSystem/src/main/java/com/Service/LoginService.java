package com.Service;

import java.util.List;

import com.entities.Login;

public interface LoginService {
	public Login addLoginDetails(Login login);
	public Login updateLoginDetails(Login login) throws Throwable;
	public String deleteLoginDetails(Login login);
	public List<Login> viewloginList();
	public Login viewusersbyid(int loginid) throws Throwable;
	//public Login getByusername(String username);
	public Login getuserByName(String userName);
}
