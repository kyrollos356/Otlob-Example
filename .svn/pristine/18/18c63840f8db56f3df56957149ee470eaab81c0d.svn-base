package com.poet.ordering.system.dao.imp.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.poet.ordering.system.connection.ConnectionManager;
import com.poet.ordering.system.dao.order.OrderRequestDAO;
import com.poet.ordering.system.model.OrderRequest;
import com.poet.ordering.system.model.User;

public class OrderRequestDAOImp implements OrderRequestDAO {

	public List<OrderRequest> selectAllOpenOrderRequestsSortedByExpiryDate() {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		List<OrderRequest> allOrderRequests = new ArrayList<OrderRequest>();

		String query = "select * from order_request as request , restaurant as rs , user as u where Status = 'open' and request.User_id = u.User_id and request.Restaurant_id = rs.Restaurant_id ORDER BY Timeout ASC";

		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				OrderRequest eachOrderRequestInList = new OrderRequest();
				eachOrderRequestInList = populateOrderRequest(eachOrderRequestInList, rs);
				eachOrderRequestInList.setOwnerName(rs.getString("Full_name"));
				eachOrderRequestInList.setRestaurantName(rs.getString("Name"));
				allOrderRequests.add(eachOrderRequestInList);
			}

		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, rs, conn);

		return allOrderRequests;
	}

	public OrderRequest selectRequestOwner(OrderRequest eachOrderRequestInList, Connection conn) {

		ResultSet resultset = null;
		String query = "";
		Statement stmt = null;

		try {

			query = "select Full_name from user " + "WHERE User_id =" + eachOrderRequestInList.getUserId();

			stmt = conn.createStatement();
			resultset = stmt.executeQuery(query);

			resultset.next();
			eachOrderRequestInList.setOwnerName(resultset.getString("Full_name"));

		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}
		return eachOrderRequestInList;
	}

	public OrderRequest selectRestaurantName(OrderRequest eachOrderRequestInList, Connection conn) {

		ResultSet result = null;
		String query = "";
		Statement stmt = null;

		try {

			query = "select Name from restaurant " + "WHERE Restaurant_id =" + eachOrderRequestInList.getRestaurantId();

			stmt = conn.createStatement();
			result = stmt.executeQuery(query);

			result.next();
			eachOrderRequestInList.setRestaurantName(result.getString("Name"));

		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}
		return eachOrderRequestInList;
	}

	public OrderRequest selectRestaurantName(OrderRequest eachOrderRequestInList) {

		ResultSet result = null;
		String query = "";
		Statement stmt = null;

		try {
			ConnectionManager connect = new ConnectionManager();
			Connection connection = connect.getConnection();
			query = "select Name from restaurant " + "WHERE Restaurant_id =" + eachOrderRequestInList.getRestaurantId();

			stmt = connection.createStatement();
			result = stmt.executeQuery(query);

			result.next();
			eachOrderRequestInList.setRestaurantName(result.getString("Name"));

		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}
		return eachOrderRequestInList;
	}

	private OrderRequest populateOrderRequest(OrderRequest orderRequest, ResultSet rs) throws SQLException {
		orderRequest.setId(rs.getInt("Order_request_id"));
		orderRequest.setTimeout(rs.getString("Timeout"));
		orderRequest.setStatus(rs.getString("Status"));
		orderRequest.setUserId(rs.getInt("User_id"));
		orderRequest.setRestaurantId(rs.getInt("Restaurant_id"));
		return orderRequest;
	}

	@Override
	public long createOrderRequest(OrderRequest orderRequest) throws Exception {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();

		String insertOrderRequest = "INSERT INTO order_request (`Timeout`, `Status`, `User_id`, `Restaurant_id`) VALUES ('"
				+ orderRequest.getTimeout() + "', '" + orderRequest.getStatus() + "', '" + orderRequest.getUserId()
				+ "', '" + orderRequest.getRestaurantId() + "');";
		System.out.println(insertOrderRequest);
		PreparedStatement preparedStatement;
		long id = 0;
		try {
			preparedStatement = connection.prepareStatement(insertOrderRequest, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.executeUpdate();
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = generatedKeys.getLong(1);
					System.out.println("here");
					System.out.println(id);
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;

	}

	@Override
	public void deleteOrderRequest(int id) throws Exception {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();

		String deleteOrderRequest = "DELETE FROM order_request WHERE Order_request_id = " + id;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(deleteOrderRequest);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderRequest getOrderRequest(int id) throws Exception {
		ConnectionManager connectionManager = new ConnectionManager();
		OrderRequest orderRequest = new OrderRequest();

		String getOrderRequest = "SELECT * from order_request WHERE Order_request_id=" + id;

		Connection conn = connectionManager.getConnection();
		Statement stmt = null;
		stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(getOrderRequest);
		while (rs.next()) {
			String timeout = rs.getString("Timeout");
			String status = rs.getString("Status");
			int userId = rs.getInt("User_id");
			int restaurantId = rs.getInt("Restaurant_id");

			orderRequest.setId(id);
			orderRequest.setStatus(status);
			orderRequest.setTimeout(timeout);
			orderRequest.setUserId(userId);
			orderRequest.setRestaurantId(restaurantId);
		}
		return orderRequest;
	}

	@Override
	public void changeStatus(OrderRequest orderRequest) throws Exception {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();

		String changeStatus = "UPDATE order_request SET Status='" + orderRequest.getStatus()
				+ "' WHERE Order_request_id =" + orderRequest.getId() + ";";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(changeStatus);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertOrderInfo(OrderRequest userOrderInfo) throws Exception {
		ConnectionManager connect = new ConnectionManager();
		Connection connection = connect.getConnection();

		Statement statement = null;
		try {
			statement = connection.createStatement();
			String insert = "INSERT INTO order_request(Timeout,Status,User_id ,Restaurant_id) VALUES ('"
					+ userOrderInfo.getTimeout() + "''" + userOrderInfo.getStatus() + "','" + userOrderInfo.getUserId()
					+ "','" + userOrderInfo.getRestaurantId() + "');";
			statement.executeUpdate(insert);

		} catch (SQLException exception) {
			exception.getStackTrace();
		}
		connection.close();
	}

	public OrderRequest selectOrderId(OrderRequest userOrderInfo) throws Exception {
		ConnectionManager connect = new ConnectionManager();
		Connection connection = connect.getConnection();
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from user Where username ='" + userOrderInfo.getId() + "'");
			while (resultSet.next()) {
				userOrderInfo.setRestaurantId(resultSet.getInt("Restaurant_id"));
			}
		} catch (SQLException exception) {
			exception.getStackTrace();
		}
		connection.close();
		return userOrderInfo;
	}

	public void deleteUserOrderRequest(OrderRequest userOrderInfo) throws Exception {
		deleteUserOrderByOrderRequestId(userOrderInfo);
		ConnectionManager connect = new ConnectionManager();
		Connection connection = connect.getConnection();

		Statement statement = null;
		try {
			statement = connection.createStatement();
			String insert = "DELETE FROM order_request Where Order_request_id =" + userOrderInfo.getId();
			System.out.println(insert);
			statement.executeUpdate(insert);
		} catch (SQLException exception) {
			System.out.println("deleteUserOrderRequest failed: An Exception has occurred! " + exception);
			exception.getStackTrace();
		}
		connection.close();
	}

	public List<User> selectUserFollowers(int idUser) throws Exception {

		ConnectionManager connect = new ConnectionManager();
		Connection connection = connect.getConnection();
		List<User> users = new ArrayList<User>();
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String insert = "select email , User_id from User , subscription where User_id = subscription.User_id1 and User_id2 ="
					+ idUser + " GROUP BY User_id";
			resultSet = statement.executeQuery(insert);

			while (resultSet.next()) {
				String email = resultSet.getString("email");
				int id = resultSet.getInt("User_id");

				User user = new User();
				user.setEmail(email);
				user.setId(id);
				users.add(user);
			}

		} catch (SQLException exception) {
			exception.getStackTrace();
		}
		connection.close();
		return users;
	}

	public String selectRequestOwnerName(int userId) throws Exception {
		ConnectionManager connect = new ConnectionManager();
		Connection connection = connect.getConnection();
		String username = null;
		try {

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select Full_name from user Where username ='" + userId + "'");
			while (resultSet.next()) {
				username = resultSet.getString("Full_name");
			}
		} catch (SQLException exception) {
			exception.getStackTrace();
		}
		connection.close();
		return username;
	}

	public OrderRequest selectRestaurantIdFromOrderRequest(OrderRequest orderRequest) {
		Connection conn = null;
		ResultSet rs = null;
		String query = "";
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		query = "select Restaurant_id from order_request WHERE Order_request_id = " + orderRequest.getId();
		System.out.println(query);
		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();

			orderRequest.setRestaurantId(rs.getInt("Restaurant_id"));

		} catch (Exception ex) {
			System.out.println("select RestaurantId From OrderRequest failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, rs, conn);

		return orderRequest;
	}

	public void insertOrderTimeout(java.util.Date timoutdate, int userId) throws Exception {
		ConnectionManager connect = new ConnectionManager();
		Connection connection = connect.getConnection();

		Statement statement = null;
		try {
			statement = connection.createStatement();
			String insert = "INSERT INTO order_request(Timeout) VALUES ('" + timoutdate + "')" + "Where User_id ='"
					+ userId + "'";
			statement.executeUpdate(insert);

		} catch (SQLException exception) {
			exception.getStackTrace();
		}
		connection.close();
	}

	public void deleteUserOrderByOrderRequestId(OrderRequest userOrderInfo) throws Exception {
		ConnectionManager connect = new ConnectionManager();
		Connection connection = connect.getConnection();

		Statement statement = null;
		try {
			statement = connection.createStatement();
			String insert = "DELETE FROM orders Where Order_request_id = '" + userOrderInfo.getId() + "';";
			statement.executeUpdate(insert);
		} catch (SQLException exception) {
			System.out.println("deleteUserOrder failed: An Exception has occurred! " + exception);
			exception.getStackTrace();
		}
		connection.close();
	}

	public OrderRequest selectOrderRequestByUser(User user) {

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		OrderRequest orderRequest = new OrderRequest();
		ConnectionManager connectionManager = new ConnectionManager();

		String query = "select * from order_request where User_id = " + user.getId();
		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			orderRequest = populateOrderRequest(orderRequest, rs);

		} catch (Exception ex) {
			System.out.println("Select order by user failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, rs, conn);
		return orderRequest;

	}
}
