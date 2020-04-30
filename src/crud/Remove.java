package crud;

import java.util.List;
import java.util.Scanner;

public class Remove {
	public static boolean remove(List<Cliente> lista) {
		System.out.println("Digite o CPF do cliente que deseja excluir: ");
		Scanner sc = new Scanner(System.in);
		String cpf = sc.nextLine();
	
		int encontrou = 0;
		
		for (Cliente valor : lista) {
			if(valor.cpf.equals(cpf)) {
				lista.remove(valor);
				encontrou = 1;
				break;
			}	
		}
		if(encontrou == 1) {
			return true;
		}
		return false;
	}
	
}
