package your.pizza.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection _connection = null;

	public static Connection connect() {
		if (_connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
				_connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourpizza", "postgres",	"abc123");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return _connection;
	}

	public static void disconnect() {
		if (_connection != null) {
			try {
				_connection.close();
				_connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}