package crud;

import java.util.List;
import java.util.Scanner;

public class Editar {
	static Scanner sc = new Scanner(System.in);
	
	public static void editar(List<Cliente> lista) {
		Cliente buscar = Search.Search(lista);
		
		 if(buscar != null) {
			 	System.out.println("----------------Cliente sendo alterado----------------");
	   			System.out.println("Cliente: " + buscar.nome + ", idade: " + buscar.idade + ", CPF: " + buscar.cpf);
	   			System.out.println("E-mail: " + buscar.email);
	   			System.out.println("Endereço: " + buscar.endereco);
	   			System.out.println("------------------------------------------------------");
	   			System.out.println();
		 }

		int indice = 0;
		if(buscar != null) {
           do {
        	   System.out.println("** Use 1 para modificar o nome do cliente");
               System.out.println("** Use 2 para modificar a idade do cliente");
               System.out.println("** Use 3 para modificar o e-mail do cliente");
               System.out.println("** Use 4 para alterar o endereço do cliente");
               System.out.println("** Use 5 para voltar ao menu principal");
               
              indice = sc.nextInt();
              
	          switch (indice){
	            	case 1:
	            		System.out.println("Digite o novo nome: ");
	            		sc.nextLine();
	            		buscar.nome = sc.nextLine();
	            		System.out.println("");
	            		break;
	            	case 2: 
	            		System.out.println("Digite a idade: ");
	            		buscar.idade = sc.nextInt();
	            		System.out.println("");
	            		break;
	            	case 3:
	            		System.out.println("Digite o novo email: ");
	            		mudarEmail(buscar);
	            		System.out.println("");
	            		break;
	            	case 4: 
	            		System.out.println("Digite o novo endereço: ");
	            		sc.nextLine();
	            		buscar.endereco = sc.nextLine();
	            		System.out.println("");
	            		break;
	            }
           } while( indice != 5);
		} else {	
			System.out.println("Cliente não encontrado.");
		}
	}
	
	public static void mudarEmail(Cliente alterar) {
		String email;
		do {
			System.out.println("Insira o novo e-mail: ");
			email = sc.next();
			if(!email.contains("@") && !email.contains(".com")) {	
				System.out.println("e-mail inválido, tente novamente.");
			}
		} while(!email.contains("@") && !email.contains(".com"));
		alterar.email = email;
		System.out.println();
	}
}
