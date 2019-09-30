package br.com.spring.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.spring.domain.Contato;
import br.com.spring.exception.DaoException;
import br.com.spring.factory.ConnectionFactory;

public class ContatoDAO {

	private Connection connection;
	
	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		
		String sql = "insert into contatos " +
	             "(nome,email,endereco,dataNascimento)" +
	             " values (?,?,?,?)";
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getEmail());
			pst.setString(3, contato.getEndereco());
			pst.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<>();
			PreparedStatement stm = connection.prepareStatement("select * from contatos");
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(dataNascimento);
				contatos.add(contato);
				
			}
			stm.close();
			rs.close();
			return contatos;
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public void alterar(Contato contato) {
		 String sql = "update contatos set nome=?, email=?, endereco=?," +
		            "dataNascimento=? where id=?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getEmail());
			stm.setString(3, contato.getEndereco());
			stm.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stm.setLong(5, contato.getId());
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public void remover(Contato contato) {
		try {
			PreparedStatement stm = connection.prepareStatement("delete " +
                "from contatos where id=?");
			stm.setLong(1, contato.getId());
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	}
}
