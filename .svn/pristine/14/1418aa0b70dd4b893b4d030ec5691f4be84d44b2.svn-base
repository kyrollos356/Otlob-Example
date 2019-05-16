package com.poet.ordering.system.servlets.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poet.ordering.system.model.OrderRequest;
import com.poet.ordering.system.model.User;
import com.poet.ordering.system.service.imp.order.OrderRequestServiceImp;
import com.poet.ordering.system.service.imp.user.UserServiceImp;

@WebServlet("/profile")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImp userService = UserServiceImp.getInstance();
	private OrderRequestServiceImp orderRequestService = OrderRequestServiceImp.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		User user = ((User) request.getSession().getAttribute("user"));

		if (id != null) {
			User selectedUser = new User();

			selectedUser = userService.findbyID(id);

			request.setAttribute("subscribed", userService.checkIfSubscribed(user, selectedUser));

			fillProfile(request, response, selectedUser);
		} else {
			fillProfile(request, response, user);
		}
		request.getRequestDispatcher("/jsp/user/profile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		User user = ((User) request.getSession().getAttribute("user"));
		User selectedUser = new User();

		selectedUser = userService.findbyID(id);

		if ("Subscribe".equals(request.getParameter("subscribed"))) {
			userService.insertInSubscription(user, selectedUser);
		} else {
			userService.deleteFromSubscription(user, selectedUser);
		}
		request.setAttribute("subscribed", userService.checkIfSubscribed(user, selectedUser));
		fillProfile(request, response, selectedUser);
		request.getRequestDispatcher("/jsp/user/profile.jsp").forward(request, response);

	}

	private void fillProfile(HttpServletRequest request, HttpServletResponse response, User user)
			throws ServletException, IOException {
		OrderRequest orderRequest = orderRequestService.selectOrderRequestByUser(user);

		orderRequestService.selectRestaurantName(orderRequest);
		request.setAttribute("userSelected", user);
		request.setAttribute("Subscriptions", userService.selectSubscriptions(user));
		request.setAttribute("Subscribers", userService.selectSubscribers(user));
		request.setAttribute("orderRequests", orderRequestService.viewAllOrderRequests());
		request.setAttribute("orderRequest", orderRequest);
	}

}
