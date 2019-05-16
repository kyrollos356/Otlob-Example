package com.poet.ordering.system.servlets.restaurants;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poet.ordering.system.model.Restaurant;
import com.poet.ordering.system.service.imp.restaurant.AddressServiceImp;
import com.poet.ordering.system.service.imp.restaurant.PhoneServiceImp;
import com.poet.ordering.system.service.imp.restaurant.RestaurantServiceImp;
import com.poet.ordering.system.service.imp.restaurant.TagServiceImp;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteRestaurant")
@MultipartConfig
public class DeleteRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantServiceImp restaruantService = RestaurantServiceImp.getInstance();
	private PhoneServiceImp phoneService = PhoneServiceImp.getInstance();
	private AddressServiceImp addressService = AddressServiceImp.getInstance();
	private TagServiceImp tagService = TagServiceImp.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteRestaurantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Restaurant restaurant = new Restaurant();
		try {
			restaurant = restaruantService.viewRestaurant(id);
			request.setAttribute("restaurantId", restaurant.getId());
			request.setAttribute("restaurantName", restaurant.getName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		request.getRequestDispatcher("/jsp/restaurant/deleteRestaurant.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("restaurantId"));
		try {
			addressService.deleteAddress(id);
			phoneService.deletePhone(id);
			tagService.deleteTag(id);
			restaruantService.deleteRestaurant(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// request.getRequestDispatcher("/jsp/restaurant/newRestaurant.jsp").forward(request,
		// response);
		response.sendRedirect("/AllRestaurants");
	}

}
