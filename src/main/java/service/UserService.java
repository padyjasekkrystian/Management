package service;

public class UserService {
	
	String [] users;

	public UserService(String[] users) {
		this.users = users;
	}
	
	//czy user istnieje w tablicy
	public boolean isUserExist(String login) {
		for(String user : users) {
			if(user.equals(login)) {
				return true;
			}
		}
		return false;
	}
	
	//ilosc userow w tablicy
	public int getUsersCount() {
		return users.length;
	}
	
	//ilosc powtorzen podanego loginu w tablicy
	public int getLoginRepeats(String login) {
		int count = 0;
		for(String user : users) {
			if(user.equals(login)) {
				count++;
			}
		}
		return count;
	}
	
	

}
