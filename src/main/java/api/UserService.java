package api;

import java.io.IOException;
import java.util.List;

import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

public interface UserService {
	
	List<User> getAllUsers() throws IOException;
	void addUser(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException, UserLoginAlreadyExistException, IOException;
	void removeUserById(int userId) throws IOException;
	
	

}
