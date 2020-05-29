package br.com.zup.trilhabackend.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection createConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/helloworld?serverTimezone=UTC"; //Nome da base de dados
		String user = "root"; //nome do usuário do MySQL
		String password = "admin"; //senha do MySQL

		Connection connection = null;
		connection = DriverManager.getConnection(url, user, password);
		 if (connection == null) throw new RuntimeException("Deu ruim");
		return connection;
	}
}