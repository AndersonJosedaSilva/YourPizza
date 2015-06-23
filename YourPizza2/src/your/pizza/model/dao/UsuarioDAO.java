package your.pizza.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import your.pizza.control.ConnectionFactory;
import your.pizza.model.User;

public class UsuarioDAO {
	private Connection _connection = null;

	public void inserir(User user) {
		_connection = ConnectionFactory.connect();
		try {
			String sql = "insert into users (name, password, function, login, phone, address) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = _connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFunction());
			ps.setString(4, user.getLogin());
			ps.setString(5,user.getPhone());
			ps.setString(6, user.getAddress());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.disconnect();
		}
	}
}