package com.Service;

import java.util.List;

import com.dto.BooksorderDto;
import com.entities.BooksOrder;

public interface BooksOrderService {
	public BooksOrder placeBooksOrder(BooksorderDto orderdetails);
	public String cancelOrder(int orderId) throws Throwable;
	public BooksOrder updateOrder(BooksorderDto order) throws Throwable;
	public List<BooksOrder> viewOrdersList();
	public BooksorderDto viewOrderById(int orderId) throws Throwable;
}
