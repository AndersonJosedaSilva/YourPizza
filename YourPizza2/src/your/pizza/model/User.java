package your.pizza.model;

public class User {

	private String _name = null;
	private String _password = null;
	private String _login = null;
	private String _function = null;
	private String _phone = null;
	private String _address = null;

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public String getLogin() {
		return _login;
	}
	
	public void setLogin(String login) {
		_login = login;
	}
	
	public String getFunction() {
		return _function;
	}
	
	public void setFunction(String function) {
		_function = function;
	}
	
	public String getPhone() {
		return _phone;
	}
	
	public void setPhone(String phone) {
		_phone = phone;
	}
	
	public String getAddress() {
		return _address;
	}
	
	public void setAddress(String address) {
		_address = address;
	}
	
	
}
