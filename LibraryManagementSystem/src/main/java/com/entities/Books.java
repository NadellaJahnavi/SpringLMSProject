package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="books")
public class Books {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookid;
	
	@Column(name="title",length=250,nullable=false)
	@NotNull(message="title cannot be null")
	private String title;
	
	@Column(name="isbncode",length=250,nullable=false)
	@Pattern(regexp ="^[0-9]+$")
	@NotNull(message="isbncode cannot be null")
	private String isbn_code;
	
	@Column(name="subject",length=250,nullable=false)
	@NotNull(message="subject cannot be null")
	private String subject;
	
	@Column(name="quantity",nullable=false)
	@NotNull(message = "quantity cannot be Null") 
	private int quantity;
	
	@Column(name="bookcost",length=250,nullable=false)
	@NotNull(message = "Cost should not be blank")
	@DecimalMin(value = "100.0", message = "Amount must be a number at least 100")
	private double book_cost;
	
	@Column(name="shelfdetails",length=250,nullable=false)
	@NotNull
	private String shelf_details;
	
	@Column(name="publishedyear",length=250,nullable=false)
	@NotNull
	private int published_year;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Admin admin;
	
	public Long getBookid() 
	{
		return bookid;
	}
	public void setBookid(Long bookid) 
	{
		this.bookid = bookid;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getIsbn_code() 
	{
		return isbn_code;
	}
	public void setIsbn_code(String isbn_code) 
	{
		this.isbn_code = isbn_code;
	}

	public String getSubject() 
	{
		return subject;
	}
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}

	public int getQuantity() 
	{
		return quantity;
	}
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

	public double getBook_cost() 
	{
		return book_cost;
	}
	public void setBook_cost(double book_cost) 
	{
		this.book_cost = book_cost;
	}

	public String getShelf_details() 
	{
		return shelf_details;
	}
	public void setShelf_details(String shelf_details)
	{
		this.shelf_details = shelf_details;
	}

	public int getPublished_year() 
	{
		return published_year;
	}
	public void setPublished_year(int published_year) 
	{
		this.published_year = published_year;
	}
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Admin getAdmin() 
	{
		return admin;
	}
	public void setAdmin(Admin admin) 
	{
		this.admin = admin;
	}
	 
	
}
