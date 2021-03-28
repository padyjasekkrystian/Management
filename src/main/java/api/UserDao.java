package api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import entity.User;

public interface UserDao {
	
	void saveUser(User user) throws IOException;
	void saveUsers(List<User> users) throws FileNotFoundException;;
	User getUserByLogin(String login) throws IOException;
	User getUserById(int userId) throws IOException;
	void removeUserByLogin(String login) throws IOException;
	void removeUserById(int userId) throws IOException;

}
