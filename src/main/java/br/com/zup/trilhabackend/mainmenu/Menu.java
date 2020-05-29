package br.com.zup.trilhabackend.mainmenu;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

import br.com.zup.trilhabackend.client.Client;
import br.com.zup.trilhabackend.controllers.ClientService;
import br.com.zup.trilhabackend.jdbc.ContatoDao;
public class Menu {
	static Scanner sc = new Scanner(System.in);
	static ClientService ctrl =  new ClientService();

	public static void main(String[] args) throws SQLException {
		Client newClient = new Client("49669162831","Luana Fabiao", 24 ,"larissafabiao@gmail.com", "R. Vergueiro 3185 cj57");

		// grave nessa conexão!!!
		ContatoDao dao = new ContatoDao();

		// método elegante
		dao.insert(newClient);

		Map<Long, Client> clients = dao.getLista();

		for (Client client : clients.values()) {
			System.out.println("Cpg: " + client.getCpf());
			System.out.println("Nome: " + client.getName());
			System.out.println("Age: " + client.getAge());
			System.out.println("Email: " + client.getEmail());
			System.out.println("Endereço: " + client.getAddress());
		}

		Client editClient = new Client("49669162800","Larissa", 20 ,"larissa@gmail.com", "R. Vergueiro 3185 cj57");

		dao.altera(editClient);
		System.out.println("Cliente alterado!");

		System.out.println("-------------------------------------------------------------------------------");
		clients = dao.getLista();

		for (Client client : clients.values()) {
			System.out.println("Cpg: " + client.getCpf());
			System.out.println("Nome: " + client.getName());
			System.out.println("Age: " + client.getAge());
			System.out.println("Email: " + client.getEmail());
			System.out.println("Endereço: " + client.getAddress());
		}

		System.out.println("-------------------------------------------------------------------------------");

		dao.remove(editClient);
		// System.out.println("Cliente removido!");
	}
}
