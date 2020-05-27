package br.com.zup.trilhabackend.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {

	public Connection createConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/helloworld?serverTimezone=UTC"; //Nome da base de dados
        String user = "root"; //nome do usuário do MySQL
        String password = "admin"; //senha do MySQL
         
        Connection conexao = null;
        conexao = DriverManager.getConnection(url, user, password);
         
        return conexao;
    }
	
	public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/helloworld?serverTimezone=UTC", "root", "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}