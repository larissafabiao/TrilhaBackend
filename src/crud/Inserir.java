package crud;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Inserir {
	
	public static void insere(List<Cliente> lista) {
		Scanner sc = new Scanner(System.in);
		
		//inserir CPF
		String cpf;
		do {
			System.out.println("Insira o CPF (somento números e letras): ");
			cpf = sc.next();
			if(cpf.length() != 11) {
				System.out.println("Cpf inválido, por favor tente novamente.");
			}
		} while(cpf.length() != 11);
		System.out.println();
		
		//Inserir nome
		System.out.println("Insira o nome do Cliente: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.println();
		
		//inserir idade
		System.out.println("Insira a idade do cliente: ");
		int idade = sc.nextInt();
		System.out.println();
		
		//inserir e-mail
		String email;
		do {
			System.out.println("Insira o e-mail do cliente: ");
			email = sc.next();
			if(!email.contains("@") && !email.contains(".com")) {	
				System.out.println("e-mail inválido, tente novamente.");
			}
		} while(!email.contains("@") && !email.contains(".com"));
		System.out.println();
		
		//inserir endereço
		System.out.println("Insira o endereço do cliente: ");
		sc.nextLine();
		String endereco = sc.nextLine();
		System.out.println();
		
		Cliente novo = new Cliente(cpf, nome, idade, email, endereco);
		
		lista.add(novo);
	}
	
}
