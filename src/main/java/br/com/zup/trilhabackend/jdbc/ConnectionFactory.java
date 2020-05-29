package br.com.zup.trilhabackend.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionFactory {
	final static Logger logger = Logger.getLogger(ConnectionFactory.class);

	public Connection createConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/helloworld?serverTimezone=UTC"; //Nome da base de dados
		String user = "root"; //nome do usuário do MySQL
		String password = "admin"; //senha do MySQL
		
		Connection connection = null;
		connection = DriverManager.getConnection(url, user, password);
		
		if (connection == null) 
			logger.error("Deu ruim");
		
		return connection;
	}
}