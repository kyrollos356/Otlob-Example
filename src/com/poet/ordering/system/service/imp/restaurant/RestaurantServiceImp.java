package com.poet.ordering.system.service.imp.restaurant;

import java.util.List;

import com.poet.ordering.system.dao.imp.restaurant.RestaurantDAOImp;
import com.poet.ordering.system.model.Restaurant;
import com.poet.ordering.system.service.restaurant.RestaurantService;

public class RestaurantServiceImp implements RestaurantService {

	RestaurantDAOImp restaurantDAO = new RestaurantDAOImp();
	private static RestaurantServiceImp instance;

	public static RestaurantServiceImp getInstance() {
		if (instance == null) {
			instance = new RestaurantServiceImp();
		}
		return instance;
	}

	public boolean addNewRestaurant(Restaurant restaurant) throws Exception {
		restaurantDAO.insertRestaurant(restaurant);
		return false;
	}

	public List<Restaurant> viewAll() throws Exception {
		return restaurantDAO.viewAllRestaurants();
	}

	public Restaurant viewRestaurant(int id) throws Exception {
		Restaurant restaurant = restaurantDAO.getRestaurant(id);
		return restaurant;
	}

	public void deleteRestaurant(int id) throws Exception {
		restaurantDAO.deleteRestaurant(id);
	}

	public void editRestaurant(Restaurant restaurant) throws Exception {
		restaurantDAO.editRestaurant(restaurant);
	}

	public List<Restaurant> viewRestaurantSearchResults(String search) {
		return restaurantDAO.selectRestaurantsInSearch(search);
	}
}
