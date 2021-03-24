package service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entity.User;
import junit.framework.Assert;

public class UserServiceTest {
	
	@Test
	public void testGetAllUsers() {
		//is
		List<User> users = new ArrayList<User>();
		users.add(new User(1, "admin", "zaq12wsx"));
		users.add(new User(2, "krystian", "1111"));
		//then
		UserServiceImpl userService = new UserServiceImpl(users);
		List<User> usersFromTestClass = userService.getAllUsers();
		//expected
		Assert.assertEquals(users, usersFromTestClass);
	}
	
	@Test
	public void testAddUser() {
		//is
		List<User> users = new ArrayList<User>();
		User user = new User(1, "admin", "zaq12wsx");
		//then
		UserServiceImpl userService = new UserServiceImpl(users);
		userService.addUser(user);
		List<User> usersFromTestClass = userService.getAllUsers();
		//expected
		Assert.assertEquals(users, usersFromTestClass);
	}
	
	@Test
	public void testRemoveUserById() {
		//is
		List<User> users = new ArrayList<User>();
		users.add(new User(1, "admin", "zaq12wsx"));
		users.add(new User(2, "krystian", "1111"));
		//then
		UserServiceImpl userService = new UserServiceImpl(users);
		userService.removeUserById(1);
		users.remove(0);
		List<User> usersFromTestClass = userService.getAllUsers();
		//expected
		Assert.assertEquals(users, usersFromTestClass);
	}
	
	
	
	
}
