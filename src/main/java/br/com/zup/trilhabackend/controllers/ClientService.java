package br.com.zup.trilhabackend.controllers;

import java.util.HashMap;
import java.util.Map;

import br.com.zup.trilhabackend.client.Client;
import br.com.zup.trilhabackend.jdbc.ContatoDao;

public class ClientService {
	
	Map<Long, Client> listClient = new HashMap<Long, Client>();
	//ContatoDao dao = new ContatoDao();
	
	//métodos de validação dos dados lidos
	public String validateCpf(String cpf) {
		if(cpf.length() != 11) {
			cpf = "invalid";
		}
		return cpf;
	}
	
	public String validateName(String name) {
		if(!name.contains(" ")) {
			name = "invalid";
		}
		return name;
	}
	
	public int validateAge(int age) {
		if(age < 0) {
			age = -1; //inválido
		}
		return age;
	}
	
	public String validateEmail(String email) {
		if(!email.contains("@") && !email.contains(".com")) {	
			email = "invalid";
		}
		return email;
	}	
	
	public String validateAddress(String address) {
		if(!address.contains(" ")) {
			address = "invalid";
		}
		return address;
	}
	
	
	//métodos para executar as ações básicas com o cliente
	public void insert(Client client) {
		Client newClient = new Client();
		newClient = client;
		Long key = Long.valueOf(newClient.getCpf());
		//dao.insert(newClient);
		listClient.put(key,newClient);
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
	
	public void edit(Client client) {
		Client wanted = search(client.getCpf());
    	wanted.setName(client.getName());
    	wanted.setAddress(client.getAddress());
    	wanted.setEmail(client.getEmail());
    	wanted.setAge(client.getAge());
   	}
}
