package com.poet.ordering.system.dao.imp.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.poet.ordering.system.connection.ConnectionManager;
import com.poet.ordering.system.dao.restaurant.RestaurantReviewDAO;
import com.poet.ordering.system.model.RestaurantReview;

public class RestaurantReviewDAOImp implements RestaurantReviewDAO {

	private static RestaurantReviewDAOImp instance;

	public static RestaurantReviewDAOImp getInstance() {
		if (instance == null) {
			instance = new RestaurantReviewDAOImp();
		}
		return instance;
	}

	public void InsertRestaurantReview(RestaurantReview restaurantReview) throws Exception {

		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();

		String insertRestaurantReview = "INSERT INTO restaurant_review (Content,Rating,User_id,Restaurant_id) VALUES ('"
				+ restaurantReview.getContent() + "', '" + restaurantReview.getRating() + "', '"
				+ restaurantReview.getUserID() + "', '" + restaurantReview.getRestaurantID() + "');";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(insertRestaurantReview);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<RestaurantReview> selectAllRestaurantReviews(int restaurantID) throws Exception {
		ArrayList<RestaurantReview> restaurantReviews = new ArrayList<>();
		ConnectionManager connectionManager = new ConnectionManager();
		String viewAllRestaurantReviews = "SELECT Picture ,Content , Rating , Date_of_creation , user.User_id , Full_name  from restaurant_review , user where Restaurant_id = "
				+ restaurantID + " and user.User_id = restaurant_review.User_id ORDER BY Date_of_creation DESC ";

		Connection conn = connectionManager.getConnection();
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(viewAllRestaurantReviews);

		try {
			while (rs.next()) {
				String picture = rs.getString("Picture");
				int userID = rs.getInt("user.User_id");
				int rating = rs.getInt("Rating");
				String content = rs.getString("Content");
				String Date_of_creation = rs.getString("Date_of_creation");
				String Full_name = rs.getString("Full_name");

				RestaurantReview restaurantReview = new RestaurantReview();
				restaurantReview.setUserPicture(picture);
				// if (!picture.equals("null")) {
				// restaurantReview.setUserPicture("http://nb-fawad:9090/usersProfileImages/" +
				// picture);
				// } else {
				// restaurantReview.setUserPicture("http://nb-fawad:9090/usersProfileImages/user.jpg");
				// }
				restaurantReview.setUserID(userID);
				restaurantReview.setRating(rating);
				restaurantReview.setDate(Date_of_creation);
				restaurantReview.setContent(content);
				restaurantReview.setUserName(Full_name);
				restaurantReviews.add(restaurantReview);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
		}
		return restaurantReviews;
	}

	public int selectCountUserRatingRestaurant(int restaurantID) throws Exception {

		int countUser = 0;
		ConnectionManager connectionManager = new ConnectionManager();
		String viewAllRestaurantReviews = "select count(User_id) from restaurant_review where Rating != 0 and  Restaurant_id = "
				+ restaurantID;

		Connection conn = connectionManager.getConnection();
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(viewAllRestaurantReviews);

		try {
			while (rs.next()) {
				countUser = rs.getInt("count(User_id)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
		}
		return countUser;
	}

	public int selectSumRatingRestaurant(int restaurantID) throws Exception {

		int sumRating = 0;
		ConnectionManager connectionManager = new ConnectionManager();
		String viewAllRestaurantReviews = "select sum(Rating) from restaurant_review where Restaurant_id = "
				+ restaurantID;

		Connection conn = connectionManager.getConnection();
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(viewAllRestaurantReviews);

		try {
			while (rs.next()) {
				sumRating = rs.getInt("sum(Rating)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
		}
		return sumRating;
	}

	public int selectReviewID(RestaurantReview restaurantReview) throws Exception {
		int ReviewID = 0;
		ConnectionManager connectionManager = new ConnectionManager();
		String viewAllRestaurantReviews = "select Review_id from restaurant_review where User_id ="
				+ restaurantReview.getUserID() + " and Restaurant_id=" + restaurantReview.getRestaurantID();

		Connection conn = connectionManager.getConnection();
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(viewAllRestaurantReviews);

		try {
			while (rs.next()) {
				ReviewID = rs.getInt("Review_id");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
		}
		return ReviewID;
	}

	public void updateRestaurantReview(int reviewID, RestaurantReview restaurantReview) throws Exception {

		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();

		String insertRestaurantReview = "UPDATE restaurant_review SET `Content`='" + restaurantReview.getContent()
				+ "', `Rating`='" + restaurantReview.getRating() + "', `date_of_creation`= now() WHERE `Review_id`='"
				+ reviewID + "';";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(insertRestaurantReview);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
