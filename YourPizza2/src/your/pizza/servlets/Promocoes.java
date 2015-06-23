package your.pizza.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import your.pizza.model.Produto;
import your.pizza.model.Promocao;
import your.pizza.model.dao.PromocoesDAO;

public class Promocoes extends HttpServlet {

	private static final long serialVersionUID = -8256942041969721298L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		PromocoesDAO dao = new PromocoesDAO();
		Promocao promocao = dao.listPromocao();
		
		if(promocao != null){
            out.println("<h1>"+"Nome: "+promocao.getName() +"</h1>");
            for(Produto produto : promocao.getProdutos()){
        	out.println("<h1>"+(produto.getTipo() == 1 ?"Pizza: ":"Bebida: ") +produto.getNome() +"</h1>");
            }
            out.println("<h1>"+"Valor: "+promocao.getValor() +"</h1>");
		}else{
            out.println("<h1>Nenhuma promoção existente</h1>");
		}
		
		out.close();
	}
}
