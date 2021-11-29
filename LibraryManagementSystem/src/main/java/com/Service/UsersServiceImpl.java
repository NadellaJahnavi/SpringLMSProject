package com.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.IDNotFoundException;
import com.advices.UserFoundException;
import com.advices.UserNotFoundException;
import com.dto.LoginDto;
import com.dto.UsersDto;
import com.entities.Login;
import com.entities.Users;
import com.repository.LoginRepository;
import com.repository.UsersRepository;
@Service
public class UsersServiceImpl implements UsersService {
	@Autowired 
	UsersRepository userrepo;
	@Autowired
	LoginRepository lrepo;
	
	@Override
	public Users registerUserDetails(UsersDto user) throws Throwable {
		
		Optional<Users> u=userrepo.findById(user.getUserid());
		if(u.isPresent()) {
			throw new UserFoundException("user already exists with given id"+user.getUserid());
		}
		Users u1=new Users();
		u1.setFirstName(user.getFirstName());
		u1.setLastName(user.getLastName());
		u1.setMobileno(user.getMobileno());
		u1.setDateofbirth(user.getDateofbirth());
		Login login =new Login();
		login.setEmail(user.getEmail());
		login.setRole(user.getRole());
		login.setPassword(user.getPassword());
		login.setLoggedIn(false);
		u1.setLogin(login);
		return userrepo.save(u1);
	}

	@Override
	public Users updateUserDetails(UsersDto user) throws Throwable {

		Optional<Users> b = userrepo.findById(user.getUserid());
		if (!b.isPresent()) {
			throw new UserNotFoundException("User not found with given id ");
		}

		Users u2 = b.get();
		u2.setUserid(user.getUserid());
		u2.setFirstName(user.getFirstName());
		u2.setLastName(user.getLastName());
		u2.setMobileno(user.getMobileno());
		u2.setDateofbirth(user.getDateofbirth());
		u2.getLogin().setRole(user.getRole());
		u2.getLogin().setEmail(user.getEmail());
		u2.getLogin().setPassword(user.getPassword());
		return userrepo.save(u2);

	}
	
	@Override
	public List<Users> viewAllUsers() {
		List<Users> l1 = userrepo.findAll();		
		return l1;
	}
     
	@Override
	public Users viewUserById(int userid) throws Throwable {
		Supplier s1 =()-> new UserNotFoundException("user doesn't exists");
		Users u =userrepo.findById(userid).orElseThrow(s1);
		return u;
	
	}

	@Override
	public boolean deleteUserDetails(int userid)throws Throwable {
		Supplier s = () -> new  UserNotFoundException("user not found");
		Users user = userrepo.findById(userid).orElseThrow(s);
		if (user != null) {
			userrepo.deleteById(userid);
			return true;
		}
		return false;
	}

	@Override
	public Users getMobileno(String mobileno) {
		Users mb =userrepo.findByMobileno(mobileno);
		return mb;
	}

}
