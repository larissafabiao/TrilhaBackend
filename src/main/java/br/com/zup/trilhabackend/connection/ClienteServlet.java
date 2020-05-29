package br.com.zup.trilhabackend.connection;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.zup.trilhabackend.client.Client;
import br.com.zup.trilhabackend.controllers.ClientService;


@WebServlet(urlPatterns = "/Clientes/*", name = "loja-marvel")
public class ClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 3993201784881460345L;
	ClientService ctrl =  new ClientService();

	//M�todo GET para ler um cliente espec�fico
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		try {
			//pegando o cpf da URL
			String uri = req.getRequestURI();
			int indexParam = uri.lastIndexOf("/");
			String cpf = uri.substring(indexParam + 1);

			cpf = ctrl.validateCpf(cpf);

			PrintWriter printWriter = resp.getWriter();

			resp.setContentType("application/json");

			if(cpf == "invalid") {
				printWriter.print("CPF inv�lido");
			} else {
				Gson gson = new Gson();
				Client wanted = ctrl.search(cpf);
				if (wanted != null) {
					printWriter.print(gson.toJson(wanted));
					//printWriter.print(url);
				} else {
					printWriter.print("Cliente n�o encontrado");
				}
			}	    	
		} catch (IOException e) {
			System.out.println("Cliente inv�lido ou n�o encontrado");
			e.printStackTrace();
		}
	}

	//M�todo POST para inserir um cliente
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//BufferedReader br;

		Client clientToBeInserted = new Client();

		Gson gson = new Gson();

		clientToBeInserted = gson.fromJson(new InputStreamReader(req.getInputStream()), Client.class);
		System.out.println(clientToBeInserted);

		String cpf = ctrl.validateCpf(clientToBeInserted.getCpf());
		String name = ctrl.validateName(clientToBeInserted.getName());
		int age = ctrl.validateAge(clientToBeInserted.getAge());
		String email = ctrl.validateEmail(clientToBeInserted.getEmail());
		String address = ctrl.validateAddress(clientToBeInserted.getAddress());

		resp.setContentType("application/json");
		PrintWriter printWriter = resp.getWriter();
		if (cpf == "invalid" || name == "invalid" || email == "invalid" || age == -1 || address == "invalid" ) {
			printWriter.print("Cliente inv�lido, n�o inserido.");
		} else {
			ctrl.insert(clientToBeInserted);
			printWriter.print("Cliente inserido");
		}
	}

	//M�todo PUT para editar as informa��es de um cliente
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//pegando o cpf da URL
		String uri = req.getRequestURI();
		int indexParam = uri.lastIndexOf("/");
		String cpf = uri.substring(indexParam + 1);

		//Pegando o JSON do request
		Client clientToBeInserted = new Client();
		Gson gson = new Gson();

		clientToBeInserted = gson.fromJson(new InputStreamReader(req.getInputStream()), Client.class);

		String cpfFromJson = ctrl.validateCpf(clientToBeInserted.getCpf());
		String name = ctrl.validateName(clientToBeInserted.getName());
		int age = ctrl.validateAge(clientToBeInserted.getAge());
		String email = ctrl.validateEmail(clientToBeInserted.getEmail());
		String address = ctrl.validateAddress(clientToBeInserted.getAddress());

		//compara��o para checar se ambos os cpfs s�o os mesmos
		int compareTo = cpf.compareTo(cpfFromJson);

		resp.setContentType("application/json");
		PrintWriter printWriter = resp.getWriter();
		if (cpfFromJson == "invalid" || compareTo != 0|| name == "invalid" || email == "invalid" || age == -1 || address == "invalid" ) {
			printWriter.println("Cliente inv�lido, n�o inserido.");
			printWriter.print("cpf=" + cpf + ", cpfFromJson= " + cpfFromJson + ", compareTo=" + compareTo);
		} else {
			ctrl.edit(clientToBeInserted);
			printWriter.print("Cliente portador do cpf: "+ cpf +" atualizado");
		}
	}

	//M�todo DELETE para deletar um cliente espec�fico
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		int indexParam = uri.lastIndexOf("/");

		String cpf = uri.substring(indexParam + 1);
		cpf = ctrl.validateCpf(cpf);

		PrintWriter printWriter = resp.getWriter();

		resp.setContentType("application/json");

		if (cpf == "invalid") {
			printWriter.print("CPF inv�lido");
		} else {
			ctrl.remove(cpf);
			printWriter.print("Cliente portador do cpf: "+ cpf +" foi removido");
		}
	}
}
