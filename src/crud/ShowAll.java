package crud;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ShowAll{
	
	public static void printAll(List<Cliente> lista) {
		Iterator<Cliente> it = lista.iterator();
		
		for (Cliente valor : lista) {
			System.out.println("Cliente: " + valor.nome + ", idade: " + valor.idade + ", CPF: " + valor.cpf);
			System.out.println("E-mail: " + valor.email);
			System.out.println("Endereço: " + valor.endereco);
			System.out.println("------------------------------------------------------------------------------");
		}
	}
}
