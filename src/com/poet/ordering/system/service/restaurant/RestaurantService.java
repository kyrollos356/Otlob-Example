package com.poet.ordering.system.service.restaurant;

import java.util.List;

import com.poet.ordering.system.model.Restaurant;

public interface RestaurantService {
	
	public boolean addNewRestaurant(Restaurant restaurant) throws Exception;
	
	public List<Restaurant> viewAll() throws Exception;
	
	public Restaurant viewRestaurant(int id) throws Exception;
	
	public void deleteRestaurant(int id) throws Exception;
	
	public void editRestaurant(Restaurant restaurant) throws Exception;
	
	public List<Restaurant> viewRestaurantSearchResults(String search);
}
