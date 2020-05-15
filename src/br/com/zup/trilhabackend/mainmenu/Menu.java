package br.com.zup.trilhabackend.mainmenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.zup.trilhabackend.client.Client;
import br.com.zup.trilhabackend.controllers.Controller;
import br.com.zup.trilhabackend.connection.*;
public class Menu {
	static Scanner sc = new Scanner(System.in);
	static Controller ctrl =  new Controller();
	
	public static void main(String[] args) throws SQLException {
		              
		int command = 0;
		do {
			System.out.println("------------------------------------------------------------");
			System.out.println("Ol√°, utilize os seguintes comandos: ");
			System.out.println("* Use 1 para inserir um novo cliente");
			System.out.println("* Use 2 para visualizar todos os clientes");
			System.out.println("* Use 3 para visualizar um cliente espec√≠fico");
			System.out.println("* Use 4 para remover um cliente");
			System.out.println("* Use 5 para editar um cliente");
			System.out.println("* Use 6 para encerrar o programa");
			System.out.println("------------------------------------------------------------");

			command = sc.nextInt();

			switch (command) {
			case 1:
				ctrl.insert();
				break;
			case 2:
				ctrl.printAll();;
				break;
			case 3:
				ctrl.printOne(ctrl.search());
				break;

			case 4:
				ctrl.remove();
				break;
			case 5:
				editMenu();
			}

		} while (command != 6);
	}
	
	//mÈtodo para execuÁ„o do menu de ediÁ„o
	static void editMenu() {
		Client wanted = ctrl.search();
		if(wanted != null) {
		 	ctrl.printOne(wanted);
		 	
		 	int command;
		 	do {
		    	   System.out.println("** Use 1 para modificar o nome do cliente");
		           System.out.println("** Use 2 para modificar a idade do cliente");
		           System.out.println("** Use 3 para modificar o e-mail do cliente");
		           System.out.println("** Use 4 para alterar o endere√ßo do cliente");
		           System.out.println("** Use 5 para voltar ao menu principal");
		           
		          command = sc.nextInt();
		          
		          switch (command){
		            	case 1:
		            		ctrl.editName(wanted);
		            		break;
		            	case 2: 
		            		ctrl.editAge(wanted);
		            		break;
		            	case 3:
		            		ctrl.editEmail(wanted);
		            		break;
		            	case 4: 
		            		ctrl.editAddress(wanted);
		            		break;
		            }
		       } while( command != 5);
		} else {	
			System.out.println("Cliente n√£o encontrado.");
		}		
	}
}
