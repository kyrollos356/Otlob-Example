package com.poet.ordering.system.servlets.restaurants;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.poet.ordering.system.model.Address;
import com.poet.ordering.system.model.Phone;
import com.poet.ordering.system.model.Restaurant;
import com.poet.ordering.system.model.Tag;
import com.poet.ordering.system.model.User;
import com.poet.ordering.system.service.imp.restaurant.AddressServiceImp;
import com.poet.ordering.system.service.imp.restaurant.PhoneServiceImp;
import com.poet.ordering.system.service.imp.restaurant.RestaurantServiceImp;
import com.poet.ordering.system.service.imp.restaurant.TagServiceImp;

@WebServlet("/RestaurantServlet")
@MultipartConfig
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantServiceImp restaruantService = RestaurantServiceImp.getInstance();
	private PhoneServiceImp phoneService = PhoneServiceImp.getInstance();
	private AddressServiceImp addressService = AddressServiceImp.getInstance();
	private TagServiceImp tagService = TagServiceImp.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameterMap().containsKey("id")) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				Restaurant restaurant = new Restaurant();
				Phone phone = new Phone();
				Address address = new Address();
				Tag tag = new Tag();
				restaurant = restaruantService.viewRestaurant(id);
				phone = phoneService.viewPhone(id);
				address = addressService.viewAddress(id);
				tag = tagService.viewTag(id);

				request.setAttribute("restaurantId", restaurant.getId());
				request.setAttribute("restaurantName", restaurant.getName());
				request.setAttribute("restaurantMenuUrl", restaurant.getMenuUrl());
				request.setAttribute("restaurantMenuImage", restaurant.getMenuImage());
				request.setAttribute("restaurantPhone", phone.getPhoneNumber());
				request.setAttribute("restaurantAddress", address.getAddress());
				request.setAttribute("restaurantTag", tag.getTag());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/jsp/restaurant/editRestaurant.jsp").forward(request, response);
		} else {
			request.setAttribute("restaurantname", "");
			request.setAttribute("menuurl", "");
			try {
				List<Restaurant> listRestaurant = restaruantService.viewAll();
				request.setAttribute("listResaurant", listRestaurant);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// response.sendRedirect("/AllRestaurants");
			request.getRequestDispatcher("/jsp/restaurant/newRestaurant.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("addRestaurant").equalsIgnoreCase("edit")) {
			editRestaurant(request, response);
		} else {
			insertRestaurant(request, response);
		}
	}

	private void insertRestaurant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Restaurant restaurant = new Restaurant();
		Phone phone = new Phone();
		Address address = new Address();
		Tag tag = new Tag();

		restaurant.setName(request.getParameter("restaurantname"));
		restaurant.setMenuUrl(request.getParameter("menuurl"));

		phone.setPhoneNumber(request.getParameter("phone"));

		address.setAddress(request.getParameter("address"));

		tag.setTag(request.getParameter("tag"));

		User user = (User) request.getSession().getAttribute("user");
		restaurant.setUserId(user.getId());
		Part filePart = request.getPart("file");
		String fileName = getSubmittedFileName(filePart);
		if(!fileName.isEmpty()) {
			filePart.write("D:\\restaurantimages\\" + fileName);
			restaurant.setMenuImage(fileName);
		}
		try {
			restaruantService.addNewRestaurant(restaurant);
			phoneService.addNewPhone(phone, restaurant);
			addressService.addNewAddress(address, restaurant);
			tagService.addNewTag(tag, restaurant);
			request.setAttribute("id", restaurant.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// request.getRequestDispatcher("/jsp/restaurant/restaurantProfile.jsp").forward(request,
		// response);
		response.sendRedirect("/AllRestaurants");
	}

	private void editRestaurant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Restaurant restaurant = new Restaurant();
		Phone phone = new Phone();
		Address address = new Address();
		Tag tag = new Tag();
		int id = Integer.parseInt(request.getParameter("restaurantId"));
		restaurant.setId(id);
		restaurant.setName(request.getParameter("restaurantname"));
		restaurant.setMenuUrl(request.getParameter("menuurl"));
		restaurant.setUserId(5);

		Part filePart = request.getPart("file");
		String fileName = getSubmittedFileName(filePart);
		if(!fileName.isEmpty()) {
			filePart.write("D:\\restaurantimages\\" + fileName);
			restaurant.setMenuImage(fileName);
		}

		phone.setPhoneNumber(request.getParameter("phone"));
		phone.setRestaurantId(id);
		address.setAddress(request.getParameter("address"));
		address.setRestaurantId(id);
		tag.setTag(request.getParameter("tag"));
		tag.setRestaurantId(id);

		User user = (User) request.getSession().getAttribute("user");
		restaurant.setUserId(user.getId());

		try {
			restaruantService.editRestaurant(restaurant);
			phoneService.editPhone(phone);
			addressService.editAddress(address);
			tagService.editTag(tag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/AllRestaurants");
		// request.getRequestDispatcher("/jsp/restaurant/newRestaurant.jsp").forward(request,
		// response);
	}

	private static String getSubmittedFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE
																													// fix.
			}
		}
		return null;
	}

}
