package your.pizza.model;

public class Produto {
	
	private String _nome = null;
	
	private int _tipo = 0;
	
	private Number _valor = null;

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public int getTipo() {
		return _tipo;
	}

	public void setTipo(int tipo) {
		_tipo = tipo;
	}

	public Number getValor() {
		return _valor;
	}

	public void setValor(Number valor) {
		_valor = valor;
	}
	
	

}
