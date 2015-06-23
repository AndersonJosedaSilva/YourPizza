package your.pizza.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import your.pizza.control.ConnectionFactory;
import your.pizza.model.Produto;
import your.pizza.model.Promocao;

public class PromocoesDAO {
	
	private Connection _connection = null;
	
	public Promocao listPromocao(){
		_connection = ConnectionFactory.connect();
		Promocao p = null;
		try {
			String sql = "select * from promocoes  ";
			PreparedStatement ps = _connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				p = new Promocao();
				p.setId(resultSet.getInt("id"));
				p.setName(resultSet.getString("nome"));
				p.setValor(resultSet.getDouble("valor"));
				
				String sqlProdutos = "select * from produtos where promocao_id = ?";
				
				PreparedStatement psProdutos = _connection.prepareStatement(sqlProdutos);
				psProdutos.setInt(1, p.getId().intValue());
				ResultSet resultSetProdutos = psProdutos.executeQuery();
				ArrayList<Produto> produtos = new ArrayList<Produto>();
				while (resultSetProdutos.next()) {
					Produto produto = new Produto();
					produto.setNome(resultSetProdutos.getString("nome"));
					produto.setTipo(resultSetProdutos.getInt("tipo"));
					produtos.add(produto);
				}
				p.setProdutos(produtos);
				resultSetProdutos.close();
				psProdutos.close();
				
			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.disconnect();
		}
		return p;
	}
	
	public void inserirPromocao(Promocao promocao){
		_connection = ConnectionFactory.connect();
		try {
			String sql = "insert into promocoes (nome,valor) VALUES( ?, ?)";
			PreparedStatement ps = _connection.prepareStatement(sql);
			ps.setDouble(1,promocao.getId().doubleValue());
			ps.setString(2, promocao.getName());
			ps.setDouble(3, promocao.getValor().doubleValue());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.disconnect();
		}
	}

}
