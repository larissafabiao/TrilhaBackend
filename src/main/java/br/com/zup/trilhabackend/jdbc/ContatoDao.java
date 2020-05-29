package br.com.zup.trilhabackend.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.zup.trilhabackend.client.Client;

public class ContatoDao {
	//Conexão com o banco de dados
	private Connection connection;

	public ContatoDao() {
		try {
			this.connection = new ConnectionFactory().createConnection();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert(Client client) {
		String sql = "insert into clients " + "(cpf,name,age,email,address)" + " values (?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, client.getCpf());
			stmt.setString(2, client.getName());
			stmt.setInt(3, client.getAge());
			stmt.setString(4, client.getEmail());
			stmt.setString(5, client.getAddress());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Client getClient(String cpf){
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from clients where cpf=?");
			stmt.setString(1, cpf);

			ResultSet rs = stmt.executeQuery();

			if(rs != null && rs.next()) {
				Client client = new Client(rs.getString("cpf"), rs.getString("name"), rs.getInt("age"), rs.getString("email"), rs.getString("address"));
				rs.close();
				stmt.close();
				return client;
			} 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	public void edit(Client clients) {
		String sql = "update clients set name=?, age=?, email=?, " +
				"address=? where cpf=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, clients.getName());
			stmt.setInt(2, clients.getAge());
			stmt.setString(3, clients.getEmail());
			stmt.setString(4, clients.getAddress());
			stmt.setString(5, clients.getCpf());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(String cpf) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from clients where cpf=?");
			stmt.setString(1, cpf);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
