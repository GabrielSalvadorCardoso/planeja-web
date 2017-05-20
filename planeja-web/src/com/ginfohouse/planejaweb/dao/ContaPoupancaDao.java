package com.ginfohouse.planejaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	
	public List<ContaPoupanca> select(Long id) {
		String sql = "select * from conta_poupanca where id_user = ?";
		List<ContaPoupanca> contas = new ArrayList<ContaPoupanca>();
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				//Armazenando cada conta poupanca do banco de dados na lista de contas
				ContaPoupanca cp = new ContaPoupanca();
				cp.setIdConta(rs.getLong("id_conta"));
				cp.setIdUser(rs.getLong("id_user"));
				cp.setTaxaJuros(rs.getFloat("taxa_juros"));
				cp.setValor(rs.getDouble("valor"));
				contas.add(cp);
			}
			
			rs.close();
			statement.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return contas;
	}
}
