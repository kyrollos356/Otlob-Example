package com.poet.ordering.system.servlets.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poet.ordering.system.model.User;
import com.poet.ordering.system.service.imp.user.UserServiceImp;

/**
 * Servlet implementation class AllUsersServlet
 */
@WebServlet("/user/all")
public class AllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImp userServiceImp = UserServiceImp.getInstance();

	public HttpServletRequest displayAllUsers(User user, HttpServletRequest request) {

		List<User> allSubscribers = new ArrayList<User>();
		allSubscribers = userServiceImp.selectSubscriptions(user);

		List<User> allUnsubscribers = new ArrayList<User>();
		allUnsubscribers = userServiceImp.selectUnsubscribers(user);

		request.setAttribute("Subscribers", allSubscribers);
		request.setAttribute("Unsubscribers", allUnsubscribers);

		return request;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = ((User) request.getSession().getAttribute("user"));
		request = displayAllUsers(user, request);
		request.setAttribute("isAdmin", userServiceImp.isAdmin(user));
		request.getRequestDispatcher("/jsp/user/allUsers.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User otherUser = new User();

		User userProfile = ((User) request.getSession().getAttribute("user"));
		otherUser.setId(Integer.parseInt(request.getParameter("idOfUserFromJSP")));
		String deleteOrNot = (String) request.getParameter("DeleteFromAdminJSP");

		if (deleteOrNot != null)
			userServiceImp.adminDeleteUserById(otherUser);

		String SubscriberOrUnsubscriber = (String) request.getParameter("SubscriberOrUnsubscriber");

		if (SubscriberOrUnsubscriber != null)
			if (SubscriberOrUnsubscriber.equals("Subscribe"))
				userServiceImp.insertInSubscription(userProfile, otherUser);
			else
				userServiceImp.deleteFromSubscription(userProfile, otherUser);

		request = displayAllUsers(userProfile, request);
		request.setAttribute("isAdmin", userServiceImp.isAdmin(userProfile));
		request.getRequestDispatcher("/jsp/user/allUsers.jsp").forward(request, response);
	}

}
