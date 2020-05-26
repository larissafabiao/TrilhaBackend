package br.com.zup.trilhabackend.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletResponse;

import br.com.zup.trilhabackend.client.Client;

public class Controller {
	
	static Scanner sc = new Scanner(System.in);
	
	Map<Long, Client> listClient = new HashMap<Long, Client>();

	//métodos de leitura dos dados
	public String insertCpf(String cpf, int type) {
		int size = cpf.length() - type;
    	cpf = cpf.substring(10, size);
		if(cpf.length() != 11) {
			cpf = "invalid";
		}
		return cpf;
	}
	
	public String insertName(String name) {
		int size = name.length() -2;
    	name = name.substring(11, size);
		return name;
	}
	
	public int insertAge(String age) {
		int size = age.length() - 2;
    	age = age.substring(10, size);
    	int ageInt = Integer.parseInt(age);
		return ageInt;
	}
	
	public String insertEmail(String email) {
		int size = email.length() - 2;
    	email = email.substring(12, size);
		if(!email.contains("@") && !email.contains(".com")) {	
			email = "invalid";
		}
		return email;
	}	
	
	public String insertAddress(String address) {
		int size = address.length() - 1;
    	address = address.substring(13,size);
		return address;
	}
	
	
	//métodos para executar as ações básicas
	public void insert(String cpf, String name, int age, String email, String addres) {
		Client c = new Client(cpf, name, age, email, addres);
		Long key = Long.valueOf(cpf);
		listClient.put(key,c);
	}
	
	public void printOne(Client wanted,  HttpServletResponse resp) throws IOException {
		if(wanted != null) {
			printClient(wanted, resp);
		} else {	
			System.out.println("Cliente não encontrado.");
		}
	}
	
	void printClient(Client client, HttpServletResponse resp) throws IOException {
		PrintWriter printWriter = resp.getWriter();
        printWriter.println("CPF :: " + client.getCpf());
        printWriter.println("Name :: " + client.getName());
        printWriter.println("Age :: " + client.getAge());
        printWriter.println("Email :: " + client.getEmail());
        printWriter.println("Addres :: " + client.getAddress());
	}
	
	public Client search(String cpf) {
		Client wanted =  null;
		Long key = Long.valueOf(cpf);
		if (listClient.containsKey(key)) {
			wanted = listClient.get(key);
		}
		return wanted;
	}
	
	public void remove(String cpf) {
		Long key = Long.valueOf(cpf);
		listClient.remove(key);
	}
	
	public void edit(String cpf, String name, int age, String email, String address) {
		Client wanted = search(cpf);
    	wanted.setName(name);
    	wanted.setAddress(address);
    	wanted.setEmail(email);
    	wanted.setAge(age);
   	}
}
