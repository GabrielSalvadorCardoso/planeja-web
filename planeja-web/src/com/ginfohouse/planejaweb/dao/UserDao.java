package com.ginfohouse.planejaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public User usuarioExiste(User user) {
		String sql = "select * from user where user = ? and pass = SHA1(?)";
				
		try(Connection connection = new ConnectionFactory().getConnection()) {
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUser());
			statement.setString(2, user.getPass());
			ResultSet rs = statement.executeQuery();
			
			User usuario = new User();
			if(rs.next()) {
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setUser(rs.getString("user"));
				//Não retornamos a senha do usuario por questão de segurança
			}
			return usuario;			
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
