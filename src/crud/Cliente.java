package crud;

import java.util.Scanner;

public class Cliente {
		static Scanner sc = new Scanner(System.in);
		String cpf;
	    String nome;
	    int idade;
	    String email;
	    String endereco;
	    
	    
	    public Cliente(String cpf, String nome, int idade, String email, String endereco) {
	 		this.cpf = cpf;
	 		this.nome = nome;
	 		this.idade = idade;
	 		this.email = email;
	 		this.endereco = endereco;
	 	}
}
