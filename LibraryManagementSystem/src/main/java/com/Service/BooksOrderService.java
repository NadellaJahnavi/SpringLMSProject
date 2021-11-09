package com.Service;

import java.util.List;

import com.entities.BooksOrder;

public interface BooksOrderService {
	public BooksOrder placeBooksOrder(BooksOrder orderdetails);
	public String cancelOrder(BooksOrder orderId);
	public BooksOrder updateOrder(BooksOrder order) throws Throwable;
	public List<BooksOrder> viewOrdersList();
	public BooksOrder viewOrderById(int orderId) throws Throwable;

}
