package your.pizza.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import your.pizza.model.dao.ProdutoDAO;

public class Produto extends HttpServlet {
	
	
	private static final long serialVersionUID = -8661751480814767681L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		your.pizza.model.Produto produto = new your.pizza.model.Produto();
		produto.setNome(req.getParameter("nome"));
		produto.setTipo(Integer.parseInt(req.getParameter("tipo")));
		produto.setValor(Double.parseDouble(req.getParameter("valor")));
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.inserirProduto(produto);
		
	}

}
