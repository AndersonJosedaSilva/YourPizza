package your.pizza.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import your.pizza.control.ConnectionFactory;
import your.pizza.model.Produto;



public class ProdutoDAO {
	private Connection _connection = null;
	
	public void inserirProduto(Produto produto){
		_connection = ConnectionFactory.connect();
		try {
			String sql = "insert into produtos (nome, tipo, valor) VALUES(?, ?, ?)";
			PreparedStatement ps = _connection.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setInt(2, produto.getTipo() );
			ps.setDouble(3, produto.getValor().doubleValue());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.disconnect();
		}

	}


}
