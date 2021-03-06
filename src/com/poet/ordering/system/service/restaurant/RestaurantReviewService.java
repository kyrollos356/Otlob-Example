package com.poet.ordering.system.service.restaurant;

import java.util.ArrayList;

import com.poet.ordering.system.model.RestaurantReview;

public interface RestaurantReviewService {

	public void addNewRestaurantReview(RestaurantReview RestaurantReview) throws Exception;

	public ArrayList<RestaurantReview> viewAllRestaurantReviews(int restaurantID) throws Exception;

	public int averageRating(int restaurantID) throws Exception ;
}
