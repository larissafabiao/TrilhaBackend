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

	//Método GET para ler um cliente específico
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
				printWriter.print("CPF inválido");
			} else {
				Gson gson = new Gson();
				Client wanted = ctrl.search(cpf);
				if (wanted != null) {
					printWriter.print(gson.toJson(wanted));
					//printWriter.print(url);
				} else {
					printWriter.print("Cliente não encontrado");
				}
			}	    	
		} catch (IOException e) {
			System.out.println("Cliente inválido ou não encontrado");
			e.printStackTrace();
		}
	}

	//Método POST para inserir um cliente
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
			printWriter.print("Cliente inválido, não inserido.");
		} else {
			ctrl.insert(clientToBeInserted);
			printWriter.print("Cliente inserido");
		}
	}

	//Método PUT para editar as informações de um cliente
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

		//comparação para checar se ambos os cpfs são os mesmos
		int compareTo = cpf.compareTo(cpfFromJson);

		resp.setContentType("application/json");
		PrintWriter printWriter = resp.getWriter();
		if (cpfFromJson == "invalid" || compareTo != 0|| name == "invalid" || email == "invalid" || age == -1 || address == "invalid" ) {
			printWriter.println("Cliente inválido, não inserido.");
			printWriter.print("cpf=" + cpf + ", cpfFromJson= " + cpfFromJson + ", compareTo=" + compareTo);
		} else {
			ctrl.edit(clientToBeInserted);
			printWriter.print("Cliente portador do cpf: "+ cpf +" atualizado");
		}
	}

	//Método DELETE para deletar um cliente específico
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		int indexParam = uri.lastIndexOf("/");

		String cpf = uri.substring(indexParam + 1);
		cpf = ctrl.validateCpf(cpf);

		PrintWriter printWriter = resp.getWriter();

		resp.setContentType("application/json");

		if (cpf == "invalid") {
			printWriter.print("CPF inválido");
		} else {
			ctrl.remove(cpf);
			printWriter.print("Cliente portador do cpf: "+ cpf +" foi removido");
		}
	}
}
