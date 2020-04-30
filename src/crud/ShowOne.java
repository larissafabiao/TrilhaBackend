package crud;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ShowOne {
	public static void find(List<Cliente> lista) {
		
		Cliente buscar = Search.Search(lista);
		
		if(buscar != null) {
			System.out.println("Cliente: " + buscar.nome + ", idade: " + buscar.idade + ", CPF: " + buscar.cpf);
			System.out.println("E-mail: " + buscar.email);
			System.out.println("Endereço: " + buscar.endereco);
			System.out.println("");
		} else {	
			System.out.println("Cliente não encontrado.");
		}
		
	}
}
