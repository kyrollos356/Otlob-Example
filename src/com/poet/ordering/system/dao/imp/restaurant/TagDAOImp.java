package com.poet.ordering.system.dao.imp.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.poet.ordering.system.connection.ConnectionManager;
import com.poet.ordering.system.dao.restaurant.TagDAO;
import com.poet.ordering.system.model.Restaurant;
import com.poet.ordering.system.model.Tag;

public class TagDAOImp implements TagDAO{
	
	public void insertTag(Tag tag, Restaurant restaurant) throws Exception {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		
		String getId = "SELECT Restaurant_id from restaurant where Name='" + restaurant.getName() + "'";
		String insertTag = "";
				
		Connection conn = connectionManager.getConnection();
		PreparedStatement preparedStatement;
		Statement stmt = null;
		stmt = conn.createStatement();
		try {
			ResultSet rs = stmt.executeQuery(getId);
			while(rs.next()){
		         int id  = rs.getInt("Restaurant_id");
		         insertTag = "INSERT INTO tag (`Tag_name`, `Restaurant_id`) VALUES ('"+ tag.getTag() + "', '" + id + "');";
		      }
			preparedStatement = connection.prepareStatement(insertTag);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void editTag(Tag tag) throws Exception {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		
		String editTag = "UPDATE tag SET Tag_name='"+ tag.getTag() + "' WHERE Restaurant_id =" + tag.getRestaurantId() + ";";
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(editTag);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTag(int id) throws Exception {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		
		String deleteTag = "DELETE FROM tag WHERE Restaurant_id = " + id;
		
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement(deleteTag);
		preparedStatement.executeUpdate();
	}

	@Override
	public Tag getTag(int id) throws Exception {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		Tag tag = new Tag();
		
		String viewTag = "SELECT * from tag where Restaurant_id = " + id;
		
		Connection conn = connectionManager.getConnection();
		Statement stmt = null;
		stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(viewTag);
		
		while(rs.next()){
	         String tagName = rs.getString("Tag_name");
	         
	         tag.setRestaurantId(id);
	         tag.setTag(tagName);
	     }
		return tag;
	}

}
