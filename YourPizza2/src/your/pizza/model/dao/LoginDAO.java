package your.pizza.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import your.pizza.control.ConnectionFactory;
import your.pizza.model.User;

public class LoginDAO {
	private Connection _connection = null;

	public User login(String login, String password) {
		_connection = ConnectionFactory.connect();
		User u = null;
		try {
			String sql = "select * from users  where login = ? and password = ? ";
			PreparedStatement ps = _connection.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				u = new User();
				u.setName(resultSet.getString("name"));
				u.setPassword(password);
				u.setLogin(login);
				u.setFunction(resultSet.getString("function"));
			
			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.disconnect();
		}
		return u;
	}
}
