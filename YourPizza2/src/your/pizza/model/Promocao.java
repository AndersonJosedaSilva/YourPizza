package your.pizza.model;

import java.util.ArrayList;

public class Promocao {
	
	private Number _id = null;
	
	private String _name = null;
	
	private ArrayList<Produto> _produtos = null;
	
	private Number _valor = null;
	
	public Promocao() {
		_produtos = new ArrayList<Produto>();
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public ArrayList<Produto> getProdutos() {
		return _produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		_produtos = produtos;
	}

	public Number getValor() {
		return _valor;
	}

	public void setValor(Number valor) {
		_valor = valor;
	}
	
	public Number getId() {
		return _id;
	}
	
	public void setId(Number id) {
		_id = id;
	}
}
