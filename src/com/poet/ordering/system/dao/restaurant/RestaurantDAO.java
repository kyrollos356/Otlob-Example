package com.poet.ordering.system.dao.restaurant;

import java.util.List;

import com.poet.ordering.system.model.Restaurant;

public interface RestaurantDAO {

	public void insertRestaurant(Restaurant restaurant) throws Exception;

	public void editRestaurant(Restaurant restaurant) throws Exception;
	
	public List<Restaurant> viewAllRestaurants() throws Exception;

	public void deleteRestaurant(int id) throws Exception;

	public Restaurant getRestaurant(int id) throws Exception;

	public List<Restaurant> selectRestaurantsInSearch(String search);
}
