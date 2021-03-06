package com.poet.ordering.system.service.order;

import java.util.List;

import com.poet.ordering.system.model.OrderRequest;

public interface OrderRequestService {

	public List<OrderRequest> viewAllOrderRequests();
	
	public OrderRequest selectRestaurantId(OrderRequest orderRequest);
	
	public void cancelOrderRequest(OrderRequest userOrderInfo) throws Exception;


}
