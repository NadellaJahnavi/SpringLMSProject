package com.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	 
	@Column(name = "firstname",unique=true, nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9.-_]{1,20}$", message = "Name must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")	
	private String firstName;
	
	@Column(name = "lastname", unique=true,nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9.-_]{1,20}$", message = "Name must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")
	private String lastName;
	
	@Column(name = "mobileno", unique = true, nullable = false, length = 10)
	@Pattern(regexp = "^[6|7|8|9]{1}[0-9]{9}$")
	@Size(max = 10, message = "Contact number must be 10 numbers")
	private String mobileno;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateofbirth;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="login")
	private Login login;
	
	public int getUserid()
	{
		return userid;
	}
	public void setUserid(int userid) 
	{
		this.userid = userid;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getMobileno() 
	{
		return mobileno;
	}
	public void setMobileno(String mobileno) 
	{
		this.mobileno = mobileno;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

}