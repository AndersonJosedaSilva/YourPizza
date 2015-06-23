package your.pizza.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import your.pizza.model.User;
import your.pizza.model.dao.UsuarioDAO;

public class Usuario extends HttpServlet {
	
	private static final long serialVersionUID = -396178237825485832L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		User user = new User();
		
			user.setName(request.getParameter("nome"));
			user.setLogin(request.getParameter("login"));
			user.setPassword(request.getParameter("senha"));
			user.setAddress(request.getParameter("endereco"));
			user.setPhone(request.getParameter("telefone"));
			user.setFunction("usuario");
			
//			TODO : TRATAR EXCECOES DO BANCO 
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.inserir(user);
			
			
			out.println("SUCCESS");
			out.close();
		
	}

}
