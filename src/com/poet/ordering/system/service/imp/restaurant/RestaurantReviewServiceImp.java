package com.poet.ordering.system.service.imp.restaurant;

import java.util.ArrayList;

import com.poet.ordering.system.dao.imp.restaurant.RestaurantReviewDAOImp;
import com.poet.ordering.system.model.RestaurantReview;
import com.poet.ordering.system.service.restaurant.RestaurantReviewService;

public class RestaurantReviewServiceImp implements RestaurantReviewService {

	RestaurantReviewDAOImp restaurantReviewDAOImp = new RestaurantReviewDAOImp();
	private static RestaurantReviewServiceImp instance;

	public static RestaurantReviewServiceImp getInstance() {
		if (instance == null) {
			instance = new RestaurantReviewServiceImp();
		}
		return instance;
	}

	public void addNewRestaurantReview(RestaurantReview restaurantReview) throws Exception {

		int reviewID = restaurantReviewDAOImp.selectReviewID(restaurantReview);

		if (reviewID == 0) {
			restaurantReviewDAOImp.InsertRestaurantReview(restaurantReview);
		} else {
			restaurantReviewDAOImp.updateRestaurantReview(reviewID, restaurantReview);

		}
	}

	public ArrayList<RestaurantReview> viewAllRestaurantReviews(int restaurantID) throws Exception {
		return restaurantReviewDAOImp.selectAllRestaurantReviews(restaurantID);
	}

	public int averageRating(int restaurantID) throws Exception {
		int sumRating = restaurantReviewDAOImp.selectSumRatingRestaurant(restaurantID);
		int countUser = restaurantReviewDAOImp.selectCountUserRatingRestaurant(restaurantID);
		if (sumRating != 0 && countUser != 0) {
			return Math.round(sumRating / countUser);
		} else {
			return 0;
		}

	}

}
