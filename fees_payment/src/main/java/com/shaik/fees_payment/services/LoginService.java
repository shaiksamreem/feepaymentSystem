package com.shaik.fees_payment.services;
import com.shaik.fees_payment.dao.UserDao;
import com.shaik.fees_payment.entity.User;


public class LoginService {
	
	public static class UserService {
	    private static UserDao userDao;

	    public UserService() {
	        userDao = new UserDao();
	    }

	    // Login method
	    
	

	public static boolean login(String username, String password) {
		User user = userDao.login(username, password);
		return user != null;
		// TODO Auto-generated method stub
		
	}
	}

	public static boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
