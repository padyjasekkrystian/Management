package api;

import java.util.List;

import entity.User;

public interface UserService {
	
	List<User> getAllUsers();
	void addUser(User user);
	void removeUserById(int userId);
	
	

}
