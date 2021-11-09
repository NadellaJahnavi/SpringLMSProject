package com.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="booksreturned")
public class BooksReturned {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	@NotNull(message = " return date Should Not Be Null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returnedDate;
	
	@NotNull	
	private int delayed_Days;
	
	@NotNull
	private double penalty;
	
	@Pattern(regexp = "^[A-Za-z ]{1,20}$", message = "Status must only be alphabets and whitespaces from 1 to 20 characters")
	private String penalty_Status;

	@ManyToOne(cascade=CascadeType.MERGE) 
	private Books books;

	@OneToOne(cascade=CascadeType.MERGE) 
	private Users users;
		  
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public Date getReturnedDate() 
	{
		return returnedDate;
	}
	public void setReturnedDate(Date returnedDate) 
	{
		this.returnedDate = returnedDate;
	}
	
	public int getDelayed_Days() 
	{
		return delayed_Days;
	}
	public void setDelayed_Days(int delayed_Days)
	{
		this.delayed_Days = delayed_Days;
	}
	
	public double getPenalty()
	{
		return penalty;
	}
	public void setPenalty(double penalty)
	{
		this.penalty = penalty;
	}
	public String getPenalty_Status() {
		return penalty_Status;
	}
	public void setPenalty_Status(String penalty_Status) 
	{
		this.penalty_Status = penalty_Status;
	}
	
	public Books getBooks()
	{
		return books;
	}
	public void setBooks(Books books) 
	{
		this.books = books;
	}
	
	public Users getUsers() 
	{
		return users;
	}
	public void setUsers(Users users)
	{
		this.users = users;
	}
}