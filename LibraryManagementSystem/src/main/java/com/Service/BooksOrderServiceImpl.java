package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.BooksOrder;
import com.repository.BooksOrderRepository;
@Service
public class BooksOrderServiceImpl implements BooksOrderService {
	@Autowired
	 BooksOrderRepository booksorderrepo;
	@Override
	public BooksOrder placeBooksOrder(BooksOrder orderdetails) {
		return booksorderrepo.save(orderdetails);
	}

	@Override
	public String cancelOrder(BooksOrder orderId) {
		booksorderrepo.delete(orderId);
		return "Order Cancelled";
	}

	@Override
	public BooksOrder updateOrder(BooksOrder order) throws Throwable {
		int orderid = order.getOrderId();
		//Supplier s2 = ()-> new OrderNotFoundException("Order not Found");
		BooksOrder bo=booksorderrepo.findById(orderid).orElseThrow();
	    //bo.setBooks(order.getBooks());
		bo.setQuantity(order.getQuantity());
		bo.setOrderDate(order.getOrderDate());
		bo.setOrderStatus(order.getOrderStatus());
		booksorderrepo.save(bo);		
		return bo;
	}

	@Override
	public List<BooksOrder> viewOrdersList() {
		List<BooksOrder> lbo = booksorderrepo.findAll();
		return lbo;	
		}

	@Override
	public BooksOrder viewOrderById(int orderId) throws Throwable {
		//Supplier s2 = ()-> new OrderNotFoundException("Order not Found");
				BooksOrder bo1 =booksorderrepo.findById(orderId).orElseThrow();
				return bo1;
	}

}
