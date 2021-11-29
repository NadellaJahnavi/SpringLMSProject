package com.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.BookNotFoundException;
import com.advices.OrderNotFoundException;
import com.dto.BooksorderDto;
import com.entities.Books;
import com.entities.BooksOrder;
import com.repository.BooksOrderRepository;
import com.repository.BooksRepository;
@Service
public class BooksOrderServiceImpl implements BooksOrderService {
	@Autowired
	 BooksOrderRepository booksorderrepo;
	 @Autowired
	 BooksRepository booksrepo;
	@Override
	public BooksOrder placeBooksOrder(BooksorderDto orderdetails) {
		 BooksOrder b1 = new BooksOrder();
		  b1.setOrderId(orderdetails.getOrderId());
		  b1.setOrderStatus(orderdetails.getOrderStatus());
		  b1.setOrderDate(orderdetails.getOrderDate());
		  b1.setQuantity(orderdetails.getQuantity());
		  Optional<Books> books = booksrepo.findById(orderdetails.getBookid());
		  Books b2 = books.get();
		  b1.setBooks(b2);
		  booksorderrepo.save(b1);
		  return b1;
	}
	@Override
	public String cancelOrder(int orderId) throws Throwable {
		Supplier s1= ()->new OrderNotFoundException("Order Does not exist in the database");		
		 BooksOrder order = booksorderrepo.findById(orderId).orElseThrow(s1);
		 booksorderrepo.delete(order);
		return "deleted";
	}
	@Override
	public BooksOrder updateOrder(BooksorderDto order) throws Throwable {
		Optional<BooksOrder> b =  booksorderrepo.findById(order.getOrderId());
        if(!b.isPresent()) {
            throw new BookNotFoundException("Book not found with given id ");
        }
        
        BooksOrder std = b.get();
        std.setOrderId(order.getOrderId());
        std.setOrderDate(order.getOrderDate());
        std.setOrderStatus(order.getOrderStatus());
        std.setQuantity(order.getQuantity());
        booksorderrepo.save(std);
        return std;
	}
	@Override
	public List<BooksOrder> viewOrdersList() {
		List<BooksOrder> lbo = booksorderrepo.findAll();
		return lbo;
	}
	@Override
	public BooksorderDto viewOrderById(int orderId) throws Throwable {
		Optional<BooksOrder> bo = booksorderrepo.findById(orderId);
        if(!bo.isPresent()) {
            throw new OrderNotFoundException("Order not found with given orderId "+orderId);
        }

        BooksOrder std = bo.get();
        BooksorderDto dto = new  BooksorderDto();
        dto.setOrderId(std.getOrderId());
        dto.setOrderDate(std.getOrderDate());
        dto.setOrderStatus(std.getOrderStatus());
        dto.setQuantity(std.getQuantity());
        return dto;
	}
	
}
