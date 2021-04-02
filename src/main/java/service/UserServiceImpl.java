package service;

import java.io.IOException;
import java.util.List;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import validator.UserValidator;

public class UserServiceImpl implements UserService {
		
	private static UserServiceImpl instance = null;
	private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();


	public UserServiceImpl() {
	}
	
	public static UserServiceImpl getInstance() {
		if(instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}

	public List<User> getAllUsers() throws IOException {
		return userDao.getAllUsers();
	}

	public void addUser(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException, UserLoginAlreadyExistException, IOException {
		if(userValidator.isValidate(user)) {
			userDao.saveUser(user);
		}
	}

	public void removeUserById(int userId) throws IOException {
		userDao.removeUserById(userId);
	}
	
	
	
	

}
