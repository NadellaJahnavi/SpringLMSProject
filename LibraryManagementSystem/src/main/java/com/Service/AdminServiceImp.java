package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Admin;
import com.repository.AdminRepository;

@Service
public class AdminServiceImp implements AdminService{
	@Autowired
	private AdminRepository adminrepo;
	
	@Override
	public Admin addAdminDetails(Admin ad)
	{
		adminrepo.save(ad);
		return ad;
	}	
}
