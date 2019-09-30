package br.com.spring.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?useTimezone=true&serverTimezone=UTC", "root", "senha2019");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
