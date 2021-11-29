package com.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	
	@NotEmpty(message = "Password cannot be empty")
	@Size(min = 5, max = 16, message = "Enter Valid Password ")
	private String adminPassword;
	
	@Column(name = "adminName", length = 40, nullable = false)
	private String adminName;
		
	public int getAdminId() 
	{
		return adminId;
	}

	public void setAdminId(int adminId)
	{
		this.adminId = adminId;
	}

	public String getAdminName() 
	{
		return adminName;
	}

	public void setAdminName(String adminName) 
	{
		this.adminName = adminName;
	}

	public String getAdminPassword() 
	{
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword)
	{
		this.adminPassword = adminPassword;
	}

}
