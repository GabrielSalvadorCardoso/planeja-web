package com.ginfohouse.planejaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.ginfohouse.planejaweb.factory.ConnectionFactory;
import com.ginfohouse.planejaweb.model.ContaPoupanca;

public class ContaPoupancaDao {
	public void adiciona(ContaPoupanca poupanca) {
		String insertConta = "insert into conta_poupanca(id_user, taxa_juros, valor) values (?, ?, ?)";
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			//Inserindo valores na tabela 'conta_poupanca'
			PreparedStatement insertContaStatement = connection.prepareStatement(insertConta);
			insertContaStatement.setLong(1, poupanca.getIdUser());
			insertContaStatement.setDouble(2, poupanca.getTaxaJuros());
			insertContaStatement.setDouble(3, poupanca.getValor());
			insertContaStatement.execute();
			insertContaStatement.close();
			connection.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}		
	}
}
