
public class User {
	private String name;
	private String password;
	private boolean isAdmin;

	public User(String name, String password) {
		this.name = name;
		this.password = password;
		isAdmin=false;
	}
	
	public User(String name, String password, boolean admin) {
		this.name = name;
		this.password = password;
		isAdmin=admin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAccess(boolean access) {
		isAdmin=access;
	}

	public boolean isAdmin() {
		return isAdmin;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() { 
		return name+","+password;
	}

	
	
}
