package com.poet.ordering.system.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poet.ordering.system.model.User;
import com.poet.ordering.system.service.imp.restaurant.RestaurantServiceImp;
import com.poet.ordering.system.service.imp.user.UserServiceImp;
import com.poet.ordering.system.service.restaurant.RestaurantService;
import com.poet.ordering.system.service.user.UserService;

@WebServlet("/search")
public class SearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantService restaurantService = RestaurantServiceImp.getInstance();
	private UserService userService = UserServiceImp.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = ((User) request.getSession().getAttribute("user"));

		String search = request.getParameter("search");
		String searchfilter = request.getParameter("searchfilter");
		if (searchfilter.equals("all")) {

			request.setAttribute("restaurants", restaurantService.viewRestaurantSearchResults(search));
			// one fn only needed
			request.setAttribute("subscriptions", userService.viewSubscriptionSearchResults(search, user));
			request.setAttribute("nonsubscriptions", userService.viewNonSubscriptionSearchResults(search, user));

			request.setAttribute("searchentry", search);
			request.setAttribute("searchfilter", "all");
			request.getRequestDispatcher("/jsp/searchResults.jsp").forward(request, response);
		}

		else if (searchfilter.equals("restaurantsonly")) {

			request.setAttribute("restaurants", restaurantService.viewRestaurantSearchResults(search));
			request.getRequestDispatcher("/jsp/searchResults.jsp").forward(request, response);
		}

		else if (searchfilter.equals("usersonly")) {

			request.setAttribute("subscriptions", userService.viewSubscriptionSearchResults(search, user));
			request.setAttribute("nonsubscriptions", userService.viewNonSubscriptionSearchResults(search, user));

			request.setAttribute("searchentry", search);
			request.setAttribute("searchfilter", "usersonly");
			request.getRequestDispatcher("/jsp/searchResults.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User userSelected = new User();
		User user = ((User) request.getSession().getAttribute("user"));
		userSelected.setId(Integer.parseInt(request.getParameter("selectedUserId")));

		String search = request.getParameter("searchentry");
		String searchfilter = request.getParameter("searchfilter");

		if (searchfilter.equals("all")) {
			request.setAttribute("restaurants", restaurantService.viewRestaurantSearchResults(search));
			request.setAttribute("searchfilter", "all");
		}
		if (request.getParameter("subscribedOrNot").equals("Subscribe"))
			userService.insertInSubscription(user, userSelected);
		else
			userService.deleteFromSubscription(user, userSelected);

		request.setAttribute("subscriptions", userService.viewSubscriptionSearchResults(search, user));
		request.setAttribute("nonsubscriptions", userService.viewNonSubscriptionSearchResults(search, user));
		request.setAttribute("searchentry", search);
		request.getRequestDispatcher("/jsp/searchResults.jsp").forward(request, response);

	}

}
