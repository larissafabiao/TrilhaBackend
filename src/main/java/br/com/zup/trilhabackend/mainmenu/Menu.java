package br.com.zup.trilhabackend.mainmenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.zup.trilhabackend.controllers.ClientService;
import br.com.zup.trilhabackend.jdbc.connectionFactory;
public class Menu {
	static Scanner sc = new Scanner(System.in);
	static ClientService ctrl =  new ClientService();
	
	public static void main(String[] args) throws SQLException {
		Connection connection = new connectionFactory().createConnection();
	    System.out.println("Conexão aberta!");
	    
	    String sql = "insert into clients " + "(cpf,name,age,email,address) " + "values (?,?,?,?,?)";
	    PreparedStatement stmt = connection.prepareStatement(sql);
	    // preenche os valores
	    stmt.setString(1, "49669162831");
	    stmt.setString(2, "Larissa Fabiao");
	    stmt.setInt(3, 19);
	    stmt.setString(3, "larissafabiao@gmail.com");
	    stmt.setString(4, "R. Vergueiro 3185 cj57");
	    
	    connection.close();
	}
}
