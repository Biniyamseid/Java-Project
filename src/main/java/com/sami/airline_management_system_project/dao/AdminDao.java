package com.sami.airline_management_system_project.dao;

import com.sami.airline_management_system_project.db.DataBaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
	public boolean validateAdmin(String adminName, String password) {
		boolean isvalidateAdmin = false;
		try {
			Connection connection = DataBaseConnector.getConnection();
			System.out.println(connection+"validate admin return connection");
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM admin_log WHERE admin_name=? AND admin_pass=?");
				preparedStatement.setString(1, adminName);
				preparedStatement.setString(2, password);
				ResultSet resultSet = preparedStatement.executeQuery();
				System.out.println(resultSet+"validate admin");
				if (resultSet.next()) {

					isvalidateAdmin = true;
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isvalidateAdmin;
	}

}


