package com.Service;

import java.util.List;

import com.dto.UsersDto;
import com.entities.Users;

public interface UsersService {
	public Users registerUserDetails(UsersDto user) throws Throwable;
	public Users updateUserDetails(UsersDto user) throws Throwable;
	public List<Users> viewAllUsers();
	public Users viewUserById(int userid)throws Throwable;
	public boolean deleteUserDetails(int userid) throws Throwable;
	public Users getMobileno(String mobileno);
}
