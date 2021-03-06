package com.poet.ordering.system.dao.imp.order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.poet.ordering.system.connection.ConnectionManager;
import com.poet.ordering.system.model.Order;
import com.poet.ordering.system.model.User;
import com.poet.ordering.system.service.imp.user.UserServiceImp;

public class OrderDAOImp {

	public void insertOrder(Order order) {
		
		Connection conn = null;
		String query = "";
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		query = "INSERT INTO `orders` (`Content`, `User_id`, `Order_request_id`) VALUES ('" + order.getContent() + "', '" + order.getUserId()
		+ "', '" + order.getOrderRequestId() + "');";

		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
		    stmt.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println("insertOrder failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, null, conn);
	}
	
	public void updateOrder(Order order) {
		Connection conn = null;
		String query = "";
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		query = "UPDATE `orders` SET `Content`='" + order.getContent() + "' WHERE `User_id`='"
		+ order.getUserId() + "' and `Order_request_id`='"+ order.getOrderRequestId() + "';";
		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(query);

		} catch (Exception ex) {
			System.out.println("updateOrder failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, null, conn);
	}
	
	public List<Order> viewAllOrders(int orderRequestId) throws Exception {
		List<Order> ordersList = new ArrayList<>();
		
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();

		String viewAllOrders = "SELECT * from orders WHERE Order_request_id=" + orderRequestId;
		
		Connection conn = connectionManager.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		stmt = conn.createStatement();
		try {
			rs = stmt.executeQuery(viewAllOrders);
			while (rs.next()) {
				int id = rs.getInt("Order_request_id");
				String content = rs.getString("Content");
				int userId = rs.getInt("User_id");
				
			    UserServiceImp userServiceImp = UserServiceImp.getInstance();
				User user = userServiceImp.findbyID(Integer.toString(userId));
				
				Order order = new Order();
				order.setId(id);
				order.setContent(content);
				order.setUserId(userId);
				order.setUserName(user.getFullname());
				ordersList.add(order);
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		ConnectionManager.closeConnection(stmt, rs, conn);
		return ordersList;
	}
	
	public boolean selectFromOrdersByUserIdToCheckExistence(Order order) {
		Connection conn = null;
		String query = "";
		Statement stmt = null;
		ResultSet rs = null;
		boolean isUserSubmittedOrder = false;

		ConnectionManager connectionManager = new ConnectionManager();

		query = "select Order_id from orders where User_id = " + order.getUserId() + " and Order_request_id = " + order.getOrderRequestId() ;
		System.out.println(query);
		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			if (rs.next())
				isUserSubmittedOrder = true;

		} catch (Exception ex) {
			System.out.println("selectFromOrdersByUserIdToCheckExistence failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, rs, conn);

		return isUserSubmittedOrder;
	}
}
