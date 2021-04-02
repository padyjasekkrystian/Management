package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import api.UserDao;
import entity.User;
import entity.parser.UserParser;
import utils.FileUtils;

public class UserDaoImpl implements UserDao{
	
    private static final String fileName = "users.data";
    private static UserDaoImpl instance = null;
    
    private UserDaoImpl() {
    	try {
    		FileUtils.createNewFile(fileName);
    	} catch (IOException e) {
    		System.out.println("Error with file path");
    		//exit zamyka appke
    		System.exit(-1);
    	}
    }
    
    public static UserDaoImpl getInstance() {
    	if(instance == null) {
    		instance = new UserDaoImpl();
    	}
    	return instance;
    }

	public void saveUser(User user) throws IOException {
		List<User> users = getAllUsers();
		users.add(user);
		saveUsers(users);
	}

	public void saveUsers(List<User> users) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, true));
		for(User user : users) {
			pw.write(user.toString() + "\n");
		}
		pw.close();
	}

	public List<User> getAllUsers() throws IOException {
		List<User> users = new ArrayList<User>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String readLine = "";
		while ((readLine = br.readLine()) != null) {
			User user = UserParser.stringToUser(readLine);
			if (user != null) {
				users.add(user);
			}
		}
		return users;
	}

	public User getUserByLogin(String login) throws IOException {
		List<User> users = getAllUsers();
		for(User user : users) {
			boolean isFoundUser = user.getLogin().equals(login);
			if(isFoundUser){
				return user;
			}
		}
		return null;
	}

	public User getUserById(int userId) throws IOException {
		List<User> users = getAllUsers();
		for(User user : users) {
			boolean isFoundUser = user.getId() == userId;
			if(isFoundUser){
				return user;
			}
		}
		return null;
	}

	public void removeUserByLogin(String login) throws IOException {
		List<User> users = getAllUsers();
		for(User user : users) {
			boolean isFoundUser = user.getLogin().equals(login);
			if(isFoundUser){
				users.remove(user);
			}
		}
		saveUsers(users);	
	}

	public void removeUserById(int userId) throws IOException {
		List<User> users = getAllUsers();
		for(User user : users) {
			boolean isFoundUser = user.getId() == userId;
			if(isFoundUser){
				users.remove(user);
			}
		}
		saveUsers(users);
	}

}
