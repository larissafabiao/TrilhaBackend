package br.com.zup.trilhabackend.connection;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.json.*;

import br.com.zup.trilhabackend.client.Client;
import br.com.zup.trilhabackend.controllers.Controller;


@WebServlet(urlPatterns = "/teste", name = "testeSer")
public class Servlet extends HttpServlet {

    private static final long serialVersionUID = 3993201784881460345L;
    Controller ctrl =  new Controller();
    String name = "";
	String cpf = "";
	String age = "";
	String email = "";
	String address = "";

	//Método GET para ler um cliente específico
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
    	BufferedReader br;
    	try {
			br = new BufferedReader(new InputStreamReader(req.getInputStream()));
			
			if(br != null) {
				cpf = br.readLine();
				cpf = br.readLine();
			}
			
			cpf = ctrl.insertCpf(cpf, 1);
	    	
			PrintWriter printWriter = resp.getWriter();
			if(cpf == "invalid") {
	    		printWriter.print("CPF inválido");
			} else {
				Client wanted = ctrl.search(cpf);
				if (wanted != null) {
					ctrl.printOne(wanted, resp);
				} else {
					printWriter.print("Cliente não encontrado");
				}
			}	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //Método POST para inserir um cliente
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	BufferedReader br;
    	br = new BufferedReader(new InputStreamReader(req.getInputStream()));
    	if (br != null){
	    	name = br.readLine();
	    	name = br.readLine();
	    	cpf = br.readLine();
	    	age = br.readLine();
	    	email = br.readLine();
	    	address = br.readLine();
    	}
    	
    	cpf = ctrl.insertCpf(cpf, 2);
    	name = ctrl.insertName(name);
    	int ageInt = ctrl.insertAge(age);
    	email = ctrl.insertEmail(email);
    	address = ctrl.insertAddress(address);
    	
    	PrintWriter printWriter = resp.getWriter();
    	if (cpf == "invalid" || email == "invalid") {
    		printWriter.print("Cliente inválido, não inserido.");
    	} else {
    		ctrl.insert(cpf, name, ageInt, email, address);
    		printWriter.print("Cliente inserido");
    	}
    }
    
    //Método PUT para editar as informações de um cliente
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	BufferedReader br;
    	try {
    		br = new BufferedReader(new InputStreamReader(req.getInputStream()));
	    	if (br != null){
	    		
		    	name = br.readLine();
		    	name = br.readLine();
		    	cpf = br.readLine();
		    	age = br.readLine();
		    	email = br.readLine();
		    	address = br.readLine();
	    	}
	    	
	    	cpf = ctrl.insertCpf(cpf, 2);
	    	name = ctrl.insertName(name);
	    	int ageInt = ctrl.insertAge(age);
	    	email = ctrl.insertEmail(email);
	    	address = ctrl.insertAddress(address);
	    	
	    	PrintWriter printWriter = resp.getWriter();

	    	if (cpf == "invalid" || email == "invalid") {
	    		printWriter.print("Cliente inválido, não inserido.");
	    	} else {
	    		ctrl.edit(cpf, name, ageInt, email, address);
		        printWriter.print("Cliente portador do cpf: "+ cpf +" atualizado");
	    	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //Método DELETE para deletar um cliente específico
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	BufferedReader br;
    	br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		if(br != null) {
			cpf = br.readLine();
			cpf = br.readLine();
		}
		cpf = ctrl.insertCpf(cpf, 1);
    	
    	PrintWriter printWriter = resp.getWriter();
    	if (cpf == "invalid") {
    		printWriter.print("CPF inválido");
    	} else {
    		ctrl.remove(cpf);
    	    printWriter.print("Cliente portador do cpf: "+ cpf +" foi removido");
    	}
    }
    
}
