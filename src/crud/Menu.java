package crud;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		List<Cliente> lista = new LinkedList<>();
				
		int indice = 0;
		Scanner sc = new Scanner(System.in);
        do {
        	System.out.println("------------------------------------------------------------");
            System.out.println("Olá, utilize os seguintes comandos: ");
            System.out.println("* Use 1 para inserir um novo cliente");
            System.out.println("* Use 2 para visualizar todos os clientes");
            System.out.println("* Use 3 para visualizar um cliente específico");
            System.out.println("* Use 4 para remover um cliente");
            System.out.println("* Use 5 para editar um cliente");
            System.out.println("* Use 6 para encerrar o programa");
            System.out.println("------------------------------------------------------------");

            indice = sc.nextInt();
            
            
            switch (indice){
                case 1:
                    Inserir.insere(lista);
            		break;
                case 2:
                    ShowAll.printAll(lista);
                    break;
                case 3:
                    ShowOne.find(lista);
                    break;
              
                case 4:
                	if(Remove.remove(lista)) {
                		System.out.println("Cliente removido");
                	}else {
                			System.out.println("Cliente não encontrado");
                	}
                    break;
                case 5:
                	Editar.editar(lista);
            }

        } while ( indice != 6 );
	}

}
