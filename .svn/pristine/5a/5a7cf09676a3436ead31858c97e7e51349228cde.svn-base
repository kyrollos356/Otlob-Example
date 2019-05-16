package com.poet.ordering.system.dao.order;

import java.sql.Connection;
import java.util.List;

import com.poet.ordering.system.model.OrderRequest;

public interface OrderRequestDAO {

	public List<OrderRequest> selectAllOpenOrderRequestsSortedByExpiryDate();

	public OrderRequest selectRequestOwner(OrderRequest eachOrderRequestInList, Connection conn);

	public OrderRequest selectRestaurantName(OrderRequest eachOrderRequestInList, Connection conn);
	
	public long createOrderRequest(OrderRequest orderRequest) throws Exception;
	
	public void deleteOrderRequest(int id) throws Exception;
	
	public OrderRequest getOrderRequest(int id) throws Exception;
	
	public void changeStatus(OrderRequest orderRequest) throws Exception;

	public OrderRequest selectRestaurantIdFromOrderRequest(OrderRequest orderRequest);
	
	public void deleteUserOrderByOrderRequestId(OrderRequest userOrderInfo) throws Exception;
}
