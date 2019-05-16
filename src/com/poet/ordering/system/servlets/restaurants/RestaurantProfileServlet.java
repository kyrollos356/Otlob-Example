package com.poet.ordering.system.servlets.restaurants;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poet.ordering.system.model.Address;
import com.poet.ordering.system.model.Phone;
import com.poet.ordering.system.model.Restaurant;
import com.poet.ordering.system.model.RestaurantReview;
import com.poet.ordering.system.model.Tag;
import com.poet.ordering.system.model.User;
import com.poet.ordering.system.service.imp.restaurant.AddressServiceImp;
import com.poet.ordering.system.service.imp.restaurant.PhoneServiceImp;
import com.poet.ordering.system.service.imp.restaurant.RestaurantReviewServiceImp;
import com.poet.ordering.system.service.imp.restaurant.RestaurantServiceImp;
import com.poet.ordering.system.service.imp.restaurant.TagServiceImp;

@WebServlet("/restaurantProfile")
public class RestaurantProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final int totalRating = 5;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = ((User) request.getSession().getAttribute("user"));

		Restaurant restaurant = new Restaurant();
		RestaurantServiceImp restaurantServiceImp = RestaurantServiceImp.getInstance();

		Address address = new Address();
		AddressServiceImp addressServiceImp = AddressServiceImp.getInstance();

		Tag tag = new Tag();
		TagServiceImp tagServiceImp = TagServiceImp.getInstance();

		Phone phone = new Phone();
		PhoneServiceImp phoneServiceImp = PhoneServiceImp.getInstance();

		Integer idRestaurant = Integer.parseInt(request.getParameter("id"));

		RestaurantReviewServiceImp restaurantReviewServiceImp = RestaurantReviewServiceImp.getInstance();
		ArrayList<RestaurantReview> restaurantReviews = new ArrayList<RestaurantReview>();

		try {
			restaurantReviews = restaurantReviewServiceImp.viewAllRestaurantReviews(idRestaurant);
			restaurant = restaurantServiceImp.viewRestaurant(idRestaurant);
			phone = phoneServiceImp.viewPhone(idRestaurant);
			tag = tagServiceImp.viewTag(idRestaurant);
			address = addressServiceImp.viewAddress(idRestaurant);

			request.setAttribute("rating", restaurantReviewServiceImp.averageRating(idRestaurant));
			request.setAttribute("starEmpty", totalRating - restaurantReviewServiceImp.averageRating(idRestaurant));
			request.setAttribute("restaurantReviews", restaurantReviews);
			request.setAttribute("restaurantID", idRestaurant);
			request.setAttribute("restaurant", restaurant);
			request.setAttribute("phoneNumbers", phone.getPhoneNumber());
			request.setAttribute("tags", tag.getTag());
			request.setAttribute("addresses", address.getAddress());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		request.getRequestDispatcher("/jsp/restaurant/restaurantProfile.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = ((User) request.getSession().getAttribute("user"));
		RestaurantReview restaurantReview = new RestaurantReview();
		restaurantReview.setUserID(user.getId());
		restaurantReview.setContent(request.getParameter("comment"));

		if (!request.getParameter("rating").equals("")) {
			restaurantReview.setRating(Integer.parseInt(request.getParameter("rating")));
		} else {
			restaurantReview.setRating(0);
		}

		restaurantReview.setRestaurantID(Integer.parseInt(request.getParameter("restaurantID")));

		RestaurantReviewServiceImp restaurantReviewServiceImp = RestaurantReviewServiceImp.getInstance();
		try {
			restaurantReviewServiceImp.addNewRestaurantReview(restaurantReview);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("/restaurantProfile?id=" + restaurantReview.getRestaurantID());

	}

}
