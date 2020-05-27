package br.com.zup.trilhabackend.mainmenu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.zup.trilhabackend.controllers.ClientService;
import br.com.zup.trilhabackend.jdbc.connectionFactory;
public class Menu {
	static Scanner sc = new Scanner(System.in);
	static ClientService ctrl =  new ClientService();
	
	public static void main(String[] args) throws SQLException {
		Connection connection = new connectionFactory().createConnection();
	    System.out.println("Conexão aberta!");
	    connection.close();
	}
/*	
	//método para execução do menu de edição
	static void editMenu() {
		//Client wanted = ctrl.search();
		if(wanted != null) {
		 	//ctrl.printOne(wanted);
		 	
		 	int command;
		 	do {
		    	   System.out.println("** Use 1 para modificar o nome do cliente");
		           System.out.println("** Use 2 para modificar a idade do cliente");
		           System.out.println("** Use 3 para modificar o e-mail do cliente");
		           System.out.println("** Use 4 para alterar o endereÃ§o do cliente");
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
			System.out.println("Cliente nÃ£o encontrado.");
		}		
	}*/
}
