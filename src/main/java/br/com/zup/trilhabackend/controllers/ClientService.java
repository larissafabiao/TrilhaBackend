package br.com.zup.trilhabackend.controllers;

public class ClientService {
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
}
