package your.pizza.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import your.pizza.model.User;
import your.pizza.model.dao.LoginDAO;

public class Login extends HttpServlet {
	   
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String address = null;
		try {
			String login = request.getParameter("login");
			String password =request.getParameter("password");
			LoginDAO loginDAO = new LoginDAO();
			User user = loginDAO.login(login, password);
			if((login == null) || (password == null)){
					address = "erro.html";
				
			}
			
			
			if(user != null){
				
				if("admin".equals(user.getFunction())){
					address = "cadastroProd.html";
				}else if("atendente".equals(user.getFunction())){
					address = "atendente.html";
				}
				else {
					address = "pedido.html";
				}
			}
			
			out.println(address);
		}
		catch(Exception ex) {
//			TODO : TRATAR A EXCECAO OU CRIAR A PAGINA QUE TRATA O ERRO
			 out.println("index.html");
		}finally{
			out.close();
		}
	}
}
