package com.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private int delayedDays;
	
	@NotNull
	private double penalty;
	
	@Pattern(regexp = "^[A-Za-z ]{1,20}$", message = "Status must only be alphabets and whitespaces from 1 to 20 characters")
	private String penaltyStatus;

	@ManyToOne(cascade=CascadeType.ALL) 
	private Books books;

	@OneToOne(cascade=CascadeType.ALL) 
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
	
	public int getDelayedDays() {
		return delayedDays;
	}
	public void setDelayedDays(int delayedDays) {
		this.delayedDays = delayedDays;
	}
	public double getPenalty()
	{
		return penalty;
	}
	public void setPenalty(double penalty)
	{
		this.penalty = penalty;
	}
	public String getPenaltyStatus() {
		return penaltyStatus;
	}
	public void setPenaltyStatus(String penaltyStatus) {
		this.penaltyStatus = penaltyStatus;
	}
	
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
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
	@Override
	public String toString() {
		return "BooksReturned [id=" + id + ", returnedDate=" + returnedDate + ", delayedDays=" + delayedDays
				+ ", penalty=" + penalty + ", penaltyStatus=" + penaltyStatus + ", books=" + books + ", users=" + users
				+ "]";
	}
	
}