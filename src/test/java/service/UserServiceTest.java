package service;

import org.junit.Test;

import junit.framework.Assert;

public class UserServiceTest {
	
	@Test
	public void testIsUserExistWhenUserNoExist() {
		//is
		String[] users = { "Damian", "Kamil", "Krystian" };
		UserService userService = new UserService(users);
		//then
		final boolean result = userService.isUserExist("Marek");
		//expected
		Assert.assertFalse(result);
	}
	
	@Test
	public void testIsUserExistWhenUserExist() {
		//is
		String[] users = { "Damian", "Kamil", "Krystian" };
		UserService userService = new UserService(users);
		//then
		final boolean result = userService.isUserExist("Kamil");
		//expected
		Assert.assertTrue(result);
	}

	@Test
	public void testGetUserCountNormal() {
		//is
		String[] users = {"Krystian", "Monika"};
		UserService userService = new UserService(users);
		//then
		final int result = userService.getUsersCount();
		//expected
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void testGetUserCountZero() {
		//is
		String[] users = {};
		UserService userService = new UserService(users);
		//then
		final int result = userService.getUsersCount();
		//expected
		Assert.assertEquals(0, result);
	}
	
	@Test
	public void testCountRepeatsUserWithRepeats() {
		//is
		String[] users = {"Krystian", "Damian", "Damian"};
		UserService userService = new UserService(users);
		//then
		final int result = userService.getLoginRepeats("Damian");
		//expected
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void testCountRepeatsUserWithoutRepeats() {
		//is
		String[] users = {"Krystian", "Damian", "Damian"};
		UserService userService = new UserService(users);
		//then
		final int result = userService.getLoginRepeats("Monika");
		//expected
		Assert.assertEquals(0, result);
	}
	
	
}
