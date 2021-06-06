package in.ashwin.service;

import in.ashwin.dao.LoginDao;

import in.ashwin.exception.DBException;
import in.ashwin.exception.ServiceException;

public class UserLogin {
	private UserLogin()
	{
		
	}
	public static boolean validLogin(String mobileNumber,String password)
	{
		boolean validLogin=false;
		try {
			LoginDao dao=new LoginDao();
			validLogin = dao.loginDao(mobileNumber,password);
		} catch (DBException e) {
			throw new ServiceException("unable to verify user credentials");
		}
		return validLogin;
		
	}


}
