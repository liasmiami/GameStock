import java.util.*;
import java.io.*;

public class UserList {

	private ArrayList<User> users= new ArrayList<User>();
	static Scanner in = null;

	public UserList(String file) {
		getDate(file);
	}
	
	public void getDate(String file)
	{
		try {
			in = new Scanner(new File(file)); 
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if ("".equals(line)) {
					continue;
				}
				String[] split = line.split(",");
				String name = split[0];
				String password = split[1]; 
				String adminaccess=split[2];
				User user = new User(name, password, adminaccess.equals("yes"));
				users.add(user);
			}
		} catch (Exception e) {
			System.out.println("Error reading file");
		}
		in.close();
	}
	
	public boolean login(String name, String password) { 
		for (User user : users) {
			if (user.getName().equals(name)&& user.getPassword().equals(password)) {
				return true;
			}
		} 
		return false;
	}

	public boolean addUser(String name, String password) {
		User user = new User(name, password);
		if(isUserExist(name))
		{
			return false;
		}
		users.add(user);
		return true;
	}

	public boolean isUserExist(String name) { 
		for (User user : users) {
			if (user.getName().equals(name)) {
				return true;
			}
		}
		return false;
	} 
	
	public boolean isAdmin(String name, String password) {
		for(User user: users) {
			if(user.getName().equals(name) && user.getPassword().equals(password)) {
				return user.isAdmin();
			}
		}
		return false;
	}

	public void save() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("users.csv"));
		} catch (Exception ex) {
			System.out.println("Error reading file");
		}
		StringBuilder builder = new StringBuilder();
		String access="no";
		for (User user : users) {
			if(user.isAdmin())access="yes";
			builder.append(user.getName() + "," + user.getPassword()+","+access+"\n");
			access="no";
		}
		pw.write(builder.toString());
		pw.close();
	}

}
