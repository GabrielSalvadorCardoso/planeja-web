package com.ginfohouse.planejaweb.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/planeja_web", "root", "root");
		} catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return connection;
	}
}
