package com.poet.ordering.system.dao.imp.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.poet.ordering.system.connection.ConnectionManager;
import com.poet.ordering.system.dao.restaurant.RestaurantDAO;
import com.poet.ordering.system.model.Restaurant;

public class RestaurantDAOImp implements RestaurantDAO {

	private static RestaurantDAOImp instance;

	public static RestaurantDAOImp getInstance() {
		if (instance == null) {
			instance = new RestaurantDAOImp();
		}
		return instance;
	}

	public void insertRestaurant(Restaurant restaurant) throws Exception {

		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();

		String insertRestaurant = "INSERT INTO restaurant (`Name`, `Menu_url`, `Menu_image`, `User_id`) VALUES ('"
				+ restaurant.getName() + "', '" + restaurant.getMenuUrl() + "', '" + restaurant.getMenuImage() + "', '"
				+ restaurant.getUserId() + "');";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(insertRestaurant);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void editRestaurant(Restaurant restaurant) throws Exception {

		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();

		String editRestaurant = "UPDATE restaurant SET Name='" + restaurant.getName() + "', Menu_url ='"
				+ restaurant.getMenuUrl() + "', Menu_image = " + restaurant.getMenuImage() + ", User_id = "
				+ restaurant.getUserId() + " WHERE Restaurant_id =" + restaurant.getId() + ";";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(editRestaurant);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteRestaurant(int id) throws Exception {

		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();

		String deleteRestaurant = "DELETE FROM restaurant WHERE Restaurant_id = " + id;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(deleteRestaurant);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Restaurant> viewAllRestaurants() throws Exception {
		List<Restaurant> restaurantList = new ArrayList<>();
		ConnectionManager connectionManager = new ConnectionManager();
		String viewAllRestaurants = "SELECT * from restaurant";
		Connection conn = connectionManager.getConnection();
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(viewAllRestaurants);

		try {
			while (rs.next()) {
				int id = rs.getInt("Restaurant_id");
				String name = rs.getString("Name");
				String menuURL = rs.getString("Menu_url");
				String menuImage = rs.getString("Menu_image");

				Restaurant restaurant = new Restaurant();
				restaurant.setId(id);
				restaurant.setName(name);
				restaurant.setMenuUrl(menuURL);
				restaurant.setMenuImage(menuImage);
				restaurantList.add(restaurant);
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
		return restaurantList;
	}

	@Override
	public Restaurant getRestaurant(int id) throws Exception {
		ConnectionManager connectionManager = new ConnectionManager();
		Restaurant restaurant = new Restaurant();
		String viewRestaurant = "SELECT * from restaurant where Restaurant_id = " + id;
		Connection conn = connectionManager.getConnection();
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(viewRestaurant);
		try {
			while (rs.next()) {
				String name = rs.getString("Name");
				String menuURL = rs.getString("Menu_url");
				String menuImage = rs.getString("Menu_image");

				restaurant.setId(id);
				restaurant.setName(name);
				restaurant.setMenuUrl(menuURL);
				restaurant.setMenuImage(menuImage);
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
		return restaurant;
	}

	public List<Restaurant> selectRestaurantsInSearch(String search) {

		Connection conn = null;
		ResultSet rs = null;
		String query = "";
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		List<Restaurant> restaurantList = new ArrayList<Restaurant>();

		query = "SELECT * from restaurant WHERE Name LIKE '%" + search + "%'";

		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.setId(rs.getInt("Restaurant_id"));
				restaurant.setName(rs.getString("Name"));
				restaurant.setMenuUrl(rs.getString("Menu_url"));
				restaurantList.add(restaurant);
			}

		} catch (Exception ex) {
			System.out.println("select Restaurants failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, rs, conn);

		return restaurantList;
	}
}
