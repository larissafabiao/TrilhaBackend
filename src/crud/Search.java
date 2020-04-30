package crud;

import java.util.List;
import java.util.Scanner;

public class Search {
	public static Cliente Search(List<Cliente> lista) {
		Cliente achei = null;
		String cpf;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Insira o CPF do cliente (somento números e letras): ");
			cpf = sc.next();
			if(cpf.length() != 11) {
				System.out.println("Cpf inválido, por favor tente novamente.");
			}
		} while(cpf.length() != 11);
		
		for (Cliente valor : lista) {
			if(valor.cpf.equals(cpf)) {
				achei = valor;
				break;
			}	
		}
		return achei;	
	}
}
