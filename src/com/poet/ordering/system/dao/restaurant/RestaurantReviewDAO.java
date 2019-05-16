package com.poet.ordering.system.dao.restaurant;

import java.util.ArrayList;

import com.poet.ordering.system.model.RestaurantReview;

public interface RestaurantReviewDAO {

	public void InsertRestaurantReview(RestaurantReview restaurantReview) throws Exception;

	public ArrayList<RestaurantReview> selectAllRestaurantReviews(int restaurantID) throws Exception;

	public int selectCountUserRatingRestaurant(int restaurantID) throws Exception;

	public int selectSumRatingRestaurant(int restaurantID) throws Exception;

	public int selectReviewID(RestaurantReview restaurantReview) throws Exception;

	public void updateRestaurantReview(int reviewID, RestaurantReview restaurantReview) throws Exception;

}
