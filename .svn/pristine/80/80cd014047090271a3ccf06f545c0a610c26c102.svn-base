package com.poet.ordering.system.dao.imp.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.poet.ordering.system.connection.ConnectionManager;
import com.poet.ordering.system.dao.restaurant.AddressDAO;
import com.poet.ordering.system.model.Address;
import com.poet.ordering.system.model.Restaurant;

public class AddressDAOImp implements AddressDAO{

	public void insertAddress(Address address, Restaurant restaurant) throws Exception {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		
		String getId = "SELECT Restaurant_id from restaurant where Name='" + restaurant.getName() + "'";
		String insertAddress = "";
		
		Connection conn = connectionManager.getConnection();
		PreparedStatement preparedStatement;
		Statement stmt = null;
		stmt = conn.createStatement();
		try {
			ResultSet rs = stmt.executeQuery(getId);
			while(rs.next()){
		         int id  = rs.getInt("Restaurant_id");
		         insertAddress = "INSERT INTO addresses (`Address`, `Restaurant_id`) VALUES ('"+ address.getAddress() + "', '" +id + "');";
		     }
			preparedStatement = connection.prepareStatement(insertAddress);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editAddress(Address address) throws Exception {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		
		String editAddress = "UPDATE addresses SET Address='"+ address.getAddress() + "' WHERE Restaurant_id =" + address.getRestaurantId() + ";";
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(editAddress);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteAddress(int id) throws Exception {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		
		String deleteAddresses = "DELETE FROM addresses WHERE Restaurant_id = " + id;
		
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement(deleteAddresses);
		preparedStatement.executeUpdate();
	}

	@Override
	public Address getAddress(int id) throws Exception {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		Address address = new Address();
		
		String viewAddress = "SELECT * from addresses where Restaurant_id = " + id;
		
		Connection conn = connectionManager.getConnection();
		Statement stmt = null;
		stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(viewAddress);
		
		while(rs.next()){
	         String addressLocation = rs.getString("Address");
	         
	         address.setRestaurantId(id);
	         address.setAddress(addressLocation);
	     }
		return address;
	}

}
