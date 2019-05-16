package com.poet.ordering.system.service.order;

import java.util.List;

import com.poet.ordering.system.model.Order;
import com.poet.ordering.system.model.OrderRequest;
public interface OrderService {

	public void insertUserOrder(OrderRequest userOrderInfo) throws Exception;

	public void sendEamilToSubscribers(int userId) throws Exception;

	public void submitOrder(Order order);
	
	public void insertTimeout(java.util.Date timoutdate , int userId) throws Exception ;
	
	public List<Order> viewAllOrders(int orderRequestId) throws Exception;
	
	public void editOrder(Order order);
	
	public boolean isUserExistsInOrders(Order order);
}
