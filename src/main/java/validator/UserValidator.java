package validator;

import java.io.IOException;

import api.UserDao;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

public class UserValidator {
	
	private final int MIN_LOGIN_LENGTH = 4;
	private final int MIN_PASSWORD_LENGTH = 6;
	
	private static UserValidator instance = null;
	private UserDao userDao = UserDaoImpl.getInstance();
	
	private UserValidator() {
	}
	
	public static UserValidator getInstance() {
		if(instance == null) {
			instance = new UserValidator();
		}
		return instance;
	}
	
	public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException, UserLoginAlreadyExistException {
		if(isPasswordLengthEnough(user.getPassword())) {
			throw new UserShortLengthPasswordException();
		}
		if(isLoginLengthEnough(user.getLogin())) {
			throw new UserShortLengthLoginException();
		}
		if(isLoginAlreadyExist(user.getLogin())) {
			throw new UserLoginAlreadyExistException();
		}
		return true;
	}
	
	private boolean isPasswordLengthEnough(String password) {
		return password.length() >= MIN_PASSWORD_LENGTH;
	}
	
	private boolean isLoginLengthEnough(String login) {
		return login.length() >= MIN_LOGIN_LENGTH;
	}
	
	private boolean isLoginAlreadyExist(String login) {
		User user = null;
		try {
			user = userDao.getUserByLogin(login);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(user == null) {
			return false;
		}
		return true;
	}

}
