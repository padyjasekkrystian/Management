package service;

import java.util.List;

import api.UserService;
import entity.User;

public class UserServiceImpl implements UserService {
	
	List<User> users;

	public UserServiceImpl(List<User> users) {
		this.users = users;
	}

	public List<User> getAllUsers() {
		return users;
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void removeUserById(int userId) {
		for(User user : users) {
			if(user.getId() == userId) {
				users.remove(user);
				break;
			}
		}
	}
	
	
	
	

}
