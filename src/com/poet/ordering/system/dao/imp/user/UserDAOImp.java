package com.poet.ordering.system.dao.imp.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.poet.ordering.system.connection.ConnectionManager;
import com.poet.ordering.system.dao.user.UserDAO;
import com.poet.ordering.system.model.ImageUtility;
import com.poet.ordering.system.model.User;

public class UserDAOImp implements UserDAO {

	public int addNewUser(User user) {

		ConnectionManager connectionManager = new ConnectionManager();

		String insertUserStatement = "INSERT INTO `orderiingsystem`.`user` (`Full_name`, `Skype_id`, `Email`, `Password`, `Picture`) VALUES ('"
				+ user.getFullname() + "', '" + user.getSkypeID() + "', '" + user.getEmail() + "', '"
				+ user.getPassword() + "', '" + user.getPicture() + "');";

		try {
			Connection connection = connectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insertUserStatement);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			return e.getErrorCode();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int editUserProfile(User user) {

		ConnectionManager connectionManager = new ConnectionManager();

		String updateUserStatement = "UPDATE `orderiingsystem`.`user` SET `Full_name`='" + user.getFullname()
				+ "', `Skype_id`='" + user.getSkypeID() + "', `Email`='" + user.getEmail() + "' WHERE `User_id`='"
				+ user.getId() + "';";

		try {
			Connection connection = connectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(updateUserStatement);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			return e.getErrorCode();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public User findByEmailAndPassword(User user) {

		String selectUserStatement = "SELECT " + "User_id, Full_name, Skype_id, Email, Password, Picture" + " "
				+ "FROM user " + "WHERE Email='" + user.getEmail() + "' AND Password='" + user.getPassword() + "';";

		ConnectionManager connectionManager = new ConnectionManager();

		PreparedStatement preparedStatement = null;
		try {
			Connection connection = connectionManager.getConnection();
			preparedStatement = connection.prepareStatement(selectUserStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if (!rs.next()) {
				connection.close();
				return null;
			}
			user = populateUserFields(user, rs);
			connection.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private User populateUserFields(User user, ResultSet rs) {
		ImageUtility imageUtility = new ImageUtility();
		try {
			user.setFullname(rs.getString("Full_name"));
			user.setSkypeID(rs.getString("Skype_id"));

			user.setPicture(imageUtility.getServerPath() + rs.getString("Picture"));
			user.setId(rs.getInt("User_id"));
			user.setEmail(user.getEmail());
			user.setPassword(user.getPassword());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	private User populateUserFieldsViaID(User user, ResultSet rs) {
		ImageUtility imageUtility = new ImageUtility();
		try {
			user.setFullname(rs.getString("Full_name"));
			user.setSkypeID(rs.getString("Skype_id"));

			user.setPicture(imageUtility.getServerPath() + rs.getString("Picture"));
			user.setId(rs.getInt("User_id"));
			user.setEmail(rs.getString("email"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public void deleteUserById(User user) {

		Connection conn = null;
		String query = "";
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		query = "DELETE FROM user WHERE User_id = '" + user.getId() + "';";

		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(query);

		} catch (Exception ex) {
			System.out.println("Deletion failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, null, conn);
	}

	public void insertInSubscription(User user1, User user2) {

		Connection conn = null;
		String query = "";
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		query = "INSERT INTO `subscriptions` (`User_id1`, `User_id2`) VALUES ('" + user1.getId() + "', '"
				+ user2.getId() + "');";

		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(query);

		} catch (Exception ex) {
			System.out.println("insert In Subscription failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, null, conn);
	}

	public void deleteFromSubscription(User user1, User user2) {

		Connection conn = null;
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		String query = "DELETE FROM subscriptions WHERE User_id1 = '" + user1.getId() + "' and User_id2 = '"
				+ user2.getId() + "'";

		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(query);

		} catch (Exception ex) {
			System.out.println("delete From Subscription failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, null, conn);
	}

	public List<User> selectSubscriptionsByUserId(User user) {

		Connection conn = null;
		ResultSet rs = null;
		String query = "";
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		List<User> allSubscribers = new ArrayList<User>();

		query = "select * from user where User_id in (select User_id2 from subscriptions WHERE User_id1 = "
				+ user.getId() + ")";

		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				User eachSubscriber = new User();
				eachSubscriber = populateUserFields(eachSubscriber, rs);
				allSubscribers.add(eachSubscriber);
			}

		} catch (Exception ex) {
			System.out.println("select Subscribers failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, rs, conn);

		return allSubscribers;
	}

	public List<User> selectNonSubscriptionsByUserId(User user) {

		Connection conn = null;
		ResultSet rs = null;
		String query = "";
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		List<User> allUnsubscribers = new ArrayList<User>();

		query = "select * from user WHERE ( (User_id) NOT IN ( select User_id2 from subscriptions where User_id1 = "
				+ user.getId() + ")) and (User_id != " + user.getId() + ")";

		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				User eachUnsubscriber = new User();
				eachUnsubscriber = populateUserFields(eachUnsubscriber, rs);
				allUnsubscribers.add(eachUnsubscriber);
			}

		} catch (Exception ex) {
			System.out.println("select Unsubscribers failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, rs, conn);

		return allUnsubscribers;
	}

	public List<User> selectUserInSearchWhereSubscribed(String search, User user) {

		Connection conn = null;
		ResultSet rs = null;
		String query = "";
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		List<User> subscriberSearchList = new ArrayList<User>();

		query = "SELECT * from user WHERE Full_name LIKE '%" + search + "%'"
				+ "and User_id in (select User_id2 from subscriptions WHERE User_id1 = " + +user.getId() + ")";

		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				User eachUser = new User();
				eachUser = populateUserFields(eachUser, rs);
				subscriberSearchList.add(eachUser);
			}

		} catch (Exception ex) {
			System.out.println("select subscribers failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, rs, conn);

		return subscriberSearchList;
	}

	public List<User> selectUserInSearchWhereNotSubscribed(String search, User user) {

		Connection conn = null;
		ResultSet rs = null;
		String query = "";
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		List<User> nonSubscriberSearchList = new ArrayList<User>();

		query = "SELECT * from user WHERE Full_name LIKE '%" + search + "%'"
				+ "and ( (User_id) NOT IN ( select User_id2 from subscriptions where User_id1 = " + user.getId()
				+ ")) and (User_id != " + user.getId() + ")";

		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				User eachUser = new User();
				eachUser = populateUserFields(eachUser, rs);
				nonSubscriberSearchList.add(eachUser);
			}

		} catch (Exception ex) {
			System.out.println("select Unsubscribers failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, rs, conn);

		return nonSubscriberSearchList;
	}

	public User findbyID(String id) {
		String selectUserStatement = "SELECT " + "User_id, Full_name, Skype_id, Email, Password, Picture" + " "
				+ "FROM user " + "WHERE User_id='" + id + "';";

		Connection conn = null;
		ResultSet rs = null;
		String query = "";
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		try {
			Connection connection = connectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(selectUserStatement);
			rs = preparedStatement.executeQuery();
			rs.next();
			User user = new User();

			user = populateUserFieldsViaID(user, rs);

			connection.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkIfSubscribed(User user, User selectedUser) {

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		boolean check = false;

		ConnectionManager connectionManager = new ConnectionManager();

		String query = "SELECT * from subscriptions WHERE User_id1 = '" + user.getId() + "' AND User_id2 = '"
				+ selectedUser.getId() + "'";

		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			check = rs.next() ? true : false;
			ConnectionManager.closeConnection(stmt, rs, conn);
		} catch (Exception ex) {
			System.out.println("check subscriber failed: An Exception has occurred! " + ex);
		}

		return check;
	}

	public List<User> selectSubscribersByUserId(User user) {

		Connection conn = null;
		ResultSet rs = null;
		String query = "";
		Statement stmt = null;

		ConnectionManager connectionManager = new ConnectionManager();

		List<User> allSubscribers = new ArrayList<User>();

		query = "select * from user where User_id in (select User_id1 from subscriptions WHERE User_id2 = "
				+ user.getId() + ")";

		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				User eachSubscriber = new User();
				eachSubscriber = populateUserFields(eachSubscriber, rs);
				allSubscribers.add(eachSubscriber);
			}

		} catch (Exception ex) {
			System.out.println("select Subscribers failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, rs, conn);

		return allSubscribers;
	}

	public boolean selectisAdminFromUser(User user) {

		Connection conn = null;
		ResultSet rs = null;
		String query = "";
		Statement stmt = null;

		boolean isAdmin = false;

		ConnectionManager connectionManager = new ConnectionManager();

		query = "select isAdmin from user where User_id =" + user.getId();

		try {
			conn = connectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			rs.next();

			if (rs.getBoolean(1))
				isAdmin = true;

		} catch (Exception ex) {
			System.out.println("select isAdmin From User failed: An Exception has occurred! " + ex);
		}

		ConnectionManager.closeConnection(stmt, rs, conn);
		return isAdmin;
	}

}
