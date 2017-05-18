package com.ginfohouse.planejaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.ginfohouse.planejaweb.factory.ConnectionFactory;
import com.ginfohouse.planejaweb.model.User;

public class UserDao {	
	public void adiciona(User user) {		
		String sql = "insert into user (nome, user, pass) values (?, ?, SHA1(?))";//Adicionando criptografia
		
		try(Connection connection = new ConnectionFactory().getConnection()) {//try-whith-resources
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getNome());
			statement.setString(2, user.getUser());
			statement.setString(3, user.getPass());
			statement.execute();
			statement.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
