package com.poet.ordering.system.service.imp.order;

import java.util.List;

import com.poet.ordering.system.dao.imp.order.OrderRequestDAOImp;
import com.poet.ordering.system.model.OrderRequest;
import com.poet.ordering.system.model.User;
import com.poet.ordering.system.service.order.OrderRequestService;

public class OrderRequestServiceImp implements OrderRequestService {

	OrderRequestDAOImp orderRequestDAO = new OrderRequestDAOImp();
	private static OrderRequestServiceImp instance;

	public static OrderRequestServiceImp getInstance() {
		if (instance == null) {
			instance = new OrderRequestServiceImp();
		}
		return instance;
	}

	public List<OrderRequest> viewAllOrderRequests() {
		return orderRequestDAO.selectAllOpenOrderRequestsSortedByExpiryDate();
	}

	public long addNewOrderRequest(OrderRequest orderRequest) throws Exception {
		long id = orderRequestDAO.createOrderRequest(orderRequest);
		return id;
	}

	public OrderRequest selectRestaurantId(OrderRequest orderRequest) {
		return orderRequestDAO.selectRestaurantIdFromOrderRequest(orderRequest);
	}

	public OrderRequest getOrderRequest(int id) throws Exception {
		OrderRequest orderRequest = orderRequestDAO.getOrderRequest(id);
		return orderRequest;
	}
	
	public void changeStatus(OrderRequest orderRequest) throws Exception {
		orderRequestDAO.changeStatus(orderRequest);
	}

	public void cancelOrderRequest(OrderRequest userOrderInfo) throws Exception {
		orderRequestDAO.deleteUserOrderRequest(userOrderInfo);
	}

	public OrderRequest selectOrderRequestByUser(User user) {

		return orderRequestDAO.selectOrderRequestByUser(user);

	}

	public OrderRequest selectRestaurantName(OrderRequest eachOrderRequestInList) {
		return orderRequestDAO.selectRestaurantName(eachOrderRequestInList);
	}
	
	public void deleteOrderRequest(int id) throws Exception {
		orderRequestDAO.deleteOrderRequest(id);
	}
}
