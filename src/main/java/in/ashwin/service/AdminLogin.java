package in.ashwin.service;

import java.util.HashMap;

import java.util.Map;

import in.ashwin.validator.UserValidation;

public class AdminLogin {
	private AdminLogin() {

	}

	private static final Map<String, String> adminDetail = new HashMap<>();
	static {
		adminDetail.put("0323100125", "Admin@12345");
		adminDetail.put("0323200126", "Admin@12345");
	}

	public static boolean adminLogin(String consumerNumber, String password) {
		boolean validLogin = false;
		if (UserValidation.isValidConsumerNo(consumerNumber) && UserValidation.isValidPassword(password)
				&& adminDetail.containsKey(consumerNumber)) {
			String adminPassword = adminDetail.get(consumerNumber);
			if (adminPassword.equals(password)) {
				validLogin = true;
			}
		}
		return validLogin;

	}

}