package br.com.zup.trilhabackend.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import br.com.zup.trilhabackend.client.Client;

public class Controller {
	
	static Scanner sc = new Scanner(System.in);
	
	List<Client> listClient = new LinkedList<Client>();

	
	//métodos de leitura dos dados
	String insertCpf() {
		String cpf;
		do {
			System.out.println("Insira o CPF (somento números e letras): ");
			cpf = sc.next();
			if(cpf.length() != 11) {
				System.out.println("Cpf inválido, por favor tente novamente.");
			}
		} while(cpf.length() != 11);
		System.out.println();
		return cpf;
	}
	
	String insertName() {
		System.out.println("Insira o nome do Cliente: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println();
		return name;
	}
	
	int insertAge() {
		System.out.println("Insira a idade do cliente: ");
		int age = sc.nextInt();
		System.out.println();
		return age;
	}
	
	String insertEmail() {
		String email;
		do {
			System.out.println("Insira o e-mail do cliente: ");
			email = sc.next();
			if(!email.contains("@") && !email.contains(".com")) {	
				System.out.println("e-mail inválido, tente novamente.");
			}
		} while(!email.contains("@") && !email.contains(".com"));
		System.out.println();
		return email;
	}	
	
	String insertAddress() {
		System.out.println("Insira o endereço do cliente: ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.println();
		return address;
	}
	
	
	//métodos para executar as ações básicas
	public void insert() {
		String cpf = insertCpf();
		String name = insertName();
		int age = insertAge();
		String email = insertEmail();
		String addres = insertAddress();
		
		Client c = new Client(cpf, name, age, email, addres);
		
		listClient.add(c);
	}
	
	public void printAll() {
		for (Client it : listClient) {
			printClient(it);
		}
	}
	
	public void printOne(Client wanted) {
		if(wanted != null) {
			printClient(wanted);
		} else {	
			System.out.println("Cliente não encontrado.");
		}
	}
	
	void printClient(Client c) {
		System.out.println("-------------------------------------------------");
		System.out.println("Cliente: " + c.getName() + ", idade: " + c.getAge() + ", CPF: " + c.getCpf());
		System.out.println("E-mail: " + c.getEmail());
		System.out.println("Endereço: " + c.getAddress());
		System.out.println("-------------------------------------------------");
	}
	
	public Client search() {
		String cpf = insertCpf();
		Client wanted =  null;
		for (Client valor : listClient) {
			if(valor.getCpf().equals(cpf)) {
				wanted = valor;
				break;
			}	
		}
		return wanted;
	}
	
	public void remove() {
		Client delet = search();
		if (delet != null) {
			System.out.println("Cliente apagado:: ");
			printClient(delet);
			listClient.remove(delet);
		} else {
			System.out.println("Cliente não encontrado.");
		}
	}
	
	
	//métodos para executar a edição dos dados de um cliente
	public void editName(Client change) {
		String newName = insertName();
		change.setName(newName);
	}
	
	public void editAge(Client change) {
		int newAge = insertAge();
		change.setAge(newAge);
	}
	
	public void editEmail(Client change) {
		String newEmail = insertEmail();
		change.setEmail(newEmail);
	}
	
	public void editAddress(Client change) {
		String newAddress = insertAddress();
		change.setAddress(newAddress);
	}
	
}
