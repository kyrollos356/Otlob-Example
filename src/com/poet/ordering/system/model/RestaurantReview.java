package com.poet.ordering.system.model;

public class RestaurantReview {

	private int reviewID ;
	private String Content ;
	private int rating ;
	private String date ;
	private int userID ;
	private int restaurantID ;
	private String userName ;
	private int starEmpty ;
	private String userPicture ;
    private final int totalRating = 5 ;
	
	
	
	public int getStarEmpty() {
		return starEmpty;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
		this.starEmpty = totalRating - rating  ;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}
	public String getUserPicture() {
		return userPicture;
	}
	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	
}
