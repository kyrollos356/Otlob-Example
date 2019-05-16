package com.poet.ordering.system.servlets.orderRequests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poet.ordering.system.service.imp.order.OrderRequestServiceImp;
import com.poet.ordering.system.service.order.OrderRequestService;

@WebServlet("/order/requests")
public class AllOrderRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderRequestService orderRequestService = OrderRequestServiceImp.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("orderRequests", orderRequestService.viewAllOrderRequests());
		request.getRequestDispatcher("/jsp/order/allOrderRequests.jsp").forward(request, response);
	}
}
